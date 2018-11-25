package com.example.asus.scoring.detail

import com.example.asus.scoring.TestContextProvider
import com.example.asus.scoring.api.ApiRepository
import com.example.asus.scoring.match.MatchView
import com.example.asus.scoring.match.nextmatch.NextMatchPresenter
import com.example.asus.scoring.model.Event
import com.example.asus.scoring.model.EventResponse
import com.example.asus.scoring.model.Team
import com.example.asus.scoring.model.TeamResponse
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class DetailPresenterTest{
    @Mock
    private
    lateinit var view: DetailView

    @Mock
    private
    lateinit var gson: Gson

    @Mock
    private
    lateinit var apiRepository: ApiRepository

    private lateinit var presenter: DetailPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = DetailPresenter(view, apiRepository, gson, TestContextProvider())
    }

    @Test
    fun testGetTeamList() {
        val home: MutableList<Team> = mutableListOf()
        val away: MutableList<Team> = mutableListOf()
        val response = TeamResponse(home)
        val homeName ="Chelsea"
        val awayName ="Arsenal"

        GlobalScope.launch {
            Mockito.`when`(
                gson.fromJson(
                    apiRepository
                        .doRequest(ApiRepository.TheSportApiDb.getDetailTeam(homeName)).await(),
                    TeamResponse::class.java
                )

            ).thenReturn(response)
            Mockito.`when`(
                gson.fromJson(
                    apiRepository
                        .doRequest(ApiRepository.TheSportApiDb.getDetailTeam(awayName)).await(),
                    TeamResponse::class.java
                )

            ).thenReturn(response)

            presenter.getImage(homeName,awayName)

            Mockito.verify(view).showLoading()
            Mockito.verify(view).showImage(home, away)
            Mockito.verify(view).hideLoading()
        }
    }
}