package com.cos.ch14_service_music

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var soundIntent: Intent
    lateinit var btnStart: Button
    lateinit var btnStop: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "서비스 테스트 예제"

        soundIntent = Intent(this, MusicService::class.java)
        btnStart = findViewById<Button>(R.id.btnStart)
        btnStop = findViewById<Button>(R.id.btnStop)

        btnStart.setOnClickListener {
            android.util.Log.i("서비스 테스트", "startService()")
            startService(soundIntent)
        }

        btnStop.setOnClickListener {
            stopService(soundIntent)
            android.util.Log.i("서비스 테스트", "stopService()")
        }
    }
}
