package com.cos.ch10_activity_radio_ex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rdo2 = findViewById<RadioButton>(R.id.rdo2)
        var rdo3 = findViewById<RadioButton>(R.id.rdo3)

        var btn1 = findViewById<Button>(R.id.btn1)

        btn1.setOnClickListener {
            //인텐트 -> 다른 액티비티를 연결하기 위해 -> 전송통로 만들기

            lateinit var intent : Intent  //1. 인텐트 객체 만들기

            if(rdo2.isChecked)
                intent = Intent(applicationContext,  Activity2::class.java ) //2. 인텐트 객체에 (from->to)설정하기
            else if (rdo3.isChecked)
                intent = Intent(applicationContext,  Activity3::class.java )

            //3.인텐트를 보낸다.
            startActivity(intent)

        }

    }
}