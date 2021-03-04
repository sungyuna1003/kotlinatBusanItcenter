package com.cos.ch10_activity_picture_vote

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.result)
        title = "투표 결과"

        //메인 Activity에서 넘어온 인텐트 를 받는다!! 왜냐하면, 안에 (키와 값)이 들어있으므로
        var intent = intent
        var voteResult = intent.getIntArrayExtra("VoteCount")
        var imageName = intent.getStringArrayExtra("ImageName")

        //문제 풀이~!
        val imageFileId = arrayOf(R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9)
        //1.번 득표수가 가장 많은 그림의 배열 인덱스를 찾는다!~!!! (배열안의 최대값 찾기

        //최대값 넣을 변수
//        var maxValue = 0;
//        var maxIndex = 0;
//        for(i in 0..voteResult!!.size-1)
//        {
//            if(voteResult!![i] > maxValue)
//            {
//                maxValue = voteResult[i]
//                maxIndex = i
//            }
//        }

//        var maxValue = 0;
        var maxIndex = 0;
        for(i in 0..voteResult!!.size-1)
        {
            if(voteResult!![i] > voteResult[maxIndex])
            {
//                maxValue = voteResult[i]
                maxIndex = i
            }
        }

        //hint..
        var tvMax = findViewById<TextView>(R.id.tvMax)
        var ivMax = findViewById<ImageView>(R.id.ivMax)

        tvMax.text = imageName!![maxIndex]
        ivMax.setImageResource(imageFileId[maxIndex])



        //step1. 객체 만들기, 9개니까 객체 배열로
        var tv = arrayOfNulls<TextView>(imageName!!.size)
        var rbar = arrayOfNulls<RatingBar>(imageName!!.size)

        //step2. 바인딩
        // 9개의 TextView, RatingBar ID 배열
        var tvID = arrayOf(R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9)
        var rbarID = arrayOf(R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4, R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9)

        for(i in imageName.indices) {
            tv[i] = findViewById<TextView>(tvID[i])
            rbar[i] = findViewById<RatingBar>(rbarID[i])
        }
        //step3. 이벤트처리
        for(i in voteResult!!.indices) {
            tv[i]!!.text = imageName[i]
            rbar[i]!!.setRating(voteResult[i].toFloat())
        }

        var btn1 = findViewById<Button>(R.id.btnReturn)
        btn1.setOnClickListener {
            finish()
        }

    }
}