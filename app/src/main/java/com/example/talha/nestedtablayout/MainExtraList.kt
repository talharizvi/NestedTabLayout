package com.example.talha.nestedtablayout

import android.widget.LinearLayout
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View


class MainExtraList : Fragment() {

    lateinit var main: LinearLayout


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        main = inflater.inflate(R.layout.main_extra, container, false) as LinearLayout
        return main
    }

}