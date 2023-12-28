package com.golfpvcc.teamscorerev1.database.records

import androidx.room.Entity
import androidx.room.PrimaryKey


data class PlayerRecord(
    val m_Name: String,
    val m_Handicap: Int,
    val m_Score: String, // Par for the holes are in this format #p,p,p,... for 18 holes - It's easier to store the data in the database.
    val m_Id: Int? = 0
)
