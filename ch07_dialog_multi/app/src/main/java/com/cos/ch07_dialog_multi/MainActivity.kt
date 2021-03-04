package com.cos.ch07_dialog_multi

import androidx.appcompat.app.AppCompatActivity
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button1 = findViewById<View>(R.id.button1) as Button

        var checkArray = booleanArrayOf(false, false, false)

        button1.setOnClickListener {
            var versionArray = arrayOf("오레오", "파이", "큐(10)")

            //var checkArray = booleanArrayOf(true, false, false)
            //체크 초기화를 버튼 누를 때만다 하는게 아니라, 1번만 할 수 있게 위로 보냄~~~!!

            var dlg = AlertDialog.Builder(this@MainActivity)
            dlg.setTitle("좋아하는 버전은?")
            dlg.setIcon(R.mipmap.ic_launcher)
            dlg.setMultiChoiceItems(versionArray, checkArray) {
                dialog, which, isChecked ->

                var totalString = "";
                var cnt = 0
                var i = 0
                for(i in 0..2 step 1)
                {
                    //versionArray 배열을 모두 반복하면서. 체크가 되어 있는 녀석만 토탈문자열로 만든다
                    if(checkArray[i]==true)//앞에  체크가 되어있으면,(내가 눌렀을 때, 체크로 바뀌면)
                    {
                        if(cnt == 0)
                            totalString =  versionArray[i]
                        else
                            totalString = totalString + "," + versionArray[i]

                        cnt++
                    }
                }
                //button1.text = versionArray[which]
                //button1.text = "파이 , 큐"
                button1.text = totalString

            }

            dlg.setPositiveButton("닫기", null)
            dlg.show()
        }
    }
}

