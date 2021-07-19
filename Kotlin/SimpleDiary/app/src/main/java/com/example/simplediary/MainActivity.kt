package com.example.simplediary

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.NumberPicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.edit

class MainActivity : AppCompatActivity() {

    private val numPicker1 : NumberPicker by lazy {
        findViewById<NumberPicker>(R.id.np1)
            .apply{
                minValue = 0
                maxValue = 9
            }
    }

    private val numPicker2 : NumberPicker by lazy {
        findViewById<NumberPicker>(R.id.np2)
            .apply{
                minValue = 0
                maxValue = 9
            }
    }
    private val numPicker3 : NumberPicker by lazy {
        findViewById<NumberPicker>(R.id.np3)
            .apply{
                minValue = 0
                maxValue = 9
            }
    }

    private val openButton : AppCompatButton by lazy {
        findViewById(R.id.btn_open)
    }

    private val chageButton : AppCompatButton by lazy {
        findViewById(R.id.btn_change)
    }

    private var chagePasswordMode = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numPicker1
        numPicker2
        numPicker3

        openButton.setOnClickListener {
            if(chagePasswordMode){
                Toast.makeText(this, "비밀번호가 변경중입니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val passwordPreFerences = getSharedPreferences("password", Context.MODE_PRIVATE)
            val userPassWord = "${numPicker1.value}${numPicker2.value}${numPicker3.value}" // 사용자가 입력한 비밀번호
            if(passwordPreFerences.getString("password", "000").equals(userPassWord)){
                // 초기값은 000으로 비밀번호 설정

                //votmdnjem tj
            }else{
                showErrorDialog()
            }
        }

        chageButton.setOnClickListener {
            val passwordPreFerences = getSharedPreferences("password", Context.MODE_PRIVATE)
            val userPassWord = "${numPicker1.value}${numPicker2.value}${numPicker3.value}" // 사용자가 입력한 비밀번호
            if(chagePasswordMode){


                passwordPreFerences.edit(true){
                    putString("password", userPassWord)
                }
                chagePasswordMode = false
                chageButton.setBackgroundColor(Color.BLACK)

            }else {
                if(passwordPreFerences.getString("password", "000").equals(userPassWord)){
                    chagePasswordMode = true
                    Toast.makeText(this, "변경할 패스워드를 입력해주세요.", Toast.LENGTH_SHORT).show()
                    chageButton.setBackgroundColor(Color.RED)
                }else{
                    showErrorDialog()
                }
            }
        }

    }

    private fun showErrorDialog(){
        AlertDialog.Builder(this)
            .setTitle("실패!!")
            .setMessage("비밀번호가 틀렸습니다.")
            .setPositiveButton("확인"){ _, _ -> }
            .create()
            .show()
    }
}