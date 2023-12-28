package com.golfpvcc.teamscorerev1.database.records

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.golfpvcc.teamscorerev1.database.records.PlayerRecord

/**
* Created by vinnie on 12/22/2023.
* The score card record contains the current game, course and players.  Each player record contains the name, handicap and scores for each hole.
*/
@Entity(tableName = "score_card_table")
data class ScoreCardRecord (
    val m_CourseName: String,   // // this is the database key for this course in the CourseListRecord class
    val m_MachineState: Int,
    val m_CurrentHole: Int,
    val m_TeamPlayers: List<PlayerRecord>? = null,
    @PrimaryKey(autoGenerate = true)
    val m_Id: Int? = 0
)

object ScoreCardConverter {
    @TypeConverter
    fun toString(playersList: List<PlayerRecord>?): String? {
        if (playersList == null) return null

        val stringList = mutableListOf<String>()
        playersList.forEach {
            stringList.add(it.m_Name)
            stringList.add(it.m_Handicap.toString())
            stringList.add(it.m_Score)
            stringList.add(it.m_Id.toString())
        }

        return stringList.joinToString(",")
    }

    @TypeConverter
    fun toScoreListList(str: String?): List<PlayerRecord>? {
        if (str == null) return null

        val playersList = mutableListOf<PlayerRecord>()

        val strList = str.split(",")
        for (i in strList.indices step 4) {
            playersList.add(PlayerRecord(
                strList[i],                     // m_Name
                strList[i + 1].toInt(),        // m_Handicap
                strList[i + 2],                 // m_Score
                strList[i + 3].toInt()          // m_Id
                ))
        }

        return playersList
    }
}