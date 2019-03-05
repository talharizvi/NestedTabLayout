package com.example.talha.nestedtablayout

import android.widget.TextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.support.v7.widget.LinearLayoutManager
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.view.View


class NewsList : Fragment() {

    lateinit var rvNewsList: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rvNewsList = inflater.inflate(R.layout.news_recycler_view, container, false) as RecyclerView
        return rvNewsList
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }




    private fun setUpRecyclerView() {
        val content = ArrayList<String>()
        for (i in 0..4) {
            content.add("content $i")
        }
        rvNewsList.setHasFixedSize(true)
        val lm = LinearLayoutManager(getContext())
        rvNewsList.layoutManager = lm
        val adapter = MySimpleAdapter(content)
        rvNewsList.adapter = adapter
    }

    private inner class MySimpleAdapter(c: List<String>) : RecyclerView.Adapter<MySimpleAdapter.MyViewHolder>() {


        internal var content: MutableList<content> = ArrayList()

        init {
            content.addAll(c)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false)
            return MyViewHolder(v)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.tv.text = "Option" +position
        }

        override fun getItemCount(): Int {
            return content.size
        }

        inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var tv: TextView

            init {
                tv = itemView.findViewById(R.id.tvRv)
            }
        }
    }
}
