package com.golfpvcc.teamscorerev1.presentation.courseDetailScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.room.PrimaryKey
import com.golfpvcc.teamscorerev1.database.records.CourseRecord
import com.golfpvcc.teamscorerev1.domain.use_cases.AddUpdateUseCase
import com.golfpvcc.teamscorerev1.domain.use_cases.GetCourseByIdUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CourseDetailViewModel @AssistedInject constructor(
    private val addUseCase: AddUpdateUseCase,
    private val getCourseByIdUseCase: GetCourseByIdUseCase,
    @Assisted private val course_Id: Int
) : ViewModel() {
    var state by mutableStateOf(CourseDetailState())
        private set
    val isUpdatingCourse: Boolean
        get() = state.m_CourseName.isEmpty()
    private val courseRecord: CourseRecord
        get() = state.run {
            CourseRecord(
                m_CourseName = "",
                m_HolesPar = "",
                m_HolesHandicap = "",
                m_State = "FL",
                m_Id = 0
            )
        }

    private fun initialize() {
        val isUpdatingCourse = course_Id != -1
        state = state.copy(isUpdateCourse = isUpdatingCourse)

        if (isUpdatingCourse) {
            getCourseId()
        }
    }

    private fun getCourseId() = viewModelScope.launch {
        getCourseByIdUseCase(course_Id).collectLatest { course ->
            state = state.copy(
                m_Id = course.m_Id,
                m_HolesPar = course.m_HolesPar,
                m_State = course.m_State,
                m_HolesHandicap = course.m_HolesHandicap,
                m_CourseName = course.m_CourseName

            )
        }
    }

    fun onCourseNameChange (courseName: String){
        state = state.copy(m_CourseName = courseName)
    }
    fun onStateChange (stateUs: String){
        state = state.copy(m_State = stateUs)
    }

    fun addorUpdate() = viewModelScope.launch {
        addUseCase(courseRecord = courseRecord)
    }
}


data class CourseDetailState(
    val m_CourseName: String = "",   // this is the database key for this course in the CourseListRecord class
    val m_HolesPar: String = "",    // Par for the holes are in this format #p,p,p,... for 18 holes - It's easier to store the data in the database.
    val m_HolesHandicap: String = "", //Handicap record is the same has the Par String record
    val m_State: String = "",
    val m_Id: Int? = 0,
    val isUpdateCourse: Boolean = false
)

class DetailCourseViewModelFactory(
    private val course_Id: Int,
    private val assistedFactory: DetailAssistedFactory
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return assistedFactory.create(course_Id) as T
    }
}


@AssistedFactory
interface DetailAssistedFactory {
    fun create(course_id: Int): CourseDetailViewModel
}