package com.golfpvcc.teamscorerev1

// How to Build a Note App with Jetpack Compose, MVVM, and Clean Architecture
// https://www.youtube.com/watch?v=srp2d3_ofRU&list=PL1YQsimP1H2bH3zppxEB9War9bqMgSDzI&index=50&t=213s
// Stop @204:41
// https://github.com/Hoodlab/Note

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

