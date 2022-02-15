package com.nazirov.youtubeappui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nazirov.youtubeappui.adapter.FeedAdapter
import com.nazirov.youtubeappui.adapter.FilterAdapter
import com.nazirov.youtubeappui.model.Feed
import com.nazirov.youtubeappui.model.Filter
import com.nazirov.youtubeappui.model.ShortFeed

class MainActivity : AppCompatActivity() {

    lateinit var recyclerFeed: RecyclerView
    lateinit var recyclerFilter: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        recyclerFilter = findViewById(R.id.recyclerFilter)
        recyclerFilter.setLayoutManager(
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )



        recyclerFeed = findViewById(R.id.recyclerFeed)
        recyclerFeed.setLayoutManager(GridLayoutManager(this, 1))

        refreshStoryAdapter(getAllFilters())
        refreshFeedAdapter(getAllFeeds())

    }

    fun refreshStoryAdapter(chats: ArrayList<Filter>) {
        val adapter = FilterAdapter(this, chats)
        recyclerFilter!!.adapter = adapter
    }



    fun refreshFeedAdapter(feeds: ArrayList<Feed>) {
        val adapter = FeedAdapter(this, feeds)
        recyclerFeed!!.adapter = adapter

    }

    fun getAllFilters():ArrayList<Filter> {
        val filters:ArrayList<Filter> = ArrayList()
        filters.add(Filter("Computer Programming"))
        filters.add(Filter("Android Native"))
        filters.add(Filter("Mobile Development"))
        filters.add(Filter("Mobile Development"))
        filters.add(Filter("Mobile Development"))
        return filters
    }


    fun getAllFeeds():ArrayList<Feed> {
        val feed:ArrayList<Feed> = ArrayList()
        feed.add(Feed(R.drawable.img_1,R.drawable.youtube1,null))
        feed.add(Feed(R.drawable.img_1,R.drawable.youtube3,getAllSubFeeds()))
        feed.add(Feed(R.drawable.img_1,R.drawable.youtube2,null))
        feed.add(Feed(R.drawable.img_1,R.drawable.youtube3,null))
        feed.add(Feed(R.drawable.img_1,R.drawable.youtube1,null))
        return feed
    }

    fun getAllSubFeeds():ArrayList<ShortFeed> {
        val shortFeed :ArrayList<ShortFeed> = ArrayList()
        shortFeed.add(ShortFeed(R.drawable.yshort3,"  Mountain biking  ","  1.2 mln marta  "))
        shortFeed.add(ShortFeed(R.drawable.yshort2,"  Super Basketball  ","  958 ming marta  "))
        shortFeed.add(ShortFeed(R.drawable.yshort6,"  Amazing biking  ","  1 mln marta  "))
        shortFeed.add(ShortFeed(R.drawable.yshort4,"  No cold  ","  55.6 ming  "))
        shortFeed.add(ShortFeed(R.drawable.youtubeshort1,"  Be stronger  ","  996 ming  "))
        shortFeed.add(ShortFeed(R.drawable.youtube3,"  Cooking wit us  ","  10.4 mln  "))

        return shortFeed
    }


}