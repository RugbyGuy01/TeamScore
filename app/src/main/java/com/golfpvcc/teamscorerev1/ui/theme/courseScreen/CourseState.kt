package com.golfpvcc.teamscorerev1.ui.theme.courseScreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.golfpvcc.teamscorerev1.database.records.CourseRecord

data class CourseState(
    val courseRecs: List<CourseRecord> = emptyList(),
    val m_CourseName: MutableState<String> = mutableStateOf(""),   // this is the database key for this course in the CourseListRecord class
    val m_HolesPar: MutableState<String> = mutableStateOf(""),   // Par for the holes are in this format #p,p,p,... for 18 holes - It's easier to store the data in the database.
    val m_HolesHandicap: MutableState<String> = mutableStateOf(""), //Handicap record is the same has the Par String record
    val m_State: MutableState<String> = mutableStateOf("")
)
