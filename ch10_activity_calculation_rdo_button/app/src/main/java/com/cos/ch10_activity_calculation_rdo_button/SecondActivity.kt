package com.cos.ch10_activity_calculation_rdo_button



import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        title = "Second 액티비티"

        var inIntent = intent

        var op1 = inIntent.getStringExtra("Operator")
        var num1 =  inIntent.getIntExtra("Num1", 0)
        var num2 =  inIntent.getIntExtra("Num2", 0)

        var result = 0;
        when(op1)
        {
            "+" ->  result = num1 + num2
            "-" ->  result = num1 - num2
            "*" ->  result = num1 * num2
            "/" ->  result = num1 / num2
        }


        var btnReturn = findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener {
            var outIntent = Intent(applicationContext, MainActivity::class.java)
            outIntent.putExtra("Hap", result)
            setResult(Activity.RESULT_OK, outIntent)
            finish()
        }

    }
}