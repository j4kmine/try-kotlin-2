package com.example.asus.scoring.match.favoritematch


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.asus.scoring.R.color.colorAccent
import com.example.asus.scoring.db.database
import com.example.asus.scoring.detail.DetailActivity
import com.example.asus.scoring.match.FavoriteMatchAdapter
import com.example.asus.scoring.model.FavoriteTeam
import org.jetbrains.anko.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class FavoriteTeams : Fragment() {
    private var favorites: MutableList<FavoriteTeam> = mutableListOf()
    private lateinit var adapter: FavoriteMatchAdapter
    private lateinit var listFavorite: RecyclerView
    private lateinit var swipeRefresh: SwipeRefreshLayout

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = FavoriteMatchAdapter(favorites){
            context?.startActivity<DetailActivity>(
                "idevent" to "${it.idEvent}",
                "dateevent" to "${it.dateEvent}",
                "home" to "${it.Home}",
                "away" to "${it.Away}",
                "homescore" to "${it.intHomeScore}",
                "awayscore" to "${it.intAwayScore}",
                "awaygoal" to "${it.strAwayGoalDetails}",
                "homegoal" to "${it.strHomeGoalDetails}",
                "homekeeper" to "${it.strHomeLineupGoalkeeper}",
                "awaykeeper" to "${it.strAwayLineupGoalkeeper}",
                "homedefense" to "${it.strHomeLineupDefense}",
                "awaydefense" to "${it.strAwayLineupDefense}",
                "homemidfield" to "${it.strHomeLineupMidfield}",
                "awaymidfield" to "${it.strAwayLineupMidfield}",
                "homeforward" to "${it.strHomeLineupForward}",
                "awayforward" to "${it.strAwayLineupForward}",
                "homesub" to "${it.strHomeLineupSubstitutes}",
                "awaysub" to "${it.strAwayLineupSubstitutes}"

            )
        }
        listFavorite.adapter = adapter
        swipeRefresh.onRefresh {
            showFavorite()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return createView(AnkoContext.create(requireContext()))
    }
    fun createView(ui:AnkoContext<Context>):View = with(ui){
        linearLayout {
            lparams (width = matchParent, height = wrapContent)
            topPadding = dip(16)
            leftPadding = dip(16)
            rightPadding = dip(16)

            swipeRefresh = swipeRefreshLayout {
                setColorSchemeResources(colorAccent,
                    android.R.color.holo_green_light,
                    android.R.color.holo_orange_light,
                    android.R.color.holo_red_light)

                listFavorite = recyclerView {
                    lparams (width = matchParent, height = wrapContent)
                    layoutManager = LinearLayoutManager(ctx)
                }
            }
        }
    }
    override fun onResume() {
        super.onResume()
        showFavorite()
    }

    private fun showFavorite(){
        favorites.clear()
        context?.database?.use {
            swipeRefresh.isRefreshing = false
            val result = select(FavoriteTeam.TABLE_FAVORITE_TEAM)
            val favorite = result.parseList(classParser<FavoriteTeam>())
            favorites.addAll(favorite)
            adapter.notifyDataSetChanged()
        }
    }

}
