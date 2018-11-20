package com.example.asus.scoring.model

import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("strTeamBadge")
    var logo:String? = null
)