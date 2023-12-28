package com.golfpvcc.teamscorerev1.database.records

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "course_table")
data class CourseRecord(
    val m_CourseName: String,   // this is the database key for this course in the CourseListRecord class
    val m_HolesPar: String,    // Par for the holes are in this format #p,p,p,... for 18 holes - It's easier to store the data in the database.
    val m_HolesHandicap: String, //Handicap record is the same has the Par String record
    val m_State: String,
    @PrimaryKey(autoGenerate = true)
    val m_Id: Int? = 0
)
