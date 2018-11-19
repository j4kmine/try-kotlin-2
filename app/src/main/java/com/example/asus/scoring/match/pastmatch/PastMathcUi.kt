package com.example.asus.scoring.match.pastmatch

import android.content.Context
import android.content.Intent
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import android.widget.Spinner
import com.example.asus.scoring.BuildConfig
import com.example.asus.scoring.R
import com.example.asus.scoring.api.ApiRepository
import com.example.asus.scoring.detail.DetailActivity
import com.example.asus.scoring.invisible
import com.example.asus.scoring.match.MatchAdapter
import com.example.asus.scoring.match.MatchView
import com.example.asus.scoring.model.Event
import com.example.asus.scoring.visible
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class PastMathcUi: AnkoComponent<PastMatch>,MatchView {
    private lateinit var listMatch: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var spinner: Spinner
    private lateinit var adapter: MatchAdapter
    private lateinit var leagueName: String
    private var event: MutableList<Event> = mutableListOf()
    private lateinit var presenter: PastMathcPresenter
    override fun createView(ui: AnkoContext<PastMatch>): View = with(ui) {
        linearLayout {
            lparams(matchParent, wrapContent)
            topPadding = dip(16)
            leftPadding=dip(16)
            rightPadding=dip(16)

                relativeLayout {
                    lparams(width = matchParent,height = wrapContent)
                    listMatch =recyclerView {
                        lparams(width = matchParent,height = wrapContent)
                        id = R.id.NextMatchId
                        layoutManager = LinearLayoutManager(ctx)
                    }
                    progressBar =progressBar {
                    }.lparams {
                        centerHorizontally()
                    }
                }

            adapter = MatchAdapter(event,{item ->onclickme(item,ctx)  })
            listMatch.adapter = adapter
            val request = ApiRepository()
            val gson = Gson()
            presenter = PastMathcPresenter(this@PastMathcUi, request, gson)
            presenter.getPrevEvent(BuildConfig.LEAGUE_ID)

        }
    }
    private fun onclickme(event: Event,context: Context){
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("home", event.homeTeam)
        intent.putExtra("away", event.awayTeam)
        intent.putExtra("homescore", event.homeScore)
        intent.putExtra("awayscore", event.awayScore)
        intent.putExtra("awaygoal", event.awayGoal)
        intent.putExtra("homegoal", event.homeGoal)
        intent.putExtra("homekeeper", event.homeGoalKeeper)
        intent.putExtra("awaykeeper", event.awayGoalKeeper)
        intent.putExtra("homedefense", event.homDefense)
        intent.putExtra("awaydefense", event.awayDefense)
        intent.putExtra("homemidfield", event.homeMidfield)
        intent.putExtra("awaymidfield", event.awayMidfield)
        intent.putExtra("homeforward", event.homeForward)
        intent.putExtra("awayforward", event.awayForward)
        intent.putExtra("homesub", event.homSubtitution)
        intent.putExtra("awaysub", event.awaySubtitution)
        (context).startActivity(intent)
    }
    override fun showLoading() {
        progressBar.visible()
    }

    override fun hideLoading() {
        progressBar.invisible()

    }

    override fun showEventList(data: List<Event>) {
        event.clear()
        event.addAll(data)
        adapter.notifyDataSetChanged()
    }
}