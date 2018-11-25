package com.example.asus.scoring.match.nextmatch

import com.example.asus.scoring.CoroutineContextProvider
import com.example.asus.scoring.api.ApiRepository
import com.example.asus.scoring.match.MatchView
import com.example.asus.scoring.model.EventResponse
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class NextMatchPresenter(private val view:MatchView,private val apiRepository: ApiRepository,private val gson: Gson, private val context: CoroutineContextProvider = CoroutineContextProvider()){
    fun getNextEvent(league:String?){
        view.showLoading()
        GlobalScope.launch(Dispatchers.Main){
            val data = gson.fromJson(
                apiRepository
                    .doRequest(ApiRepository.TheSportApiDb.getMatchNext(league)).await(),
                EventResponse::class.java
            )
            view.hideLoading()
            view.showEventList(data.events)
        }
    }

}