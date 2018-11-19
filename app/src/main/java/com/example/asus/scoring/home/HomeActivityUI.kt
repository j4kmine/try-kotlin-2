package com.example.asus.scoring.home

import android.view.View
import android.widget.LinearLayout
import com.example.asus.scoring.R
import org.jetbrains.anko.*
import org.jetbrains.anko.design.bottomNavigationView

class HomeActivityUI:AnkoComponent<MainActivity>{
    override fun createView(ui: AnkoContext<MainActivity>): View = with(ui){
       relativeLayout {
           frameLayout {
               id = R.id.mainFrame
           }.lparams(width = matchParent,height = matchParent){
                above(R.id.bottomMenu)
           }
           linearLayout {
                id = R.id.bottomMenu
               orientation = LinearLayout.VERTICAL
               backgroundColor = android.R.color.white
               bottomNavigationView {
                   id = R.id.NavigationBottom
                   itemBackgroundResource = android.R.color.white
                   backgroundColor = android.R.color.white
                   itemTextColor =resources.getColorStateList(R.color.colorAccent)
                   itemIconTintList=resources.getColorStateList(R.color.colorAccent)
                   fitsSystemWindows = true

                   menu.apply {
                       inflateMenu(R.menu.menu)
                   }
               }.lparams(width = matchParent)
           }.lparams(width = matchParent){
               alignParentBottom()
           }
       }
    }
}