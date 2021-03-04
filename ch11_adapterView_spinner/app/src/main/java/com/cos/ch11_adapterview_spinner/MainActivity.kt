package com.cos.ch11_adapterview_spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "스피너 테스트"

        var movie = arrayOf("쿵푸팬더", "짱구는 못말려", "아저씨",
                                            "아바타", "대부", "국가대표",
                                            "토이스토리3", "마당을 나온 암탉", "죽은 시인의 사회",
                                            "서유기")

        var posterID = arrayOf(R.drawable.mov21, R.drawable.mov22, R.drawable.mov23,
                                                R.drawable.mov24, R.drawable.mov25, R.drawable.mov26,
                                                R.drawable.mov27, R.drawable.mov28, R.drawable.mov29,
                                                R.drawable.mov30)

        var spinner = findViewById<Spinner>(R.id.spinner1)

        var adapter: ArrayAdapter<String>
        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, movie)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position1: Int, p3: Long)
            {
                var iv = findViewById<ImageView>(R.id.ivPoster)
                iv.scaleType = ImageView.ScaleType.FIT_CENTER
                iv.setPadding(5,5,5,5)

                iv.setImageResource(posterID[position1])
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }

        // 아래는 틀린 예제... 잘못하면 이렇게 됨!
//        spinner.setOnItemClickListener { adapterView, view, position1, l ->
//
//            var iv = findViewById<ImageView>(R.id.ivPoster)
//            iv.scaleType = ImageView.ScaleType.FIT_CENTER
//            iv.setPadding(5,5,5,5)
//
//            iv.setImageResource(posterID[position1])
//
//        }


    }
}

