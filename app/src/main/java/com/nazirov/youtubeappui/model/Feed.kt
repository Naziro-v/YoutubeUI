package com.nazirov.youtubeappui.model

class Feed(var profile:Int, var photo:Int, private var subShorts: List<ShortFeed?>?) {

    fun getSubShorts(): List<ShortFeed?>? {
        return subShorts
    }

    fun setSubShorts(subShorts: List<ShortFeed?>) {
        this.subShorts = subShorts
    }

}