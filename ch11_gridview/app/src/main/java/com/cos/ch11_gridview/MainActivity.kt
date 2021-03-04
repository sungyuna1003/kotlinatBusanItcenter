package com.cos.ch11_gridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1.어댑뷰 객체 만들고, 바인딩
        var gv = findViewById<GridView>(R.id.gv1)

        //2.어댑터 만들기 (3가지)
        // 1)단순한 방법 - var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,  ArrayList<String>())
        //2)복잡한 방법(Custom Adapter)
        var adapter = MyGridAdapter(this)// 사용하기전에, 만들어 한다

        //3.어댑터뷰(=그리브뷰) 에 어댑터를 꽂는다
        gv.adapter = adapter
    }

    inner class MyGridAdapter(var activity: AppCompatActivity ) : BaseAdapter()
    {
        //1번-멤버변수 ???
        //사실상의 멤버변수는 생성자의 매개변수인 -> activity

        var posterID = arrayOf(R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
                                                  R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                                                    R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
                                                    R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                                                    R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
                                                    R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10)

        var posterTitle = arrayOf("써니", "완득이", "괴물", "라디오스타", "비열한거리", "왕의남자", "아일랜드", "웰컴투동막골", "헬보이", "빽투더퓨처", "써니", "완득이", "괴물", "라디오스타", "비열한거리", "왕의남자", "아일랜드", "웰컴투동막골", "헬보이", "빽투더퓨처", "써니", "완득이", "괴물", "라디오스타", "비열한거리", "왕의남자", "아일랜드", "웰컴투동막골", "헬보이", "빽투더퓨처", "써니", "완득이", "괴물", "라디오스타", "비열한거리", "왕의남자", "아일랜드", "웰컴투동막골", "헬보이", "빽투더퓨처")


        //2번-생성자 ???
        // 생성자의 경우,
        // 코틀린에서는 자바와 같이 별도로 안만들어도 된다!
        // 매개변수 처리하는 부분에서 생성자가 자동으로 만들어짐

        //3번- 메소드
        override fun getView(position1: Int, p1: View?, p2: ViewGroup?): View
        {
            var iv = ImageView(activity) // 코틀린 객체로 뷰를 만든다. cf) xml을 inflate해서 객체연결하는 방식이 아닌!

            //이미지뷰에 옵션같은거를 셋팅을 한다.
            iv.layoutParams  = ViewGroup.LayoutParams(200,200)
            iv.scaleType = ImageView.ScaleType.FIT_CENTER
            iv.setPadding(5,5,5,5)
            //아래 코드가 중요 !!!
//            iv.setImageResource(R.drawable.mov01)
            iv.setImageResource(posterID[position1]) //이미지가 각각의 이미지뷰에 자동으로(알아서 위치)
            
            //이미지 뷰를 클릭시 , 이벤트 처리  -> 각각의 이미지 뷰에 적용이 된다(자동으로)
            iv.setOnClickListener {
                //클릭시, 다이얼로그를 띄운다!
                var dialogView = View.inflate(activity, R.layout.dialog1, null)
                //1.다이얼로그 만든다.
                var dialog1 = AlertDialog.Builder(activity)
                var ivDialog = dialogView.findViewById<ImageView>(R.id.ivPoster)
                ivDialog.setImageResource(posterID[position1])
                //추가적으로 다이얼로그 옵션들 설정(타이틀, 아이콘, 확인취소 버튼이라든지)
//                dialog1.setTitle("큰 포스터")
                dialog1.setTitle(posterTitle[position1])

//                dialog1.setIcon(R.mipmap.ic_launcher)
                dialog1.setIcon(R.drawable.movie_icon)

                dialog1.setView(dialogView) // 이것도 아주 중요~~~
                dialog1.setNegativeButton("닫기", null)
                dialog1.show()
            }
            return iv
        }

        override fun getCount(): Int {
            //return 9;
            return posterID.size
        }

        override fun getItem(p0: Int): Any {
            return 0
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }
        //4번 클래스 ->우리는 안 씀

    }

}


