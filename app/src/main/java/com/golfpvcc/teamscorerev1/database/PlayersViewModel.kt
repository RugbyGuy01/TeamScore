package com.golfpvcc.teamscorerev1.database
//
//import android.app.Application
//import androidx.lifecycle.AndroidViewModel
//import androidx.lifecycle.viewModelScope
//import com.golfpvcc.teamscorerev1.database.records.PlayerRecord
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//
//class PlayersViewModel(application: Application) : AndroidViewModel(application) {
//
//    private val readAllPlayers: List<PlayerRecord>
//    private val repository : ScoreCardRepository
//
//    init {
//        val playerDao = ScoreCardDatabase.getScoreCardDatabase(application).playerDao()
//        repository = ScoreCardRepository(playerDao)
//        readAllPlayers = repository.readAllPlayers
//    }
//
//    fun adPlayer(player: PlayerRecord){
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.addUpdatePlayer(player)
//        }
//    }
//}