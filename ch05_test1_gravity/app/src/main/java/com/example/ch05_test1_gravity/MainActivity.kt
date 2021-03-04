package com.example.ch05_test1_gravity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.test1)
        //setContentView(R.layout.test2)
//        setContentView(R.layout.activity_main)

        //1.레이아웃 - 리니어 -> 1)레이아웃 객체와 2)옵션(param)
        var option = LinearLayout.LayoutParams(
                                                LinearLayout.LayoutParams.MATCH_PARENT,
                                                LinearLayout.LayoutParams.MATCH_PARENT)
        var layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        setContentView(layout, option)

        //2.뷰 - 에디트텍스트
        var edt : EditText = EditText(this)
        edt.hint = "글자입니다"
        //뷰를 레이아웃에 꽂는다.
        layout.addView(edt)

        //3.뷰 - 버튼
        var btn : Button = Button(this)
        btn.text = "버튼1"
        btn.setBackgroundColor(Color.YELLOW)
        layout.addView(btn)

        //4.뷰 - 텍스트뷰
        var tv : TextView = TextView(this)
        tv.text = "텍스트뷰입니다."
        tv.setTextColor(Color.RED)
        tv.textSize = 30f
        layout.addView(tv)

        //5. 이벤트처리 -> 버튼에...
        btn.setOnClickListener {
            tv.text = edt.text.toString()
        }
    }
}