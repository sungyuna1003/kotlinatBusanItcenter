package com.example.ch06_actionbar_and_fragment

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

@Suppress("DEPRECATION")   //인터페이스는 추상메소드로만 이루어져있기 때문에, 상속받는 자식들은 반드시 재정의 해야한다.
class MainActivity : AppCompatActivity(), ActionBar.TabListener//나 자신(액티비티)의 뷰에다가 바로 리스너를 달겠다
{
    lateinit var tab1 : ActionBar.Tab;
    lateinit var tab2 : ActionBar.Tab;
    lateinit var tab3 : ActionBar.Tab;

    //프레그먼트객체 3개를 담을 (프로그먼트객체)배열
    var fragmentArray = arrayOfNulls<MyTabFragment>(3)
   
    override fun onCreate(savedInstanceState: Bundle?) 
    {
        super.onCreate(savedInstanceState)
        
//        setContentView(R.layout.activity_main) //xml을 안쓰겠다! kotlin (프래그먼트)객체로 화면 디자인하겠다
        
        //1.액션바 만들기 (액티비티 안에 있음)
        var bar = this.supportActionBar
        bar!!.navigationMode = ActionBar.NAVIGATION_MODE_TABS

        tab1 = bar.newTab();
        tab1.text = "음악별"
        //탭에 리스너를 단다
        tab1.setTabListener(this) //이거 없으면 에러남!!!
        bar.addTab(tab1)

        tab2 = bar.newTab();
        tab2.text = "가수별"
        tab2.setTabListener(this)
        bar.addTab(tab2)

        tab3 = bar.newTab();
        tab3.text = "앨범별"
        tab3.setTabListener(this)
        bar.addTab(tab3)
        

    }

    //onCreate 와 동급

    //2.프래그먼트 만들기! ( 프래그먼트 클래스를 상속 받아서 my프래그먼트 클래스 만들고, 그거로 객체 생성)
    //만드는 위치는, Mainactivity의 내부(inner)클래스, 다시말해서 4.멤버 클래스

    class MyTabFragment : Fragment() //클래스 정의(define)
    {
        //constructor() : super()

        //tabName을 멤버변수로 가져왓음(onCreateView()메소드에서 써야 함으로)
        //tabName은 탭의 이름이자 id역할,
        var tabName : String? = null //기본적으로 코틀린은 null값을 가질 수 없다!!!

        //2가지 초기화 작업 메소드를 재정의
        //1번 onCreate() - 프래그먼트객체를 create(생성) 할때, 설정할 것  cf)액티비티가 create생성 될때
        //2번 onCreateView() -> 화면 즉 view에 관련된거는 따로관리해서 설정

        //alt + insert 키를 눌러서 메소드 오버라이딩 한다.
        //1번 재정의
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

//            //tabName은 탭의 이름이자 id역할,
//            var tabName : String? = null //기본적으로 코틀린은 null값을 가질 수 없다!!!

            var data = arguments //매개변수로 무터 값을 가져오는 키워드, 프로퍼티임(gettter임으로) -> arguments

            tabName = data!!.getString("tabName")

        }

        //2번 재정의
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
        {
            //view 화면을 만든다, -> 레이아웃 만든다 -> 안에 버튼 같은 뷰를 넣기도 한다!  \
            //레이아웃을 코틀린 코드로 만들기(cf)xml이 아니다~!
            var option = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                                                   LinearLayout.LayoutParams.MATCH_PARENT)
            var baseLayout = LinearLayout(super.getActivity())
            baseLayout.orientation = LinearLayout.VERTICAL
            baseLayout.layoutParams = option

            if(tabName == "음악별")
                baseLayout.setBackgroundColor(Color.RED)
            if(tabName == "가수별")
                baseLayout.setBackgroundColor(Color.GREEN)
            if(tabName == "앨범별")
                baseLayout.setBackgroundColor(Color.BLUE)

//            return super.onCreateView(inflater, container, savedInstanceState)
            return baseLayout
        }
    }

    override fun onTabReselected(tab: ActionBar.Tab, ft: FragmentTransaction) {
        //TO DO 코드가 있으면 반드시 지워야 한다!!!!
    }

    override fun onTabUnselected(tab: ActionBar.Tab, ft: FragmentTransaction) {

    }

    //탭을 클릭했을 때 이벤트 처리 -> 이게 리스너임!!!
    override fun onTabSelected(tab: ActionBar.Tab, ft: FragmentTransaction)// ? 물음표 빼서, 둘다 null 허용 금지!
    {
        //각각의 프래그먼트 -> 총3개 를 담을 단일 객체변수를 만든다(준비) -> 나중에 객체배열에 담겠죠...
        var fragmentOne : MyTabFragment? = null

        //객체 배열에 있는지 판단해서
        if(fragmentArray[tab.position] == null)
        {
            //객체 배열안에 아무것도 없으면...
            //프래그먼트1개 객체를 만들어서,
            fragmentOne = MyTabFragment()
            var data = Bundle()
            data.putString("tabName", tab.text.toString())
            fragmentOne.arguments = data

            //1.배열에도 넣는다, 왜냐하면, 재사용[프래그먼트에 리니어 색상 지정시]해야 하니까
            fragmentArray[tab.position] = fragmentOne
            //2.화면에 뿌린다! // IF문 밖에서

        }
        else
        {
            //객체 배열이 null 이 아니니까, 객체배열안에 있는 객체 1개를 꺼내서 화면으로~~
            fragmentOne = fragmentArray[tab.position]

        }

        //2.화면에 뿌린다!
        ft.replace(android.R.id.content,fragmentOne!!)

    }


    //3.액션바에 프래그먼트 연결

    //4. 이벤트 처리~! 액션바의 메뉴중 탭 1개를 눌렀을 때, 작동할 일들~!

}