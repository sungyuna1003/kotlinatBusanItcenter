package com.cos.ch07_login_ex

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
//    lateinit var tvName : TextView
//    lateinit var tvEmail : TextView
    lateinit var edtName : EditText
    lateinit var edtEmail : EditText

    lateinit var button1 : Button
//    lateinit var dlgEdtName : EditText
//    lateinit var dlgEdtEmail : EditText

    lateinit var toastText : TextView
    lateinit var dialogView : View
    lateinit var toastView : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "사용자 정보 입력"

//        tvName = findViewById<TextView>(R.id.tvName)
//        tvEmail = findViewById<TextView>(R.id.tvEmail)

//        edtName = findViewById<EditText>(R.id.edtName)
//        edtEmail = findViewById<EditText>(R.id.edtEmail)

        edtName = findViewById<View>(R.id.edtName) as EditText
        edtEmail = findViewById<View>(R.id.edtEmail) as EditText

        button1 = findViewById<Button>(R.id.button1)

        button1.setOnClickListener {

            //0. 다이얼로그 객체 에 꽂을 디자인~!을  inflate방식으로 준비
            var dialogView = View.inflate(this, R.layout.dialog1, null)

            //1.다이얼로그 "객체" 만들기(디자인????)
            val dlg = AlertDialog.Builder(this)

            // 2. 다이얼로그의 설정(옵션 지정)
            dlg.setTitle("로그인정보 입력창")
            dlg.setIcon(R.drawable.ic_menu_allfriends)
            //3.아주 중요( 객체에 디자인(뷰) 설정)
            dlg.setView(dialogView)
            //4.다이얼로그의 위젯(뷰)를 설정
            var dlgEdtName = dialogView.findViewById<EditText>(R.id.dlgEdt1)
            var dlgEdtEmail = dialogView.findViewById<EditText>(R.id.dlgEdt2)

            dlgEdtName.setText(edtName.text.toString())
            dlgEdtEmail.setText(edtEmail.text.toString())

            dlg.setPositiveButton("확인"){  dialog, which ->
                    edtName.text = dlgEdtName.text
                    edtEmail.text = dlgEdtEmail.text
            }

            dlg.setNegativeButton("취소"){dialog, which ->
                //1.토스트 객체 만들기
                var toast = Toast(this)
                //2.토스트의 옵션 설정
                //2-1.위치 설정정
                var display = (getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay

                var xOffset = (Math.random() * display.width).toInt()
                var yOffset = (Math.random() * display.height).toInt()

               toast.setGravity(Gravity.TOP or Gravity.LEFT, xOffset, yOffset)

                //0.토스트 객체에 꽂을 디자인 뷰를 만든다.
                var toastView = View.inflate(this, R.layout.toast1, null) as View
                var toastText = toastView.findViewById<View>(R.id.toastText1) as TextView
                toastText.text ="취소했습니다"

                //3.토스트 객체에 토스트 뷰를 꽂는다. (아주 중요!)
                toast.view = toastView
                toast.show()

            }
            dlg.show()

        }


    }
}







