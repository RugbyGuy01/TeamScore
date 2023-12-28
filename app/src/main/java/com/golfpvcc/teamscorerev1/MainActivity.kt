package com.golfpvcc.teamscorerev1
// Full Room Database Tutorial - Build Notes App With Room DB Stop 15:40
// https://www.youtube.com/watch?v=5pjdE2wnJ0s&t=203s
// https://github.com/ahmed-guedmioui/Room_Databese_tutorail

// Room database & Jetpack Compose + MVVM Architecture
// https://www.youtube.com/watch?v=voMTReNRvUA
// Stop @36:24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.golfpvcc.teamscorerev1.ui.theme.TeamScoreRev1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TeamScoreRev1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

