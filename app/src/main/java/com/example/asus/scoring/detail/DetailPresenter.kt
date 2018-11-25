package com.example.asus.scoring.detail

import com.example.asus.scoring.CoroutineContextProvider
import com.example.asus.scoring.api.ApiRepository
import com.example.asus.scoring.model.TeamResponse
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class DetailPresenter(private val view:DetailView,private val apiRepository: ApiRepository,private val gson: Gson, private val context: CoroutineContextProvider = CoroutineContextProvider()){
    fun getImage(home:String?,away:String?){
        view.showLoading()
        GlobalScope.launch(Dispatchers.Main){
            val home = gson.fromJson(
                apiRepository
                    .doRequest(ApiRepository.TheSportApiDb.getDetailTeam(home)).await(),
                TeamResponse::class.java
            )
            val away = gson.fromJson(
                apiRepository
                    .doRequest(ApiRepository.TheSportApiDb.getDetailTeam(away)).await(),
                TeamResponse::class.java
            )
            view.hideLoading()
            view.showImage(home.teams,away.teams)
        }
    }
}