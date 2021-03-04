package com.cos.ch10_activity_picture_vote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        supportActionBar!!.setDisplayShowHomeEnabled(true)
//        supportActionBar!!.setIcon(R.drawable.pici_icon)
        title = "명화 선호도 투표"

        //1.득표수를 닮을 배열을 만든다. 그림 9개 전부에 대해서
        var voteCount = IntArray(9)
        //2.배열 초기화
        for(i in 0..8)
            voteCount[i] = 0

        // 9 개의 객체, 이벤트 처리를 해야한다!
        //step1: 객체 배열 만든다 . 9개 짜리
        var image = arrayOfNulls<ImageView>(9)

        //step2: 바인딩을 위한 이미지뷰 xml ID 배열을 만든다. 9개짜리
        var imageId = arrayOf(R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4,  R.id.iv5, R.id.iv6, R.id.iv7, R.id.iv8 ,  R.id.iv9 )
        //바인딩 findViewById
        //for(i in 0..8)
        //for(i in 0..imageId.size-1)
        for(i in imageId.indices)
            image[i] = findViewById(imageId[i])
//        image[1] = findViewById(imageId[1])
//        image[2] = findViewById(imageId[2])

        //step3: 객체배열원소 [i]  에 각 이벤트 처리

        //그림 이름을 저장할 배열, 출력용
        var imgName = arrayOf("독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀", "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매", "피아노 레슨", "피아노 앞의 소녀들", "해변에서")
        for(i in imageId.indices)
        {
            image[i]!!.setOnClickListener {
                voteCount[i]++ //득표 추가,
                Toast.makeText(this, imgName[i] + " : 총 " + voteCount[i] + " 표", Toast.LENGTH_SHORT).show()
            }
        }

        //버튼을 눌렀을 때, 다음(결과액티비티) 액티비티로
        var btnFinish = findViewById<Button>(R.id.btnResult)
        btnFinish.setOnClickListener {
            var intent = Intent(applicationContext, ResultActivity::class.java)
            intent.putExtra("VoteCount", voteCount)
            intent.putExtra("ImageName", imgName)
            startActivity(intent)
        }


    }
}
