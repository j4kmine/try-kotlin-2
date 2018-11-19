package com.example.asus.scoring.match

import com.example.asus.scoring.model.Event

interface MatchView {
    fun showLoading()
    fun hideLoading()
    fun showEventList(data:List<Event>)
}