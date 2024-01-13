package com.golfpvcc.teamscorerev1.presentation.navigation


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

import androidx.compose.ui.Modifier

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.golfpvcc.teamscorerev1.presentation.courseDetailScreen.CourseDetailScreen
import com.golfpvcc.teamscorerev1.presentation.courseDetailScreen.DetailAssistedFactory
import com.golfpvcc.teamscorerev1.presentation.courseScreen.CourseListScreen
import com.golfpvcc.teamscorerev1.presentation.courseScreen.CourseViewMode


enum class Screens {
    CourseList, CourseDetail
}

@Composable
fun TeamScoreNavigation(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    courseViewMode: CourseViewMode,
    courseDetailViewMode: CourseViewMode,
    assistedFactory: DetailAssistedFactory
) {
    NavHost(
        navController = navHostController,
        startDestination = Screens.CourseList.name
    ) {
        composable(route = Screens.CourseList.name) {
            val state by courseViewMode.state.collectAsState()
            CourseListScreen(
                state = state,
                onDeleteCourse = courseViewMode::deleteCourse,
                onCourseClicked = {
                    navHostController.navigateToSingleTop(
                        route = "${Screens.CourseDetail.name}?$it"
                    )
                })
        }

        composable(route = Screens.CourseDetail.name){
            val state by courseDetailViewMode.state.collectAsState()
            CourseDetailScreen(modifier = , course_Id = , assistedFactory = ) {
                
            }
        }

    }


}


fun NavHostController.navigateToSingleTop(route: String) {
    navigate(route) {
        popUpTo(graph.findStartDestination().id) { saveState = true }
        launchSingleTop = true
        restoreState = true
    }
}