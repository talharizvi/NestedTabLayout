package com.example.talha.nestedtablayout

import java.nio.file.Files.size
import android.support.v4.app.FragmentPagerAdapter
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.widget.LinearLayout
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View


class MainNewsList : Fragment() {

    lateinit var mainLayout: LinearLayout
    lateinit var tabs: TabLayout
    lateinit var vpNews: ViewPager


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mainLayout = inflater.inflate(R.layout.scrollable_tab, container, false) as LinearLayout
        tabs = mainLayout.findViewById(R.id.tabScrollable)
        vpNews = mainLayout.findViewById(R.id.vpNews)
        setUpPager()

        return mainLayout
    }


    private fun setUpPager() {
        val adp = NewsPagerAdapter(this.getFragmentManager()!!)
        val n1 = NewsList()
        val n2 = NewsList()
        val n3 = NewsList()
        val n4 = NewsList()
        val n5 = NewsList()

        adp.addFrag(n1, "World")
        adp.addFrag(n2, "Special")
        adp.addFrag(n3, "International")
        adp.addFrag(n4, "Technology")
        adp.addFrag(n5, "Finance")

        tabs.tabMode = TabLayout.MODE_SCROLLABLE
        vpNews.adapter = adp
        vpNews.offscreenPageLimit = 12
        tabs.setupWithViewPager(vpNews)
    }

    private inner class NewsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        internal var fragList: MutableList<Fragment> = ArrayList()
        internal var titleList: MutableList<String> = ArrayList()

        fun addFrag(f: Fragment, title: String) {
            fragList.add(f)
            titleList.add(title)
        }

        override fun getItem(position: Int): Fragment {
            return fragList[position]
        }

        override fun getCount(): Int {
            return fragList.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }
    }
}