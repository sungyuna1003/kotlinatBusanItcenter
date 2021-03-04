package com.example.xch04_animal_choice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity()
{
    //코틀린 객체로 만든다.
    //멤버 변수로 만든다. (반드시 멤버가 아니어도 된다)

    //lateinit var text1 : TextView(요놈만 지역 변수로 했음)
    lateinit var text2 : TextView
    //lateinit var chkAgree : CheckBox
    lateinit var swAgree : Switch
    lateinit var rGroup1 : RadioGroup
    lateinit var rdoDog : RadioButton
    lateinit var rdoCat : RadioButton
    lateinit var rdoRabbit : RadioButton

    //lateinit var btnOK : Button

    lateinit var btnFinish : Button
    lateinit var btnInit : Button

    lateinit var imgPet : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        title = "애완동물 사진 보기"

        //아래 text1 은 지역변수(멤버변수) 아님
        var text1 : TextView = findViewById<TextView>(R.id.Text1)
//        chkAgree = findViewById<CheckBox>(R.id.ChkAgree)
        swAgree = findViewById<Switch>(R.id.swAgree)

        text2 = findViewById<TextView>(R.id.Text2)
        rGroup1 = findViewById<RadioGroup>(R.id.Rgroup1)
        rdoDog = findViewById<RadioButton>(R.id.RdoDog)
        rdoCat = findViewById<RadioButton>(R.id.RdoCat)
        rdoRabbit = findViewById<RadioButton>(R.id.RdoRabbit)

//        btnOK = findViewById<Button>(R.id.BtnOK)

        btnFinish = findViewById<Button>(R.id.BtnFinish)
        btnInit = findViewById<Button>(R.id.BtnInit)

        imgPet = findViewById<ImageView>(R.id.ImgPet)

//        chkAgree.setOnCheckedChangeListener { compoundButton, b ->
//
//            //체크가 해지된건지, 체크가 설정된건지 구분
//            //if(chkAgree.isChecked == true)
//            if(chkAgree.isChecked)
//            {
//                text2.visibility = android.view.View.VISIBLE
//                rGroup1.visibility = android.view.View.VISIBLE
//                btnOK.visibility = android.view.View.VISIBLE
//                imgPet.visibility = android.view.View.VISIBLE
//
//            }
//            else
//            {
//                text2.visibility = android.view.View.INVISIBLE
//                rGroup1.visibility = android.view.View.INVISIBLE
//                btnOK.visibility = android.view.View.INVISIBLE
//                imgPet.visibility = android.view.View.INVISIBLE
//            }
//        }

        swAgree.setOnCheckedChangeListener { compoundButton, b ->

            //            //체크가 해지된건지, 체크가 설정된건지 구분
            //if(chkAgree.isChecked == true)
            if(swAgree.isChecked)
            {
                text2.visibility = android.view.View.VISIBLE
                rGroup1.visibility = android.view.View.VISIBLE
//                btnOK.visibility = android.view.View.VISIBLE
                btnFinish.visibility = android.view.View.VISIBLE
                btnInit.visibility = android.view.View.VISIBLE
                imgPet.visibility = android.view.View.VISIBLE

            }
            else
            {
                text2.visibility = android.view.View.INVISIBLE
                rGroup1.visibility = android.view.View.INVISIBLE
//                btnOK.visibility = android.view.View.INVISIBLE
                btnFinish.visibility = android.view.View.INVISIBLE
                btnInit.visibility = android.view.View.INVISIBLE
                imgPet.visibility = android.view.View.INVISIBLE
            }
        }

//        btnOK.setOnClickListener {
//            when(rGroup1.checkedRadioButtonId)
//            {
//                R.id.RdoDog -> imgPet.setImageResource(R.drawable.dog)
//                R.id.RdoCat -> imgPet.setImageResource(R.drawable.cat)
//                R.id.RdoRabbit -> imgPet.setImageResource(R.drawable.rabbit)
//                else -> Toast.makeText(this,"라디오 버튼 선택하시오", Toast.LENGTH_SHORT).show()
//            }
//        }

        rdoDog.setOnClickListener {
            imgPet.setImageResource(R.drawable.dog)
        }

        rdoCat.setOnClickListener {
            imgPet.setImageResource(R.drawable.cat)
        }

        rdoRabbit.setOnClickListener {
            imgPet.setImageResource(R.drawable.rabbit)
        }

        btnFinish.setOnClickListener {
            //앱 종료
            finish();
        }

        btnInit.setOnClickListener {
            text2.visibility = android.view.View.INVISIBLE
            rGroup1.visibility = android.view.View.INVISIBLE
//                btnOK.visibility = android.view.View.INVISIBLE
            btnFinish.visibility = android.view.View.INVISIBLE
            btnInit.visibility = android.view.View.INVISIBLE
            imgPet.visibility = android.view.View.INVISIBLE

            swAgree.isChecked = false
            rGroup1.clearCheck()
            //imgPet.setImageResource(R.drawable.ic_launcher)
            imgPet.setImageResource(0)

        }

    }
}





