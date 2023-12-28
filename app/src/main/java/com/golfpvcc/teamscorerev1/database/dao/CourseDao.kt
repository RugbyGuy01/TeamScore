package com.golfpvcc.teamscorerev1.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.golfpvcc.teamscorerev1.database.records.CourseRecord

import kotlinx.coroutines.flow.Flow

@Dao
interface CourseDao {
    @Upsert // addding or updatin a record
    suspend fun addUpdateCourse(course: CourseRecord)

    @Delete
    suspend fun deleteCourse(course: CourseRecord)

    @Query("Select * FROM course_table ORDER BY m_CourseName ASC")
    fun getAllCoursesAsc(): Flow<List<CourseRecord>>

    @Query("Select * FROM course_table ORDER BY m_CourseName DESC")
    fun getAllCoursesDec(): Flow<List<CourseRecord>>

    @Query("Select * FROM course_table WHERE m_Id =: course_id")
    fun getCourse(course_id: Int): Flow<CourseRecord>

}