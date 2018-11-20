package com.example.asus.scoring.model

data class FavoriteTeam(
    val id:Long?
    ,val idEvent:String?=""
    ,val dateEvent:String?=""
    ,val Home:String?=""
    ,val Away:String?=""
    ,val intHomeScore:String?=""
    ,val intAwayScore:String?=""
    ,val strHomeGoalDetails:String?=""
    ,val strAwayGoalDetails:String?=""
    ,val strHomeLineupGoalkeeper:String?=""
    ,val strHomeLineupDefense:String?=""
    ,val strHomeLineupMidfield:String?=""
    ,val strHomeLineupForward:String?=""
    ,val strHomeLineupSubstitutes:String?=""
    ,val strAwayLineupGoalkeeper:String?=""
    ,val strAwayLineupDefense:String?=""
    ,val strAwayLineupMidfield:String?=""
    ,val strAwayLineupForward:String?=""
    ,val strAwayLineupSubstitutes:String?=""

){
    companion object {
        const val TABLE_FAVORITE_TEAM: String = "TABLE_FAVORITE_TEAM"
        const val ID: String = "ID_"
        const val ID_EVENT: String = "ID_EVENT"
        const val DATE_EVENT: String = "DATE_EVENT"
        const val HOME: String = "HOME"
        const val AWAY: String = "AWAY"
        const val INT_HOME_SCORE: String = "INT_HOME_SCORE"
        const val INT_AWAY_SCORE: String = "INT_AWAY_SCORE"
        const val STR_HOME_GOAL_DETAILS: String = "STR_HOME_GOAL_DETAILS"
        const val STR_AWAY_GOAL_DETAILS: String = "STR_AWAY_GOAL_DETAILS"
        const val STR_HOME_LINEUP_GOALKEEPER: String = "STR_HOME_LINEUP_GOALKEEPER"
        const val STR_HOME_LINEUP_DEFENSE: String = "STR_HOME_LINEUP_DEFENSE"
        const val STR_HOME_LINEUP_MIDFIELD: String = "STR_HOME_LINEUP_MIDFIELD"
        const val STR_HOME_LINEUP_FORWARD: String = "STR_HOME_LINEUP_FORWARD"
        const val STR_HOME_LINEUP_SUBTITUTES: String = "STR_HOME_LINEUP_SUBTITUTES"
        const val STR_AWAY_LINEUP_GOALKEEPER: String = "STR_AWAY_LINEUP_GOALKEEPER"
        const val STR_AWAY_LINEUP_DEFENSE: String = "STR_AWAY_LINEUP_DEFENSE"
        const val STR_AWAY_LINEUP_MIDFIELD: String = "STR_AWAY_LINEUP_MIDFIELD"
        const val STR_AWAY_LINEUP_FORWARD: String = "STR_AWAY_LINEUP_FORWARD"
        const val STR_AWAY_LINEUP_SUBTITUTES: String = "STR_AWAY_LINEUP_SUBTITUTES"

    }
}