package com.golfpvcc.teamscorerev1.ui.theme

import com.golfpvcc.teamscorerev1.database.dao.CourseDao
import com.golfpvcc.teamscorerev1.database.dao.ScoreCardDao
import com.golfpvcc.teamscorerev1.database.records.CourseRecord
import com.golfpvcc.teamscorerev1.database.records.ScoreCardRecord

class ScoreCardRepository(
    private val courseDao: CourseDao,
    private val scoreCardDao: ScoreCardDao
) {
    suspend fun addUpdateCourse(courseRecord: CourseRecord) {
        courseDao.addUpdateCourse(courseRecord)
    }
    suspend fun addUpdateScoreCardRecord(scoreCardRecord: ScoreCardRecord){
        scoreCardDao.addUpdateScoreCard(scoreCardRecord)
    }
}