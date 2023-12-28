package com.golfpvcc.teamscorerev1.ui.theme.courseScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.golfpvcc.teamscorerev1.database.dao.CourseDao
import com.golfpvcc.teamscorerev1.database.records.CourseRecord
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CourseViewModel(
    private val courseDao: CourseDao
) : ViewModel() {
    private val isSortedByCourseId: MutableStateFlow<Boolean> = MutableStateFlow(true)

    private var courseRecs: Flow<List<CourseRecord>> = isSortedByCourseId.flatMapLatest { sort ->
        if (sort) {
            courseDao.getAllCoursesAsc()
        } else {
            courseDao.getAllCoursesDec()
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
    }

    val _state = MutableStateFlow(CourseState())

    val state =
        combine(_state, isSortedByCourseId, courseRecs) { state, isSortedByCourseId, courseRecs ->
            state.copy(
                courseRecs = courseRecs
            )
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), CourseState())

    fun onEvent(event: CourseEvent) {
        when (event) {
            is CourseEvent.DeleteCourse ->
                viewModelScope.launch {
                    courseDao.deleteCourse(event.m_Id)
                }

            is CourseEvent.SaveCourse -> {
                val courseRecord = CourseRecord(
                    "Test Course", "4,5,4,4,4,4,3,4,4", "1,2,3,4,5,6,7,8,9", "FL"
                )
                viewModelScope.launch {
                    courseDao.addUpdateCourse(courseRecord)
                }
                _state.update {
                    it.copy(
                        m_CourseName = mutableStateOf(""),      //Clear the CourseState
                        m_HolesHandicap = mutableStateOf(""),
                        m_HolesPar = mutableStateOf(""),
                        m_State = mutableStateOf("")
                    )
                }
            }

            CourseEvent.SortCourses -> {
                isSortedByCourseId.value = !isSortedByCourseId.value
            }
        }
    }  // end of when
}

