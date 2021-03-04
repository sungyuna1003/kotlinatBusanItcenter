package com.example.ch06_tabhost

import android.app.TabActivity
import android.os.Bundle
import android.widget.TabHost
import android.widget.TabHost.TabSpec

@Suppress("deprecation")
class MainActivity : TabActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tabHost = this.tabHost

        var tabCat = tabHost.newTabSpec("CAT").setIndicator("고양이")
        tabCat.setContent(R.id.iv1)
        tabHost.addTab(tabCat)

        var tabDog = tabHost.newTabSpec("DOG").setIndicator("강아지")
        tabDog.setContent(R.id.iv2)
        tabHost.addTab(tabDog)

        var tabHorse = tabHost.newTabSpec("HORSE").setIndicator("말")
        tabHorse.setContent(R.id.iv3)
        tabHost.addTab(tabHorse)

        var tabRabbit = tabHost.newTabSpec("RABBIT").setIndicator("토끼")
        tabRabbit.setContent(R.id.iv4)
        tabHost.addTab(tabRabbit)

        tabHost.currentTab = 1

//        var tabSpecSong = tabHost.newTabSpec("SONG").setIndicator("음악별")
//        tabSpecSong.setContent(R.id.tabSong)
//        tabHost.addTab(tabSpecSong)
//
//        var tabSpecArtist = tabHost.newTabSpec("ARTIST").setIndicator("가수별")
//        tabSpecArtist.setContent(R.id.tabArtist)
//        tabHost.addTab(tabSpecArtist)
//
//        var tabSpecAlbum = tabHost.newTabSpec("ALBUM").setIndicator("앨범별")
//        tabSpecAlbum.setContent(R.id.tabAlbum)
//        tabHost.addTab(tabSpecAlbum)
//
//        tabHost.currentTab = 0
    }
}
