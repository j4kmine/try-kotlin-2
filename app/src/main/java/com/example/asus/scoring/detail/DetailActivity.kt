package com.example.asus.scoring.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.setContentView


class DetailActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = intent
        DetailActivityUI(
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
}