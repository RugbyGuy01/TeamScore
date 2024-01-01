package com.golfpvcc.teamscorerev1.domain.use_cases

import com.golfpvcc.teamscorerev1.domain.repository.Repository
import javax.inject.Inject

class GetCourseByIdUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(course_id: Int) = repository.getCourseById(course_id)
}