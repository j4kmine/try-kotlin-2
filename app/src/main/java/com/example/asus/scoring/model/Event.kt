package com.example.asus.scoring.model

import com.google.gson.annotations.SerializedName

data class Event(
        @SerializedName("idEvent")
        var idEvent:String? = null,
        @SerializedName("strEvent")
        var eventDetail:String? = null,
        @SerializedName("dateEvent")
        var dateEvent:String? = null,
        @SerializedName("strHomeTeam")
        var homeTeam:String? = null,
        @SerializedName("strAwayTeam")
        var awayTeam:String? = null,
        @SerializedName("intHomeScore")
        var homeScore:String? = null,
        @SerializedName("intAwayScore")
        var awayScore:String? = null,
        @SerializedName("strHomeGoalDetails")
        var homeGoal:String? = null,
        @SerializedName("strAwayGoalDetails")
        var awayGoal:String? = null,
        @SerializedName("strHomeLineupGoalkeeper")
        var homeGoalKeeper:String? = null,
        @SerializedName("strHomeLineupDefense")
        var homDefense:String? = null,
        @SerializedName("strHomeLineupMidfield")
        var homeMidfield:String? = null,
        @SerializedName("strHomeLineupForward")
        var homeForward:String? = null,
        @SerializedName("strHomeLineupSubstitutes")
        var homSubtitution:String? = null,
        @SerializedName("strAwayLineupGoalkeeper")
        var awayGoalKeeper:String? = null,
        @SerializedName("strAwayLineupDefense")
        var awayDefense:String? = null,
        @SerializedName("strAwayLineupMidfield")
        var awayMidfield:String? = null,
        @SerializedName("strAwayLineupForward")
        var awayForward:String? = null,
        @SerializedName("strAwayLineupSubstitutes")
        var awaySubtitution:String? = null

    )