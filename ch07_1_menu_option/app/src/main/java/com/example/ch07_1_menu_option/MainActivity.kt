package com.example.ch07_1_menu_option


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.SubMenu
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    lateinit var baseLayout : LinearLayout
    lateinit var button1 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "배경색 바꾸기"
        baseLayout = findViewById<LinearLayout>(R.id.baseLayout)
        button1 = findViewById<Button>(R.id.button1)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        //1.인플레이터 객체를 만든다.(이유: xml에서 만든 디자인을 kotlin 뷰 객체로)
//        var mInflate = menuInflater // (getInflate() 와 동일하다)
//        mInflate.inflate(R.menu.menu1, menu)

        //두번째 방법, xml을 인플레이터 써서 구현하는 방법이 아님!
        //코틀린 자체 코드로 만들기
        menu!!.add(0,1,0, "빨강")
        menu!!.add(0,2,0, "초록")
        menu!!.add(0,3,0, "파랑")

        var subMenu : SubMenu = menu.addSubMenu("버튼변경")
        subMenu!!.add(0,4,0, "회전")
        subMenu!!.add(0,5,0, "2배")


        return super.onCreateOptionsMenu(menu)
    }

    //    override fun onCreateOptionsMenu(menu: Menu?) : Boolean {
//        super.onCreateOptionsMenu(menu)
//        var mInflater = menuInflater
//        mInflater.inflate(R.menu.menu1, menu)
//        return true
//    }
//
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        //item객체를 통해서, item의 아이디를 가져와서, 아이디를 보고 할일들 결정한다.
        item.itemId

        when(item.itemId) //예) R.id.itemRed
        {
            //1. xml방식
//            R.id.itemRed -> {
//                baseLayout.setBackgroundColor(Color.RED)
//            }
//
//            R.id.itemGreen -> {
//                baseLayout.setBackgroundColor(Color.GREEN)
//            }
//            R.id.itemBlue -> {
//                baseLayout.setBackgroundColor(Color.BLUE)
//            }
//            R.id.subRotate -> {
//                button1.rotation = 45f
//            }
//            R.id.subSize -> {
//                button1.scaleX = 2f
//            }

            //2.코틀릭 방식
            1 -> {
                baseLayout.setBackgroundColor(Color.RED)
            }

            2 -> {
                baseLayout.setBackgroundColor(Color.GREEN)
            }
            3 -> {
                baseLayout.setBackgroundColor(Color.BLUE)
            }
            4 -> {
                button1.rotation = 45f
            }
            5 -> {
                button1.scaleX = 2f
            }
        }

        return super.onOptionsItemSelected(item)
    }
    //    override fun onOptionsItemSelected(item: MenuItem) : Boolean {
//        when (item.itemId) {
//            R.id.itemRed -> {
//                baseLayout.setBackgroundColor(Color.RED)
//                return true
//            }
//            R.id.itemGreen -> {
//                baseLayout.setBackgroundColor(Color.GREEN)
//                return true
//            }
//            R.id.itemBlue -> {
//                baseLayout.setBackgroundColor(Color.BLUE)
//                return true
//            }
//            R.id.subRotate -> {
//                button1.rotation = 45f
//                return true
//            }
//            R.id.subSize -> {
//                button1.scaleX = 2f
//                return true
//            }
//        }
//        return false
//    }
}
