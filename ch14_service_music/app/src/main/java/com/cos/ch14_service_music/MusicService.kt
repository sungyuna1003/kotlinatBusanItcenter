package com.cos.ch14_service_music

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder


class MusicService  : Service(){
    lateinit var mp: MediaPlayer

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

//    override fun onCreate() {
//        super.onCreate()
//        android.util.Log.i("서비스 테스트", "onCreate()")
//        //??
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        mp.stop()
//    }
//
//    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int
//    {
//        mp = MediaPlayer.create(this, R.raw.song1)
//        mp.isLooping = true
//        mp.start()
//
//        return super.onStartCommand(intent, flags, startId)
//    }

    override fun onCreate() {
        android.util.Log.i("서비스 테스트", "onCreate()")
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        android.util.Log.i("서비스 테스트", "onStartCommand()")
        mp = MediaPlayer.create(this, R.raw.song1)
        mp.isLooping = true
        mp.start()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        android.util.Log.i("서비스 테스트", "onDestroy()")
        mp.stop()
        super.onDestroy()
    }
}
