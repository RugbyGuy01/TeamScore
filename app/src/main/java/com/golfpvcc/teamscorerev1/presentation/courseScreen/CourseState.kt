package com.golfpvcc.teamscorerev1.presentation.courseScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.golfpvcc.teamscorerev1.common.CourseScreenState
import com.golfpvcc.teamscorerev1.database.records.CourseRecord

val myCourses = listOf(
    CourseRecord(
        m_CourseName = "Pinehurst 1",
        m_HolesHandicap = "",
        m_State = "NC",
        m_HolesPar = "",
        m_Id = 1
    ),
    CourseRecord(
        m_CourseName = "Pinehurst 2",
        m_HolesHandicap = "",
        m_State = "NC",
        m_HolesPar = "",
        m_Id = 1
    ),
    CourseRecord(
        m_CourseName = "Pinehurst 3",
        m_HolesHandicap = "",
        m_State = "NC",
        m_HolesPar = "",
        m_Id = 1
    ),
)
@Preview(showSystemUi = true)
@Composable
fun PrevCourseList() {
    CourseListScreen(
        state = CourseState(CourseScreenState.Sucess(myCourses)
        ),
        onDeleteCourse = {},
        onCourseClicked = {}
    )

}

@Composable
fun CourseListScreen(
    modifier: Modifier = Modifier,
    state: CourseState,
    onDeleteCourse: (Int) -> Unit,
    onCourseClicked: (Int) -> Unit
) {
    when (state.courses) {
        is CourseScreenState.Loading -> {
            CircularProgressIndicator()
        }

        is CourseScreenState.Sucess -> {
            val courses = state.courses.data
            CourseList(
                courses = courses,
                modifier = modifier,
                onDeleteCourse = onDeleteCourse,
                onCourseClicked = onCourseClicked
            )
        }

        is CourseScreenState.Error -> {
            Text(
                text = state.courses.message ?: "Unknown error",
                color = MaterialTheme.colorScheme.error
            )
        }
    }

}

@Composable
private fun CourseList(
    courses: List<CourseRecord>,
    modifier: Modifier,
    // added callback lambda
    onDeleteCourse: (Int) -> Unit,
    onCourseClicked: (Int) -> Unit
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        contentPadding = PaddingValues(4.dp),
        modifier = modifier
    ) {
        itemsIndexed(courses) { index, course ->
            CourseCard(
                index = index,
                course = course,
                modifier = modifier,
                onDeleteCourse = onDeleteCourse,
                onCourseClicked = onCourseClicked
            )
        }
    }
} // end of detail function

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseCard(
    index: Int,
    course: CourseRecord,
    modifier: Modifier,
    // added callback lambda
    onDeleteCourse: (Int) -> Unit,
    onCourseClicked: (Int) -> Unit
) {
    val isEvenIndex = index % 2 == 0
    val shape = when {
        isEvenIndex -> {
            RoundedCornerShape(
                topStart = 50f,
                bottomEnd = 50f
            )
        }

        else -> {
            RoundedCornerShape(
                topEnd = 50f,
                bottomStart = 50f
            )
        }
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        shape = shape
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)

        ) {
            Text(
                text = course.m_CourseName,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = "State: ${course.m_State}",
                style = MaterialTheme.typography.bodyMedium
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { onDeleteCourse(course.m_Id) }) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = null
                    )
                }
                IconButton(onClick = { onCourseClicked(course.m_Id) }) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = null
                    )
                }
            }
        }
    }
}
