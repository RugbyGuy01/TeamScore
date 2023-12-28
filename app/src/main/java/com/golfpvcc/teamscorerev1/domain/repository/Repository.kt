package com.golfpvcc.teamscorerev1.domain.repository

import com.golfpvcc.teamscorerev1.database.records.CourseRecord
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getAllCourses(): Flow<List<CourseRecord>>
    fun getCourseById(course_Id : Int): Flow<CourseRecord>
    suspend fun addUpdateCourse(courseRec:CourseRecord)
    suspend fun deleteCourse(course_Id:Int)
}