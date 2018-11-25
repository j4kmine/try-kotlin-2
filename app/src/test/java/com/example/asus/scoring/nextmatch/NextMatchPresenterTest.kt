package com.example.asus.scoring.nextmatch

import com.example.asus.scoring.TestContextProvider
import com.example.asus.scoring.api.ApiRepository
import com.example.asus.scoring.match.MatchView
import com.example.asus.scoring.match.nextmatch.NextMatchPresenter
import com.example.asus.scoring.model.Event
import com.example.asus.scoring.model.EventResponse
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class NextMatchPresenterTest{
    @Mock
    private
    lateinit var view: MatchView

    @Mock
    private
    lateinit var gson: Gson

    @Mock
    private
    lateinit var apiRepository: ApiRepository

    private lateinit var presenter: NextMatchPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = NextMatchPresenter(view, apiRepository, gson, TestContextProvider())
    }

    @Test
    fun testGetTeamList() {
        val event: MutableList<Event> = mutableListOf()
        val response = EventResponse(event)
        val league = "4328"

        GlobalScope.launch {
            Mockito.`when`(
                gson.fromJson(
                    apiRepository
                        .doRequest(ApiRepository.TheSportApiDb.getMatchNext(league)).await(),
                    EventResponse::class.java
                )
            ).thenReturn(response)

            presenter.getNextEvent(league)

            Mockito.verify(view).showLoading()
            Mockito.verify(view).showEventList(event)
            Mockito.verify(view).hideLoading()
        }
    }
}