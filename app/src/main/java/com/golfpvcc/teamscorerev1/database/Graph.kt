package com.golfpvcc.teamscorerev1.database

import android.content.Context
import com.golfpvcc.teamscorerev1.ui.theme.ScoreCardRepository

object Graph {
    lateinit var db: ScoreCardDatabase
        private set

    val respository by lazy {
        ScoreCardRepository(
            courseDao = db.courseDao(),
            scoreCardDao = db.scoreCardDao()
        )
    }

    fun provide(context: Context) {
        db = ScoreCardDatabase.getDatabase(context)
    }
}