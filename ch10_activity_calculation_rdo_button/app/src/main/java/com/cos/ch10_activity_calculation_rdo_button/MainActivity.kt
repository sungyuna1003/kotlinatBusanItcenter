package com.cos.ch10_activity_calculation_rdo_button

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "메인 액티비티"

        var btnNewActivity = findViewById<Button>(R.id.btnNewActivity)

        btnNewActivity.setOnClickListener {
            var edtNum1 = findViewById<EditText>(R.id.edtNum1)
            var edtNum2 = findViewById<EditText>(R.id.edtNum2)

            var rg1 = findViewById<RadioGroup>(R.id.rg1)

            var intent = Intent(applicationContext, SecondActivity::class.java)

            when(rg1.checkedRadioButtonId)
            {
                R.id.rdo1  -> intent.putExtra("Operator", "+")
                R.id.rdo2  -> intent.putExtra("Operator", "-")
                R.id.rdo3  -> intent.putExtra("Operator", "*")
                R.id.rdo4 -> intent.putExtra("Operator", "/")
                else -> Toast.makeText(this, "선택안됨!", Toast.LENGTH_SHORT).show()
            }



            intent.putExtra("Num1", Integer.parseInt(edtNum1.text.toString()))
            intent.putExtra("Num2", Integer.parseInt(edtNum2.text.toString()))
            //추가로 연산자 기호를 보내야 겠다~!~ ???


            startActivityForResult(intent, 0)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            var hap = data!!.getIntExtra("Hap", 0)
            Toast.makeText(applicationContext, "계산 결과 :$hap", Toast.LENGTH_SHORT).show()
        }
    }
}