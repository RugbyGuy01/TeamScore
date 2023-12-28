package com.golfpvcc.teamscorerev1.database.repository

import com.golfpvcc.teamscorerev1.database.dao.CourseDao
import com.golfpvcc.teamscorerev1.database.records.CourseRecord
import com.golfpvcc.teamscorerev1.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val courseDao: CourseDao
): Repository {  // Vinnie press control I to get these medones
    override fun getAllCourses(): Flow<List<CourseRecord>> {
        return courseDao.getAllCoursesAsc()
    }

    override fun getCourseById(course_Id: Int): Flow<CourseRecord> {
         return courseDao.getCourse(course_Id)
    }

    override suspend fun addUpdateCourse(courseRec: CourseRecord) {
        courseDao.addUpdateCourse(courseRec)
    }

    override suspend fun deleteCourse(course_Id: Int) {
        courseDao.deleteCourse(course_Id)
    }
}