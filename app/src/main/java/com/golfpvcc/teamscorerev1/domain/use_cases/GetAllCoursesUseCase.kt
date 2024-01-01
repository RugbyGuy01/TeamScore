package com.golfpvcc.teamscorerev1.domain.use_cases

import com.golfpvcc.teamscorerev1.database.records.CourseRecord
import com.golfpvcc.teamscorerev1.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCoursesUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(): Flow<List<CourseRecord>> =
        repository.getAllCourses()
}