package com.golfpvcc.teamscorerev1.database

import androidx.room.TypeConverter
import com.golfpvcc.teamscorerev1.database.records.PlayerRecord
import com.golfpvcc.teamscorerev1.database.records.ScoreCardRecord
import com.google.gson.Gson


open class DataConverters {
    @TypeConverter
    fun playerslistToJson(value: List<PlayerRecord>?) = Gson().toJson(value)
    @TypeConverter
    fun jsonToPlayersList(value: String) = Gson().fromJson(value, Array<PlayerRecord>::class.java).toList()

}