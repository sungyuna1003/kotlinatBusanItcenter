package com.example.ch07_2_picture_option_menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.ImageView

class MainActivity : AppCompatActivity()
{
    lateinit var edt1 : EditText
    lateinit var iv1 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "제주풍경"

        edt1 = findViewById<EditText>(R.id.edt1)
        iv1 = findViewById<ImageView>(R.id.iv1)
    }

    //1.옵션 메뉴: create
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        var mInflate = menuInflater
        mInflate.inflate(R.menu.menu1, menu)

        return super.onCreateOptionsMenu(menu)
    }

    //2.옵션 메뉴: event 처리
    var angle : Float = 0f
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.itemRotate ->
            {
                angle = angle + java.lang.Float.parseFloat(edt1.text.toString())
                iv1.rotation = angle
//                   iv1.rotation = java.lang.Float.parseFloat(edt1.text.toString())
            }
            R.id.item1 ->
            {
                iv1.setImageResource(R.drawable.jeju3)
            }
            R.id.item2 ->
            {
                iv1.setImageResource(R.drawable.jeju10)
            }
            R.id.item3 ->
            {
                iv1.setImageResource(R.drawable.jeju12)

            }
        }


        return super.onOptionsItemSelected(item)
    }
}









