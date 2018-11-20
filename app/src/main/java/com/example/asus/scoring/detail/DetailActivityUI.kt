package com.example.asus.scoring.detail

import android.view.Gravity
import android.view.Menu
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import com.example.asus.scoring.R
import com.example.asus.scoring.api.ApiRepository
import com.example.asus.scoring.invisible
import com.example.asus.scoring.model.Team
import com.example.asus.scoring.visible
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class DetailActivityUI(
                        var _IdEvent:String?=""
                        ,var _Home:String?=""
                        ,var _Away:String?=""
                        ,var _intHomeScore:String?=""
                       ,var _intAwayScore:String?=""
                       ,var _strHomeGoalDetails:String?=""
                       ,var _strAwayGoalDetails:String?=""
                       ,var _strHomeLineupGoalkeeper:String?=""
                       ,var _strHomeLineupDefense:String?=""
                       ,var _strHomeLineupMidfield:String?=""
                        ,var _strHomeLineupForward:String?=""
                        ,var _strHomeLineupSubstitutes:String?=""
                        ,var _strAwayLineupGoalkeeper:String?=""
                        ,var _strAwayLineupDefense:String?=""
                        ,var _strAwayLineupMidfield:String?=""
                        ,var _strAwayLineupForward:String?=""
                        ,var _strAwayLineupSubstitutes:String?=""

    ): AnkoComponent<DetailActivity>,DetailView {
    private lateinit var progressBar: ProgressBar
    private var teamImg: List<Team> = mutableListOf()
    lateinit var strHomeTeam:TextView
    lateinit var strAwayTeam:TextView
    lateinit var intHomeScore:TextView
    lateinit var intAwayScore:TextView
    lateinit var strHomeGoalDetails:TextView
    lateinit var strAwayGoalDetails:TextView
    lateinit var strHomeLineupGoalkeeper:TextView
    lateinit var strHomeLineupDefense:TextView
    lateinit var strHomeLineupMidfield:TextView
    lateinit var strHomeLineupForward:TextView
    lateinit var strHomeLineupSubstitutes:TextView
    lateinit var strAwayLineupGoalkeeper:TextView
    lateinit var strAwayLineupDefense:TextView
    lateinit var strAwayLineupMidfield:TextView
    lateinit var strAwayLineupForward:TextView
    lateinit var strAwayLineupSubstitutes:TextView
    lateinit var imageshome: ImageView
    lateinit var imagesaway: ImageView
    private lateinit var presenter: DetailPresenter
    private var menuItem: Menu? = null
    private var isFavorite: Boolean = false
    var imgFixedHome:String? = null
    var imgFixedAway:String? = null
    override fun createView(ui: AnkoContext<DetailActivity>): View = with(ui) {
        relativeLayout {
            progressBar =progressBar {
            }.lparams {
                centerHorizontally()
            }
            lparams(matchParent, wrapContent)
            scrollView {
                lparams(matchParent, wrapContent)
                linearLayout {
                    lparams(matchParent, wrapContent)
                    padding = dip(16)
                    gravity = Gravity.CENTER
                    orientation = LinearLayout.VERTICAL
                    linearLayout{
                        lparams(matchParent, wrapContent)
                        gravity = Gravity.CENTER
                        orientation = LinearLayout.HORIZONTAL
                        imagesaway=imageView {
                            id = R.id.detaillogoAway
                            setImageResource(R.drawable.ic_launcher_background)
                        }.lparams(width= 300) {
                            padding = dip(0)
                            margin = dip(5)
                            height = 300
                        }
                        intAwayScore =  textView {
                            id= R.id.detailawayScore
                            text="0"
                            textSize =60f
                        }.lparams{
                            gravity = Gravity.CENTER
                            padding =0
                            setMargins(0,0,50,0)
                        }
                        textView {
                            text="vs"
                            textSize =25f
                        }.lparams{
                            gravity = Gravity.CENTER
                            padding =16
                        }
                        intHomeScore = textView {
                            id= R.id.detailHomeScore
                            text="0"
                            textSize =60f
                        }.lparams{
                            gravity = Gravity.CENTER
                            padding =16
                            setMargins(50,0,0,0)
                        }
                        imageshome = imageView {
                            id = R.id.detaillogoHome
                            setImageResource(R.drawable.ic_launcher_background)
                        }.lparams(width= 300) {
                            padding = dip(0)
                            margin = dip(5)
                            height = 300
                        }

                    }
                    linearLayout {
                        lparams(matchParent, wrapContent)
                        padding = dip(16)
                        gravity = Gravity.CENTER
                        orientation = LinearLayout.HORIZONTAL
                        strHomeTeam = textView {
                            id= R.id.homes
                            text="-"
                            textSize =16f
                            gravity = Gravity.RIGHT
                        }.lparams(500){
                            padding =16
                            setMargins(0,0,50,0)
                        }
                        textView {
                            text="Team"
                            textSize =16f
                        }.lparams{
                            gravity = Gravity.CENTER
                            padding =16
                        }
                        strAwayTeam = textView {
                            id= R.id.aways
                            text="-"
                            textSize =16f
                        }.lparams(500){
                            gravity = Gravity.RIGHT
                            padding =16
                            setMargins(50,0,0,0)

                        }
                    }
                    linearLayout {
                        lparams(matchParent, wrapContent)
                        padding = dip(16)
                        gravity = Gravity.CENTER
                        orientation = LinearLayout.HORIZONTAL
                        strAwayGoalDetails = textView {
                            id= R.id.detailawayGoal
                            text="-"
                            textSize =16f
                        }.lparams(500){
                            padding =16
                            setMargins(0,0,50,0)
                        }
                        textView {
                            text="Goal"
                            textSize =16f
                        }.lparams{
                            gravity = Gravity.LEFT
                            padding =16
                        }
                        strHomeGoalDetails = textView {
                            id= R.id.detailhomeGoal
                            text="-"
                            textSize =16f
                        }.lparams(500){
                            gravity = Gravity.RIGHT
                            padding =16
                            setMargins(50,0,0,0)

                        }
                    }
                    linearLayout {
                        lparams(matchParent, wrapContent)
                        padding = dip(16)
                        gravity = Gravity.CENTER
                        orientation = LinearLayout.HORIZONTAL
                        strAwayLineupGoalkeeper= textView {
                            id= R.id.detailawayShoot
                            text="-"
                            textSize =16f
                        }.lparams(500){
                            padding =16
                            setMargins(0,0,50,0)
                        }
                        textView {
                            text="Shoot"
                            textSize =16f
                        }.lparams{
                            gravity = Gravity.LEFT
                            padding =16
                        }
                        strHomeLineupGoalkeeper = textView {
                            text="-"
                            textSize =16f
                        }.lparams(500){
                            id= R.id.detailhomeShoot
                            gravity = Gravity.RIGHT
                            padding =16
                            setMargins(50,0,0,0)

                        }
                    }
                    linearLayout {
                        lparams(matchParent, wrapContent)
                        padding = dip(16)
                        gravity = Gravity.CENTER
                        orientation = LinearLayout.HORIZONTAL
                        strAwayLineupGoalkeeper = textView {
                            id= R.id.detailawayGoalKeeper
                            text="-"
                            textSize =16f
                        }.lparams(500){
                            padding =16
                            setMargins(0,0,50,0)
                        }
                        textView {
                            text="GoalKeeper"
                            textSize =16f
                        }.lparams{
                            gravity = Gravity.LEFT
                            padding =16
                        }
                        strHomeLineupGoalkeeper = textView {
                            text="-"
                            textSize =16f
                        }.lparams(500){
                            id= R.id.detailhomeGoalKeeper
                            gravity = Gravity.RIGHT
                            padding =16
                            setMargins(50,0,0,0)

                        }
                    }
                    linearLayout {
                        lparams(matchParent, wrapContent)
                        padding = dip(16)
                        gravity = Gravity.CENTER
                        orientation = LinearLayout.HORIZONTAL
                        strAwayLineupDefense = textView {
                            id= R.id.detailawayDefense
                            text="-"
                            textSize =16f
                        }.lparams(500){
                            padding =16
                            setMargins(0,0,50,0)
                        }
                        textView {
                            text="Defense"
                            textSize =16f
                        }.lparams{
                            gravity = Gravity.LEFT
                            padding =16
                        }
                        strHomeLineupDefense = textView {
                            text="-"
                            textSize =16f
                        }.lparams(500){
                            id= R.id.detailhomeDefense
                            gravity = Gravity.RIGHT
                            padding =16
                            setMargins(50,0,0,0)

                        }
                    }
                    linearLayout {
                        lparams(matchParent, wrapContent)
                        padding = dip(16)
                        gravity = Gravity.CENTER
                        orientation = LinearLayout.HORIZONTAL
                        strAwayLineupMidfield = textView {
                            id= R.id.detailawayMidfield
                            text="-"
                            textSize =16f
                        }.lparams(500){
                            padding =16
                            setMargins(0,0,50,0)
                        }
                        textView {
                            text="Midfield"
                            textSize =16f
                        }.lparams{
                            gravity = Gravity.LEFT
                            padding =16
                        }
                        strHomeLineupMidfield = textView {
                            text="-"
                            textSize =16f
                        }.lparams(500){
                            id= R.id.detailhomeMidfield
                            gravity = Gravity.RIGHT
                            padding =16
                            setMargins(50,0,0,0)

                        }
                    }
                    linearLayout {
                        lparams(matchParent, wrapContent)
                        padding = dip(16)
                        gravity = Gravity.CENTER
                        orientation = LinearLayout.HORIZONTAL
                        strAwayLineupForward = textView {
                            id= R.id.detailawayForward
                            text="-"
                            textSize =16f
                        }.lparams(500){
                            padding =16
                            setMargins(0,0,50,0)
                        }
                        textView {
                            text="Forward"
                            textSize =16f
                        }.lparams{
                            gravity = Gravity.LEFT
                            padding =16
                        }
                        strHomeLineupForward = textView {
                            text="-"
                            textSize =16f
                        }.lparams(500){
                            id= R.id.detailhomeForward
                            gravity = Gravity.RIGHT
                            padding =16
                            setMargins(50,0,0,0)

                        }
                    }
                    linearLayout {
                        lparams(matchParent, wrapContent)
                        padding = dip(16)
                        gravity = Gravity.CENTER
                        orientation = LinearLayout.HORIZONTAL
                        strHomeLineupSubstitutes = textView {
                            id= R.id.detailawaySubstitutes
                            text="-"
                            textSize =16f
                        }.lparams(500){
                            padding =16
                            setMargins(0,0,50,0)
                        }
                        textView {
                            text="Substitutes"
                            textSize =16f
                        }.lparams{
                            gravity = Gravity.LEFT
                            padding =16
                        }
                        strAwayLineupSubstitutes = textView {
                            text="-"
                            textSize =16f
                        }.lparams(500){
                            id= R.id.detailhomeSubstitutes
                            gravity = Gravity.RIGHT
                            padding =16
                            setMargins(50,0,0,0)

                        }
                    }
                    if( _Home != "null"){
                        strHomeTeam.text = _Home
                    }
                    if( _Away != "null") {
                        strAwayTeam.text = _Away
                    }
                    if(_intAwayScore != "null") {
                        intHomeScore.text = _intAwayScore
                    }
                    if(_intHomeScore != "null") {
                        intAwayScore.text = _intHomeScore
                    }
                    if(_strHomeGoalDetails != "null") {
                        strHomeGoalDetails.text = _strHomeGoalDetails
                    }
                    if(_strAwayGoalDetails != "null") {
                        strAwayGoalDetails.text =_strAwayGoalDetails
                    }
                    if(_strHomeLineupGoalkeeper != "null") {
                        strHomeLineupGoalkeeper.text = _strHomeLineupGoalkeeper
                    }
                    if(_strHomeLineupDefense != "null") {
                        strHomeLineupDefense.text = _strHomeLineupDefense
                    }
                    if(_strHomeLineupMidfield != "null") {
                        strHomeLineupMidfield.text = _strHomeLineupMidfield
                    }
                    if(_strHomeLineupForward != "null") {
                        strHomeLineupForward.text = _strHomeLineupForward
                    }
                    if(_strHomeLineupSubstitutes != "null") {
                        strHomeLineupSubstitutes.text = _strHomeLineupSubstitutes
                    }
                    if(_strAwayLineupGoalkeeper != "null") {
                        strAwayLineupGoalkeeper.text = _strAwayLineupGoalkeeper
                    }
                    if(_strAwayLineupDefense != "null") {
                        strAwayLineupDefense.text = _strAwayLineupDefense
                    }
                    if(_strAwayLineupMidfield != "null") {
                        strAwayLineupMidfield.text = _strAwayLineupMidfield
                    }
                    if(_strAwayLineupForward != "null") {
                        strAwayLineupForward.text =_strAwayLineupForward
                    }
                    if(_strAwayLineupSubstitutes != "null") {
                        strAwayLineupSubstitutes.text =_strAwayLineupSubstitutes
                    }


                }
                val request = ApiRepository()
                val gson = Gson()
                presenter = DetailPresenter(this@DetailActivityUI,request,gson)
                presenter.getImage(_Home,_Away)
            }

        }

    }

    override fun showLoading() {
        progressBar.visible()
    }

    override fun hideLoading() {
        progressBar.invisible()
    }

    override fun showImage(home: List<Team>, away: List<Team>) {
        Picasso.get().load(home.component1().logo).into(imagesaway)
        Picasso.get().load(away.component1().logo).into(imageshome)
    }
}
