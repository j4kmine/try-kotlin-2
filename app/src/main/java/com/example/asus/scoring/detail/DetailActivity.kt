package com.example.asus.scoring.detail

import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.asus.scoring.R
import com.example.asus.scoring.R.drawable.ic_add_to_favorites
import com.example.asus.scoring.R.drawable.ic_added_to_favorites
import com.example.asus.scoring.db.database
import com.example.asus.scoring.model.FavoriteTeam
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import org.jetbrains.anko.setContentView


class DetailActivity:AppCompatActivity(){
    private var menuItem: Menu? = null
    private var isFavorite: Boolean = false
    private lateinit var swipeRefresh: SwipeRefreshLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = intent
        favoriteState()
        setFavorite()
        DetailActivityUI(
            intent.getStringExtra("idevent"),
            intent.getStringExtra("home"),
            intent.getStringExtra("away"),
            intent.getStringExtra("homescore"),
            intent.getStringExtra("awayscore"),
            intent.getStringExtra("awaygoal"),
            intent.getStringExtra("homegoal"),
            intent.getStringExtra("homekeeper"),
            intent.getStringExtra("awaykeeper"),
            intent.getStringExtra("homedefense"),
            intent.getStringExtra("awaydefense"),
            intent.getStringExtra("homemidfield"),
            intent.getStringExtra("awaymidfield"),
            intent.getStringExtra("homeforward"),
            intent.getStringExtra("awayforward"),
            intent.getStringExtra("homesub"),
            intent.getStringExtra("awaysub")
        ).setContentView(this)



    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.add_to_favorite ->{
                if (isFavorite) removeFromFavorite() else addToFavorite()
                isFavorite = !isFavorite
                setFavorite()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun addToFavorite(){
        try {
            database.use {
                insert(FavoriteTeam.TABLE_FAVORITE_TEAM,
                    FavoriteTeam.ID_EVENT to intent.getStringExtra("idevent"),
                    FavoriteTeam.HOME  to intent.getStringExtra("home"),
                    FavoriteTeam.DATE_EVENT  to intent.getStringExtra("dateevent"),
                    FavoriteTeam.AWAY  to intent.getStringExtra("away"),
                    FavoriteTeam.INT_HOME_SCORE  to intent.getStringExtra("homescore"),
                    FavoriteTeam.INT_AWAY_SCORE  to intent.getStringExtra("awayscore"),
                    FavoriteTeam.STR_HOME_GOAL_DETAILS  to intent.getStringExtra("homegoal"),
                    FavoriteTeam.STR_AWAY_GOAL_DETAILS  to intent.getStringExtra("awaygoal"),
                    FavoriteTeam.STR_HOME_LINEUP_GOALKEEPER  to intent.getStringExtra("homekeeper"),
                    FavoriteTeam.STR_HOME_LINEUP_DEFENSE  to intent.getStringExtra("homedefense"),
                    FavoriteTeam.STR_HOME_LINEUP_MIDFIELD  to intent.getStringExtra("homemidfield"),
                    FavoriteTeam.STR_HOME_LINEUP_FORWARD  to intent.getStringExtra("homeforward"),
                    FavoriteTeam.STR_HOME_LINEUP_SUBTITUTES  to intent.getStringExtra("homesub"),
                    FavoriteTeam.STR_AWAY_LINEUP_GOALKEEPER  to intent.getStringExtra("awaykeeper"),
                    FavoriteTeam.STR_AWAY_LINEUP_DEFENSE  to intent.getStringExtra("awaydefense"),
                    FavoriteTeam.STR_AWAY_LINEUP_MIDFIELD  to intent.getStringExtra("awaymidfield"),
                    FavoriteTeam.STR_AWAY_LINEUP_FORWARD  to intent.getStringExtra("awayforward"),
                    FavoriteTeam.STR_AWAY_LINEUP_SUBTITUTES  to intent.getStringExtra("awaysub")
                )
                Toast.makeText(
                    this@DetailActivity, "Added to Favorite",
                    Toast.LENGTH_LONG).show()

            }
        }catch (e:SQLiteConstraintException){
            Toast.makeText(
                this, e.localizedMessage ,
                Toast.LENGTH_LONG).show()
        }

    }
    private fun removeFromFavorite(){
        try {
            database.use {
                delete(FavoriteTeam.TABLE_FAVORITE_TEAM, "(ID_EVENT = {id})",
                    "id" to intent.getStringExtra("idevent"))
            }
            Toast.makeText(
                this, "Remove Favorite",
                Toast.LENGTH_LONG).show()
        } catch (e: SQLiteConstraintException){
            Toast.makeText(
                this, e.localizedMessage ,
                Toast.LENGTH_LONG).show()
        }
    }
    private fun favoriteState(){
        database.use {
            val result = select(FavoriteTeam.TABLE_FAVORITE_TEAM)
                .whereArgs("(ID_EVENT = {id})",
                    "id" to intent.getStringExtra("idevent"))

            val favorite = result.parseList(classParser<FavoriteTeam>())
            if (!favorite.isEmpty()) isFavorite = true
        }
    }
    private fun setFavorite() {
        if (isFavorite)
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, ic_added_to_favorites)
        else
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, ic_add_to_favorites)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        menuItem = menu
        setFavorite()
        return true
    }

}