package com.example.caculatorbmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEditText = findViewById<EditText>(R.id.et_cm)
        val weightEditText = findViewById<EditText>(R.id.et_kg)
        val submitButton = findViewById<Button>(R.id.btn_submit)

        submitButton.setOnClickListener{
            if(heightEditText.text.isEmpty() || weightEditText.text.isEmpty()){
                Toast.makeText(this, "값을 입력해주세요.",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val height : Int = heightEditText.text.toString().toInt()
            val weight : Int = weightEditText.text.toString().toInt()

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("height", height)
            intent.putExtra("weight", weight) // intent는 onCreate()에 넣어서 전달한다.
            startActivity(intent)
        }

    }
}