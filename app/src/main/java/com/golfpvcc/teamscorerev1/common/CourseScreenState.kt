package com.golfpvcc.teamscorerev1.common

    sealed class CourseScreenState<out T> {
    object Loading:CourseScreenState<Nothing>()
    data class Sucess<T>(val data:T):CourseScreenState<T>()
    data class Error(val message:String?):CourseScreenState<Nothing>()

}