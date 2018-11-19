package com.example.asus.scoring.detail

import com.example.asus.scoring.api.ApiRepository
import com.example.asus.scoring.model.TeamResponse
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class DetailPresenter(private val view:DetailView,private val apiRepository: ApiRepository,private val gson: Gson){
    fun getImage(home:String?,away:String?){
        view.showLoading()
        doAsync {
            val home = gson.fromJson(
                    apiRepository
                    .doRequest(ApiRepository.TheSportApiDb.getDetailTeam(home)),
                    TeamResponse::class.java
            )
            val away = gson.fromJson(
                apiRepository
                    .doRequest(ApiRepository.TheSportApiDb.getDetailTeam(away)),
                TeamResponse::class.java
            )
            uiThread {
                view.hideLoading()
                view.showImage(home.teams,away.teams)
            }

        }
    }
}