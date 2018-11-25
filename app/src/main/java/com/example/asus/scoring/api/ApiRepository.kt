package com.example.asus.scoring.api

import android.net.Uri
import com.example.asus.scoring.BuildConfig
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.net.URL

class ApiRepository{
    fun doRequest(url: String): Deferred<String> = GlobalScope.async {
        URL(url).readText()
    }
    object TheSportApiDb{
        fun getMatchPast(league:String?):String{
            return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("json")
                .appendPath(BuildConfig.TSDB_API_KEY)
                .appendPath("eventspastleague.php")
                .appendQueryParameter("id", league)
                .build()
                .toString()
        }
        fun getDetailTeam(team:String?):String{
            return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("json")
                .appendPath(BuildConfig.TSDB_API_KEY)
                .appendPath("searchteams.php")
                .appendQueryParameter("t", team)
                .build()
                .toString()
        }
        fun getMatchNext(league:String?):String{
            return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("json")
                .appendPath(BuildConfig.TSDB_API_KEY)
                .appendPath("eventsnextleague.php")
                .appendQueryParameter("id", league)
                .build()
                .toString()
        }
    }
}

