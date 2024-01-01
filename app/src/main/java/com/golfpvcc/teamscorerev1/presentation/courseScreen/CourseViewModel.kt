package com.golfpvcc.teamscorerev1.presentation.courseScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.golfpvcc.teamscorerev1.common.CourseScreenState
import com.golfpvcc.teamscorerev1.database.dao.CourseDao
import com.golfpvcc.teamscorerev1.database.records.CourseRecord
import com.golfpvcc.teamscorerev1.domain.use_cases.AddUpdateUseCase
import com.golfpvcc.teamscorerev1.domain.use_cases.DeleteCourseUseCase
import com.golfpvcc.teamscorerev1.domain.use_cases.GetAllCoursesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CourseViewMode @Inject constructor(
    private val getAllCourseUseCase: GetAllCoursesUseCase,
    private val deleteCOurseUseCaes: DeleteCourseUseCase,
    private val addUpdateUseCase: AddUpdateUseCase
) : ViewModel() {
    private val _state:MutableStateFlow<CourseState> = MutableStateFlow(CourseState())
    val state:StateFlow<CourseState> = _state.asStateFlow()
    init {
        getAllCourses()
    }


    private fun getAllCourses() {
        getAllCourseUseCase()
            .onEach {
                _state.value = CourseState(courses = CourseScreenState.Sucess(it))
            }
            .catch {
                _state.value = CourseState(courses = CourseScreenState.Error(it.message))
            }
            .launchIn(viewModelScope)
    }

    fun deleteCourse(course_Id: Int) = viewModelScope.launch {
        deleteCOurseUseCaes(course_Id)
    }
}

data class CourseState(
    val courses:CourseScreenState<List<CourseRecord>> = CourseScreenState.Loading,
)