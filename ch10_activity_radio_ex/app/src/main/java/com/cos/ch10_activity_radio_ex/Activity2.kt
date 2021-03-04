package com.cos.ch10_activity_radio_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var btn1 = findViewById<Button>(R.id.btn1)
        btn1.setOnClickListener {
            finish() //해당 액티비티 종료
        }
    }
}