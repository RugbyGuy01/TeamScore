package com.golfpvcc.teamscorerev1

import android.app.Application
import com.golfpvcc.teamscorerev1.database.Graph

class ScoreCardApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this  )
    }
}