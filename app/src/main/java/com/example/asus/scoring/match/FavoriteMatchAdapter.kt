package com.example.asus.scoring.match

import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.asus.scoring.R
import com.example.asus.scoring.model.FavoriteTeam
import org.jetbrains.anko.*

class FavoriteMatchAdapter(private val event:List<FavoriteTeam>,val actionclick: (FavoriteTeam) -> Unit):RecyclerView.Adapter<FavoriteEventViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): FavoriteEventViewHolder {
        return FavoriteEventViewHolder(FavoriteMatchUI().createView(AnkoContext.Companion.create(p0.context,p0)))
    }

    override fun getItemCount(): Int = event.size

    override fun onBindViewHolder(p0: FavoriteEventViewHolder, p1: Int) {
        p0.bindItem(event[p1],actionclick)

    }
}
class FavoriteMatchUI:AnkoComponent<ViewGroup>{
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui){
            linearLayout {
                lparams(matchParent, wrapContent)
                padding = dip(16)
                gravity = Gravity.CENTER
                orientation = LinearLayout.VERTICAL
                textView {
                    id = R.id.match_date
                    textSize = 16f

                }.lparams{
                    margin = dip(15)
                    gravity = Gravity.CENTER

                }
                linearLayout {
                    gravity = Gravity.CENTER
                    orientation = LinearLayout.HORIZONTAL
                    lparams(matchParent, wrapContent)
                    textView {
                        id = R.id.homeTeam
                        textSize = 16f
                        text="Home Team"

                    }.lparams{
                        margin = dip(5)
                        gravity = Gravity.CENTER

                    }
                    textView {
                        textSize = 16f
                        text="Vs"

                    }.lparams{
                        margin = dip(5)
                        gravity = Gravity.CENTER

                    }
                    textView {
                        id = R.id.awayTeam
                        textSize = 16f
                        text="Away Team"

                    }.lparams{
                        margin = dip(5)
                        gravity = Gravity.CENTER

                    }
                }
                linearLayout {
                    gravity = Gravity.CENTER
                    orientation = LinearLayout.HORIZONTAL
                    lparams(matchParent, wrapContent)
                    textView {
                        id = R.id.homeScore
                        textSize = 16f
                        text="Home Score"

                    }.lparams{
                        margin = dip(5)
                        gravity = Gravity.CENTER

                    }
                    textView {
                        textSize = 16f
                        text="Vs"

                    }.lparams{
                        margin = dip(5)
                        gravity = Gravity.CENTER

                    }
                    textView {
                        id = R.id.awayScore
                        textSize = 16f
                        text="Away Score"

                    }.lparams{
                        margin = dip(5)
                        gravity = Gravity.CENTER

                    }
                }


            }
        }
    }
}
class FavoriteEventViewHolder(view: View):RecyclerView.ViewHolder(view){
    private val homeTeam: TextView = view.find(R.id.homeTeam)
    private val matchDate: TextView = view.find(R.id.match_date)
    private val awayTeam: TextView = view.find(R.id.awayTeam)
    private val homeScore: TextView = view.find(R.id.homeScore)
    private val awayScore: TextView = view.find(R.id.awayScore)
    fun bindItem(event: FavoriteTeam,clickListener: (FavoriteTeam) -> Unit) {
        homeTeam.text = event.Home
        matchDate.text = event.dateEvent
        awayTeam.text = event.Away
        homeScore.text = event.intHomeScore
        awayScore.text = event.intAwayScore
        itemView.setOnClickListener {
            clickListener(event)
        }
    }
}