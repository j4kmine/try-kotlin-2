package com.example.asus.scoring.home

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.NavigationView
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import com.example.asus.scoring.R
import com.example.asus.scoring.info.InfoFragment
import com.example.asus.scoring.match.nextmatch.NextMatch
import com.example.asus.scoring.match.pastmatch.PastMatch
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var navigationView: NavigationView
    private lateinit var tabLayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        HomeActivityUI().setContentView(this)
        bottomNavigationView = find(R.id.NavigationBottom)
        bottomNavigationView.setOnNavigationItemSelectedListener {item ->
            when(item.itemId){
                R.id.pastBtn ->{
                    loadFragmentsPast(savedInstanceState)
                    supportActionBar?.title ="Past Match"
                }
                R.id.upcomingBtn->{
                    loadFragmentsNext(savedInstanceState)
                    supportActionBar?.title ="Next Match"
                }
                R.id.aboutBtn->{
                    loadFragmentAbout(savedInstanceState)
                    supportActionBar?.title ="About Premier League"
                }

            }
            true
        }

        bottomNavigationView.selectedItemId = R.id.upcomingBtn
    }
    private fun loadFragmentAbout(savedInstanceState: Bundle?){
        if(savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.mainFrame,InfoFragment())
                .commit()
        }
    }
    private fun loadFragmentsNext(savedInstanceState: Bundle?){
        if(savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.mainFrame,NextMatch())
                .commit()
        }
    }
    private fun loadFragmentsPast(savedInstanceState: Bundle?){
        if(savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.mainFrame,PastMatch())
                .commit()
        }
    }

}
