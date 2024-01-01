package com.golfpvcc.teamscorerev1.di

import android.content.Context
import androidx.room.Room
import com.golfpvcc.teamscorerev1.database.ScoreCardDatabase
import com.golfpvcc.teamscorerev1.database.dao.CourseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideCourseDao(database: ScoreCardDatabase):CourseDao =
        database.courseDao()

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context:Context
    ): ScoreCardDatabase = Room.databaseBuilder(
        context.applicationContext,
        ScoreCardDatabase::class.java,
        "score_card.db"
    ).build()

}