package com.example.talha.nestedtablayout

import java.nio.file.Files.size
import android.support.v4.app.FragmentPagerAdapter
import com.example.talha.nestedtablayout.NonScrollableVP
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class MainTabs:AppCompatActivity() {

    lateinit var mainPager: NonScrollableVP
    lateinit var tabs: TabLayout
    lateinit var tb: Toolbar

//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        var view = LayoutInflater.from(context).inflate(R.layout.main_tab_layout,container,false)
//        mainPager = view.findViewById(R.id.pagerMain);
//        tabs = view.findViewById(R.id.tabs);
//       // tb = view.findViewById(R.id.toolbar);
//       // setSupportActionBar(tb)
//        setUpPager();
//        return view
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_tab_layout)
        mainPager = findViewById(R.id.pagerMain) as NonScrollableVP
        tabs = findViewById(R.id.tabs) as TabLayout
        tb = findViewById(R.id.toolbar_layout) as Toolbar
        setSupportActionBar(tb)
        setUpPager()
    }



    private fun setUpPager() {

        val news = MainNewsList()
        val extraList = MainExtraList()
        val adapter = MainPager(supportFragmentManager)
        adapter.addFragment(news, "NEWS")
        adapter.addFragment(extraList, "EXTRA")

        mainPager.setAdapter(adapter)
        tabs.setupWithViewPager(mainPager)

    }

    private inner class MainPager(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        internal var mFragments: MutableList<Fragment> = ArrayList()
        internal var mFragmentsTitle: MutableList<String> = ArrayList()

        fun addFragment(f: Fragment, s: String) {
            mFragments.add(f)
            mFragmentsTitle.add(s)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            Log.d("mylog", mFragmentsTitle[position])
            return mFragmentsTitle[position]
        }

        override fun getItem(position: Int): Fragment {
            return mFragments[position]
        }

        override fun getCount(): Int {
            return mFragments.size
        }
    }
}