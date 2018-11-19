package com.example.asus.scoring.info

import android.view.View
import android.widget.LinearLayout
import org.jetbrains.anko.*

class InfoUI:AnkoComponent<InfoFragment>{
    override fun createView(ui: AnkoContext<InfoFragment>): View = with(ui) {
        linearLayout {
            lparams(matchParent, wrapContent)
            orientation = LinearLayout.VERTICAL
            textView {
                text ="Premier League"
                textSize = 30f

            }.lparams(){
                padding =30
            }
            textView {
                textSize = 16f
                text="In the 1980s, major English clubs had begun to transform into business ventures, applying commercial principles to club administration. Martin Edwards of Manchester United, Irving Scholar of Tottenham Hotspur, and David Dein of Arsenal were among the leaders in this transformation. It gave top clubs more power. By threatening to break away, clubs in Division One managed to increase their voting power. They took a 50% share of all television and sponsorship income in 1986.[16] Revenue from television also became more important: the Football League received £6.3 million for a two-year agreement in 1986, but by 1988, in a deal agreed with ITV, the price rose to £44 million over four years with the leading clubs taking 75% of the cash.[17][18] The 1988 negotiations were conducted under the threat of ten clubs leaving to form a \"super league\", but they were eventually persuaded to stay with the top clubs taking the lion share of the deal.[17][19][20] As stadiums improved and match attendance and revenues rose, the country's top teams again considered leaving the Football League in order to capitalise on the influx of money into the sport"
            }.lparams {
                padding =30
            }
        }
    }
}