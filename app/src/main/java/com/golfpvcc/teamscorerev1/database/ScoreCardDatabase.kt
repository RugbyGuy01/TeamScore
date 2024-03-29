package com.golfpvcc.teamscorerev1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.golfpvcc.teamscorerev1.database.dao.CourseDao
import com.golfpvcc.teamscorerev1.database.dao.ScoreCardDao
import com.golfpvcc.teamscorerev1.database.records.CourseRecord
import com.golfpvcc.teamscorerev1.database.records.PlayerRecord
import com.golfpvcc.teamscorerev1.database.records.ScoreCardRecord
@TypeConverters(value = [DataConverters::class])
@Database(
    entities = [CourseRecord::class, ScoreCardRecord::class],
    version = 1,
    exportSchema = true
)

abstract class ScoreCardDatabase: RoomDatabase() {
    abstract fun courseDao(): CourseDao
    abstract fun scoreCardDao(): ScoreCardDao
}