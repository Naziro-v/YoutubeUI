package com.nazirov.youtubeappui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerfeed: RecyclerView
    lateinit var recyclerfilter: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        recyclerfilter = findViewById(R.id.recyclerfilter)
        recyclerfilter.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerfeed = findViewById(R.id.recyclerfeed)
        recyclerfeed.layoutManager = GridLayoutManager(this, 1)

        refreshStoryAdapter(gettAllFilters())
        refreshFeedAdapter(gettAllFeeds())

    }

    private fun gettAllFeeds(): ArrayList<Feed> {
        var feeds: ArrayList<Feed> = ArrayList()
        feeds.add(Feed(R.drawable.img_1, R.drawable.youtube3))
        feeds.add(Feed(R.drawable.img_1, R.drawable.youtube1))
        feeds.add(Feed(R.drawable.img_1, R.drawable.youtube2))


        return feeds

    }

    private fun gettAllFilters(): ArrayList<Filter> {
        val filters: ArrayList<Filter> = ArrayList()

        filters.add(Filter("Computer programming"))
        filters.add(Filter("Android Native"))
        filters.add(Filter("Mobile Devolopment"))
        return filters

    }

    private fun refreshStoryAdapter(chats: ArrayList<Filter>) {
        val adapter = FilterAdapter(this, chats)
        recyclerfilter!!.adapter = adapter

    }

    fun refreshFeedAdapter(feeds: ArrayList<Feed>) {
        var adapter = FeedAdapter(this, feeds)
        recyclerfeed!!.adapter = adapter


    }
}