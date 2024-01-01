package com.golfpvcc.teamscorerev1.domain.use_cases

import com.golfpvcc.teamscorerev1.database.records.CourseRecord
import com.golfpvcc.teamscorerev1.domain.repository.Repository
import javax.inject.Inject

class AddUpdateUseCase @Inject constructor(
    private val repository: Repository,
) {
    suspend operator fun invoke(courseRecord: CourseRecord) = repository.addUpdateCourse(courseRecord)
}