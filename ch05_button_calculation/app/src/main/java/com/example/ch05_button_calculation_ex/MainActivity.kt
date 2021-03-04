package com.example.ch05_button_calculation_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

//0.사전작업 -> xml에서 id 부여(바인딩을 위해서 미리 작업)
//1.코틀린 객체 만들기 -> 둘 중 선택 -> 옵션1:멤버변수, 옵션2:지역변수(oncreate메소드 영역)
//2.바인딩 하기(==xml과 kotlin연결)
//3.이벤트 처리
class MainActivity : AppCompatActivity()
{
    //1)멤버변수 영역
    //스텝1.코틀린 객체만들기
    lateinit var edt1 : EditText
    lateinit var edt2 : EditText

    //각각의 객체 ->10개
//    lateinit var btn0 : Button
//    lateinit var btn1 : Button
//    lateinit var btn2 : Button
//    lateinit var btn3 : Button
//    lateinit var btn4 : Button
//    lateinit var btn5 : Button
//    lateinit var btn6 : Button
//    lateinit var btn7 : Button
//    lateinit var btn8 : Button
//    lateinit var btn9 : Button

    //java로 객체 배열 만들기...
//    Button  arr[] = new Button[10];
//    for(int i=0; arr.length-1; ++i)
//        arr[i] = new Button();

    //객체 배열로 -> 1개
    var btnNum = ArrayList<Button>(10)

    //객체배열 안에 객체를 만들어서 초기화 하는 부분은, oncreate()안에 setContentView()밑에
//    for(var i in 0..9 1)
//        btnNum.add(findViewById.)






    lateinit var btnAdd : Button
    lateinit var btnSub : Button
    lateinit var btnMul : Button
    lateinit var btnDiv : Button

    lateinit var tvResult : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        //2).지역변수 영역
        //...

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //스텝2. 바인딩
        edt1 = findViewById<EditText>(R.id.Edit1);
        edt2 = findViewById<EditText>(R.id.Edit2);

//        btn0  = findViewById<Button>(R.id.BtnNum0);
//        btn1  = findViewById<Button>(R.id.BtnNum1);
//        btn2  = findViewById<Button>(R.id.BtnNum2);
//        btn3  = findViewById<Button>(R.id.BtnNum3);
//        btn4  = findViewById<Button>(R.id.BtnNum4);
//        btn5  = findViewById<Button>(R.id.BtnNum5);
//        btn6  = findViewById<Button>(R.id.BtnNum6);
//        btn7  = findViewById<Button>(R.id.BtnNum7);
//        btn8  = findViewById<Button>(R.id.BtnNum8);
//        btn9  = findViewById<Button>(R.id.BtnNum9);


        //스텝2의 객체 배열 바인딩에서 for문에 넣기 위해서 id를 배열로 만듦
        var btnID = arrayOf(R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2,
                            R.id.BtnNum3, R.id.BtnNum4, R.id.BtnNum5,
                            R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8,
                            R.id.BtnNum9)

        //스텝2: 객체 배열 바인딩
        var i: Int
        for (i in 0..9 step 1) {
            //btnNum.add(findViewById(R.id.BtnNum0))
            btnNum.add(findViewById(btnID[i]))
        }

        btnAdd = findViewById<Button>(R.id.BtnAdd);
        btnSub = findViewById<Button>(R.id.BtnSub);
        btnMul = findViewById<Button>(R.id.BtnMul);
        btnDiv = findViewById<Button>(R.id.BtnDiv);

        tvResult = findViewById<TextView>(R.id.TextResult);

        //스텝3: 이벤트 처리 -1)숫자버튼 but 객체 배열로 한방에
        //        btn0.setOnClickListener {

        i = 0
        for(i in 0..9 step 1)
        {
//            btnNum[0].setOnClickListener {
            btnNum[i].setOnClickListener {
                // 에디트텍스트 2개가 있는데, 커서(=포커스)의 위치에 따라서 숫자 입력
                //만약에 포커스가 edt1에 있으면..
                //아니고 포코스가 edt2에 있으면..
                if (edt1.isFocused) {
                    var oldNum = edt1.text.toString()//기존에 입력된 값
                    //edt1.setText(oldNum + "0")
                    edt1.setText(oldNum + i)//i가 핵심 숫자~!
                } else if (edt2.isFocused) {
                    var oldNum = edt2.text.toString()//기존에 입력된 값
//                    edt2.setText(oldNum + "0")
                    edt2.setText(oldNum + i)
                } else {
                    Toast.makeText(this, "먼저 에디터텍스트를 선택해주세요", Toast.LENGTH_SHORT).show()
                }
            }
        }

