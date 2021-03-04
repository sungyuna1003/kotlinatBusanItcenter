package com.cos.ch11_adapterview_gallery

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

@Suppress("deprecation")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "갤러리 영화 포스터"

        var gallery = findViewById<Gallery>(R.id.gallery1)

        var galAdapter = MyGalleryAdapter(this)
        gallery.adapter = galAdapter
    }

    inner class MyGalleryAdapter(internal var context: Context) : BaseAdapter() {
        internal var posterID = arrayOf(
                R.drawable.mov11, R.drawable.mov12, R.drawable.mov13, R.drawable.mov14,
                R.drawable.mov15, R.drawable.mov16, R.drawable.mov17, R.drawable.mov18,
                R.drawable.mov19, R.drawable.mov20
        )

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var imageview = ImageView(context)
            imageview.layoutParams = Gallery.LayoutParams(200, 300)
            imageview.scaleType = ImageView.ScaleType.FIT_CENTER
            imageview.setPadding(5, 5, 5, 5)
            imageview.setImageResource(posterID[p0])

            var posterTitle = arrayOf("여인의 향기", "쥬라기 공원", "포레스트 검프", "사랑의 블랙홀", "혹성탈출", "아름다운비행", "내이름은 칸", "해리포터", "마더", "킹콩을 들다")


            imageview.setOnTouchListener { v, event ->
                var ivPoster = findViewById<ImageView>(R.id.ivPoster)
                ivPoster.scaleType = ImageView.ScaleType.FIT_CENTER
                ivPoster.setImageResource(posterID[p0])


                var toast = Toast(applicationContext)
                var toastView = View.inflate( applicationContext, R.layout.toast1, null)
                var toastText = toastView.findViewById<View>(R.id.textView1) as TextView
                toastText.text = posterTitle[p0]
                toast.view = toastView
                toast.show()


                false
            }

            return imageview
        }

        override fun getItem(p0: Int): Any {
            return 0
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }

        override fun getCount(): Int {
            return posterID.size
        }
    }
}
