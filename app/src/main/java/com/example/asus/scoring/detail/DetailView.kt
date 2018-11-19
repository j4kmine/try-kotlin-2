package com.example.asus.scoring.detail

import com.example.asus.scoring.model.Team

interface DetailView {
    fun showLoading()
    fun hideLoading()
    fun showImage(home:List<Team>,away:List<Team>)
}