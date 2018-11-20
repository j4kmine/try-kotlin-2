package com.example.asus.scoring.match.pastmatch


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.support.v4.ctx

class PastMatch : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return PastMathcUi().createView(AnkoContext.Companion.create(this@PastMatch.context as Context,this))
    }


}
