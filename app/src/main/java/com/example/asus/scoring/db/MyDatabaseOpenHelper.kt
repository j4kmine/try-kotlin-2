package com.example.asus.scoring.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.asus.scoring.model.FavoriteTeam
import org.jetbrains.anko.db.*

class MyDatabaseOpenHelper(ctx:Context):ManagedSQLiteOpenHelper(ctx,"FavoriteMatch.db",null,1){
    companion object {
        private var instance: MyDatabaseOpenHelper? = null
        @Synchronized
        fun getInstance(ctx: Context): MyDatabaseOpenHelper {
            if (instance == null) {
                instance = MyDatabaseOpenHelper(ctx.applicationContext)
            }
            return instance as MyDatabaseOpenHelper
        }
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(FavoriteTeam.TABLE_FAVORITE_TEAM, true)
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(
            FavoriteTeam.TABLE_FAVORITE_TEAM, true,
            FavoriteTeam.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            FavoriteTeam.ID_EVENT to TEXT ,
            FavoriteTeam.DATE_EVENT to TEXT ,
            FavoriteTeam.HOME to TEXT ,
            FavoriteTeam.AWAY to TEXT,
            FavoriteTeam.INT_HOME_SCORE to TEXT,
            FavoriteTeam.INT_AWAY_SCORE to TEXT,
            FavoriteTeam.STR_HOME_GOAL_DETAILS to TEXT,
            FavoriteTeam.STR_AWAY_GOAL_DETAILS to TEXT,
            FavoriteTeam.STR_HOME_LINEUP_GOALKEEPER to TEXT,
            FavoriteTeam.STR_HOME_LINEUP_DEFENSE to TEXT,
            FavoriteTeam.STR_HOME_LINEUP_MIDFIELD to TEXT,
            FavoriteTeam.STR_HOME_LINEUP_FORWARD to TEXT,
            FavoriteTeam.STR_HOME_LINEUP_SUBTITUTES to TEXT,
            FavoriteTeam.STR_AWAY_LINEUP_GOALKEEPER to TEXT,
            FavoriteTeam.STR_AWAY_LINEUP_DEFENSE to TEXT,
            FavoriteTeam.STR_AWAY_LINEUP_MIDFIELD to TEXT,
            FavoriteTeam.STR_AWAY_LINEUP_FORWARD to TEXT,
            FavoriteTeam.STR_AWAY_LINEUP_SUBTITUTES to TEXT
        )
    }


}
val Context.database: MyDatabaseOpenHelper
get() = MyDatabaseOpenHelper.getInstance(applicationContext)