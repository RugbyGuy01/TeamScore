package com.golfpvcc.teamscorerev1.ui.theme.courseScreen

import com.golfpvcc.teamscorerev1.database.records.CourseRecord

sealed interface CourseEvent  {
    object SortCourses: CourseEvent
    data class DeleteCourse(val m_Id: Int):CourseEvent
    data class SaveCourse(val courseRecord:CourseRecord):CourseEvent
}