package com.example.ch06_reservation

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity()
{
    //1.(코틀린)객체 만들기 - 제외대상은 TextView 중에 출력이 고정된거는 XML만 있으면 되니까
    lateinit var chrono : Chronometer
//    lateinit var btnStart : Button
//    lateinit var btnEnd : Button
    lateinit var rdoCal : RadioButton
    lateinit var rdoTime : RadioButton

//    lateinit var calView : CalendarView
    lateinit var tPicker : TimePicker
    lateinit var dPicker : DatePicker

    lateinit var tvYear : TextView
    lateinit var tvMonth : TextView
    lateinit var tvDay : TextView
    lateinit var tvHour : TextView
    lateinit var tvMinute : TextView

    //멤버변수로 년,월,일을 담을 변수 하나 만들어 놓는다
    var selectYear : Int = 0;
    var selectMonth : Int = 0;
    var selectDay : Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "시간 예약"

        //2.바인딩
        // 버튼
//        btnStart = findViewById<Button>(R.id.btnStart)
//        btnEnd = findViewById<Button>(R.id.btnEnd)

        // 크로노미터
        chrono = findViewById<Chronometer>(R.id.chronometer1)

        // 라디오버튼 2개
        rdoCal = findViewById<RadioButton>(R.id.rdoCal)
        rdoTime = findViewById<RadioButton>(R.id.rdoTime)

        // FrameLayout의 2개 위젯
        tPicker = findViewById<TimePicker>(R.id.timePicker1)
//        calView = findViewById<CalendarView>(R.id.calendarView1)
        dPicker = findViewById<DatePicker>(R.id.dPicker1)

        // 텍스트뷰 중에서 연,월,일,시,분 숫자
        tvYear = findViewById<TextView>(R.id.tvYear)
        tvMonth = findViewById<TextView>(R.id.tvMonth)
        tvDay = findViewById<TextView>(R.id.tvDay)
        tvHour = findViewById<TextView>(R.id.tvHour)
        tvMinute = findViewById<TextView>(R.id.tvMinute)


        //이벤트처리 구현전에 초기 화면 설정
        tPicker.visibility = View.INVISIBLE
        //calView.visibility = View.INVISIBLE
        dPicker.visibility = View.INVISIBLE
        rdoTime.visibility = View.INVISIBLE
        rdoCal.visibility = View.INVISIBLE

        //3.이벤트 처리
        //1)라디오 버튼 2개 각각 처리( 다른 방법은 라디오 그룹으로~)
        rdoCal.setOnClickListener {
            tPicker.visibility = View.INVISIBLE
            //calView.visibility = View.VISIBLE
            dPicker.visibility = View.VISIBLE
        }

        rdoTime.setOnClickListener {
            tPicker.visibility = View.VISIBLE
//            calView.visibility = View.INVISIBLE
            dPicker.visibility = View.INVISIBLE
        }

        chrono.setOnClickListener {
            chrono.base = SystemClock.elapsedRealtime()
            chrono.start()
            chrono.setTextColor(Color.RED)
            rdoTime.visibility = View.VISIBLE
            rdoCal.visibility = View.VISIBLE
        }

//        btnStart.setOnClickListener {
//            //크로노미터를 시작
//            chrono.base = SystemClock.elapsedRealtime()
//            chrono.start()
//            chrono.setTextColor(Color.RED)
//        }

//        calView.setOnDateChangeListener { view, i, i2, i3 ->
//            selectYear = i//년
//            selectMonth = i2 + 1//월
//            selectDay = i3//일
//
//        }

        //캘린터븅화 같은 아래 이 방법 아님!
//        dPicker.setOnDateChangedListener { picker, i, i2, i3 ->
//            selectYear = i//년
//            selectMonth = i2 + 1//월
//            selectDay = i3//일
//
//        }

        //예약 완료 눌렀을 때 이벤트 처리
//        btnEnd.setOnClickListener {
//            chrono.stop()
//            chrono.setTextColor(Color.BLUE)
//
//            //캘린더로 부터, 날짜 가져오기(년,월,일)
//            //CalendarView 의 경우 , 리스너에서 가져옴~!!! (먼저 리스너 만들어야함!)
////            calView.current
//            tvYear.text = ""+selectYear
//            tvMonth.text = ""+selectMonth
//            tvDay.text = ""+selectDay
//
//            //타임피커로 부터, 시간 가져오기(시,분)
//            tvHour.text = ""+tPicker.currentHour
//            tvMinute.text = ""+tPicker.currentMinute
//
//        }

        tvYear.setOnLongClickListener {

            chrono.stop()
            chrono.setTextColor(Color.BLUE)

            //캘린더로 부터, 날짜 가져오기(년,월,일)
            //CalendarView 의 경우 , 리스너에서 가져옴~!!! (먼저 리스너 만들어야함!)
//            calView.current
//            tvYear.text = ""+selectYear
//            tvMonth.text = ""+selectMonth
//            tvDay.text = ""+selectDay

            tvYear.text = ""+dPicker.year
            tvMonth.text = ""+dPicker.month
            tvDay.text = ""+dPicker.dayOfMonth

            //타임피커로 부터, 시간 가져오기(시,분)
            tvHour.text = ""+tPicker.currentHour
            tvMinute.text = ""+tPicker.currentMinute

            tPicker.visibility = View.INVISIBLE
            dPicker.visibility = View.INVISIBLE
            rdoTime.visibility = View.INVISIBLE
            rdoCal.visibility = View.INVISIBLE

            false
        }




    }
}