package com.golfpvcc.teamscorerev1.domain.use_cases

import com.golfpvcc.teamscorerev1.domain.repository.Repository
import javax.inject.Inject

class DeleteCourseUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(course_Id : Int) = repository.deleteCourse(course_Id)
}