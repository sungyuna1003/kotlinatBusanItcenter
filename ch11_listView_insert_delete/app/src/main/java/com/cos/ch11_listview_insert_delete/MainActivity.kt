package com.cos.ch11_listview_insert_delete

import java.util.ArrayList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var midList = ArrayList<String>()
        //1.어댑터 뷰 객체 만들고, 동시에 바인딩
        var list = findViewById<ListView>(R.id.listView1)

        //2.어댑터를 만든다(3가지 요소 -1)위치, 2)디자인, 3)데이터
        //참고 - 어댑터는 2가지 있다. - 1)단순(예:ArrayAdapter) or 2) 복잡(CustomAdapter - 예:MyAdapter)
        var adapter = ArrayAdapter(this,  android.R.layout.simple_list_item_1, midList)

        list.adapter = adapter

        var edtItem = findViewById(R.id.edtItem) as EditText
        var btnAdd = findViewById(R.id.btnAdd) as Button

        btnAdd.setOnClickListener {
            midList.add(edtItem.text.toString())
            adapter.notifyDataSetChanged()
        }

        list.setOnItemLongClickListener { parent, view, position, id ->
            midList.removeAt(position)
            adapter.notifyDataSetChanged()
            false
        }
    }
}
