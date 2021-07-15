package com.example.caculatorbmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)
        val value =  weight/ (height / 100.0).pow(2.0)
        val resultText = when{
            value >= 35.0 -> "고도 비만"
            value >= 30.0 -> "중정도 비만"
            value >= 25.0 -> "경도 비만"
            value >= 23.0 -> "과체중"
            value >= 18.5 -> "정상제충"
            else -> "저체중"
        }

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvBMI = findViewById<TextView>(R.id.tv_bmi)

        tvResult.text = resultText
        tvBMI.text = value.toString()

    }
}