        //스텝3: 이벤트 처리 - 1)숫자버튼(0,1,2...), 2)계산버튼(+,-,*,/)
        //1)숫자버튼 이벤트 처리 (총 10개)
//        btn0.setOnClickListener {
//            // 에디트텍스트 2개가 있는데, 커서(=포커스)의 위치에 따라서 숫자 입력
//            //만약에 포커스가 edt1에 있으면..
//            //아니고 포코스가 edt2에 있으면..
//            if(edt1.isFocused)
//            {
//                var oldNum = edt1.text.toString()//기존에 입력된 값
//                edt1.setText(oldNum + "0")
//            }
//            else if(edt2.isFocused)
//            {
//                var oldNum = edt2.text.toString()//기존에 입력된 값
//                edt2.setText(oldNum + "0")
//            }
//            else
//            {
//                Toast.makeText(this,"먼저 에디터텍스트를 선택해주세요",Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        btn1.setOnClickListener {
//            // 에디트텍스트 2개가 있는데, 커서(=포커스)의 위치에 따라서 숫자 입력
//            //만약에 포커스가 edt1에 있으면..
//            //아니고 포코스가 edt2에 있으면..
//            if(edt1.isFocused)
//            {
//                var oldNum = edt1.text.toString()//기존에 입력된 값
//                edt1.setText(oldNum + "1")
//            }
//            else if(edt2.isFocused)
//            {
//                var oldNum = edt2.text.toString()//기존에 입력된 값
//                edt2.setText(oldNum + "1")
//            }
//            else
//            {
//                Toast.makeText(this,"먼저 에디터텍스트를 선택해주세요",Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        btn2.setOnClickListener {
//            // 에디트텍스트 2개가 있는데, 커서(=포커스)의 위치에 따라서 숫자 입력
//            //만약에 포커스가 edt1에 있으면..
//            //아니고 포코스가 edt2에 있으면..
//            if(edt1.isFocused)
//            {
//                var oldNum = edt1.text.toString()//기존에 입력된 값
//                edt1.setText(oldNum + "2")
//            }
//            else if(edt2.isFocused)
//            {
//                var oldNum = edt2.text.toString()//기존에 입력된 값
//                edt2.setText(oldNum + "2")
//            }
//            else
//            {
//                Toast.makeText(this,"먼저 에디터텍스트를 선택해주세요",Toast.LENGTH_SHORT).show()
//            }
//        }
//
//
//        btn3.setOnClickListener {
//            // 에디트텍스트 2개가 있는데, 커서(=포커스)의 위치에 따라서 숫자 입력
//            //만약에 포커스가 edt1에 있으면..
//            //아니고 포코스가 edt2에 있으면..
//            if(edt1.isFocused)
//            {
//                var oldNum = edt1.text.toString()//기존에 입력된 값
//                edt1.setText(oldNum + "3")
//            }
//            else if(edt2.isFocused)
//            {
//                var oldNum = edt1.text.toString()//기존에 입력된 값
//                edt2.setText(oldNum + "3")
//            }
//            else
//            {
//                Toast.makeText(this,"먼저 에디터텍스트를 선택해주세요",Toast.LENGTH_SHORT).show()
//            }
//        }

        //2)계산버튼 이벤트 처리(총 4개)
        btnAdd.setOnClickListener {
            var str1 = edt1.text.toString()
            var num1 = Integer.parseInt(str1)

            var str2 = edt2.text.toString()
            var num2 = Integer.parseInt(str2)

            var resultNum = num1 + num2

            tvResult.text = "계산결과: "+resultNum
        }

        btnSub.setOnClickListener {
            var str1 = edt1.text.toString()
            var num1 = Integer.parseInt(str1)

            var str2 = edt2.text.toString()
            var num2 = Integer.parseInt(str2)

            var resultNum = num1 - num2

            tvResult.text = "계산결과: "+resultNum
        }

        btnMul.setOnClickListener {
            var str1 = edt1.text.toString()
            var num1 = Integer.parseInt(str1)

            var str2 = edt2.text.toString()
            var num2 = Integer.parseInt(str2)

            var resultNum = num1 * num2

            tvResult.text = "계산결과: "+resultNum
        }

        btnDiv.setOnClickListener {
            var str1 = edt1.text.toString()
            var num1 = Integer.parseInt(str1)

            var str2 = edt2.text.toString()
            var num2 = Integer.parseInt(str2)

            var resultNum = num1 / num2

            tvResult.text = "계산결과: "+resultNum
        }

    }
}
