package com.golfpvcc.teamscorerev1.presentation.courseDetailScreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Update
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun CourseDetailScreen(
    modifier: Modifier,
    course_Id: Int,
    assistedFactory: DetailAssistedFactory,
    navigateUp: () -> Unit
) {
    val viewModel = viewModel(
        modelClass = CourseDetailViewModel::class.java,
        factory = DetailCourseViewModelFactory(
            course_Id = course_Id,
            assistedFactory = assistedFactory
        )
    )
    val state = viewModel.state
    CourseDetailScreen(
        modifier = modifier,
        isUpdatingCourse = state.isUpdateCourse,
        m_CourseName = state.m_CourseName,
        isFormNotBlank = state.isUpdateCourse,
        onCourseNameChange = viewModel::onCourseNameChange,
        onStateChange ={},
        onNavigateChange = navigateUp,
        onBtnClick = {
            viewModel.addorUpdate()
            navigateUp()
        }
    )

}

@Composable
private fun CourseDetailScreen(
    modifier: Modifier,
    isUpdatingCourse: Boolean,
    m_CourseName: String,   // this is the database key for this course in the CourseListRecord class
    m_HolesPar: String = "",    // Par for the holes are in this format #p,p,p,... for 18 holes - It's easier to store the data in the database.
    m_HolesHandicap: String = "", //Handicap record is the same has the Par String record
    m_State: String = "",
    isFormNotBlank: Boolean,
    onCourseNameChange: (String) -> Unit,
    onStateChange: (String) -> Unit,
    onNavigateChange: () -> Unit,
    onBtnClick: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TopSection(modifier, m_CourseName, m_State, onCourseNameChange, onNavigateChange)
        Spacer(modifier = Modifier.Companion.size(12.dp))
        AnimatedVisibility(visible = isFormNotBlank) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(onClick = onBtnClick) {
                    val icon = if (isUpdatingCourse) Icons.Default.Update
                    else Icons.Default.Check
                    Icon(
                        imageVector = icon,
                        contentDescription = null
                    )
                }

            }
        }

    }
}

@Composable
fun TopSection(
    modifier: Modifier = Modifier,
    courseName: String,
    stateUs: String,
    onCourseNameChange: (String) -> Unit,
    navigateUp: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = navigateUp) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
        }
        CourseTextField(
            modifier.weight(1f),
            courseName,
            onCourseNameChange,
            "Course Name",
            labelAlign = TextAlign.Center
        )
        Text(text = "State: $stateUs")
    }
}

@Composable
fun CourseTextField(
    modifier: Modifier,
    value: String,
    onValueChanged: (String) -> Unit,
    label: String,
    labelAlign: TextAlign? = null
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            disabledContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        placeholder = {
            Text(
                text = "Insert $label",
                textAlign = labelAlign,
                modifier = modifier.fillMaxWidth()
            )
        }
    )
}