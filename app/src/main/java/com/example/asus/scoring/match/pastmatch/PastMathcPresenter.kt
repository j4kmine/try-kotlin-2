package com.example.asus.scoring.match.pastmatch

import com.example.asus.scoring.api.ApiRepository
import com.example.asus.scoring.match.MatchView
import com.example.asus.scoring.model.EventResponse
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class PastMathcPresenter(private val view: MatchView,private val apiRepository: ApiRepository,private val gson: Gson){
    fun getPrevEvent(league:String?){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(
                apiRepository
                    .doRequest(ApiRepository.TheSportApiDb.getMatchPast(league)),
                EventResponse::class.java
            )
            uiThread {
                view.hideLoading()
                view.showEventList(data.events)
            }
        }
    }
}