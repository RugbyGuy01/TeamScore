package com.golfpvcc.teamscorerev1.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.golfpvcc.teamscorerev1.database.records.CourseRecord

import com.golfpvcc.teamscorerev1.database.records.ScoreCardRecord
import kotlinx.coroutines.flow.Flow

@Dao
interface ScoreCardDao {
    @Upsert // addding or updatin a record
    suspend fun addUpdateScoreCard(score_card: ScoreCardRecord)

    @Delete
    suspend fun deleteScoreCard(score_card: ScoreCardRecord)

   @Query("Select * FROM score_card_table WHERE m_Id = :score_card_id")
   fun getPlayer(score_card_id: Int): Flow<ScoreCardRecord>

}