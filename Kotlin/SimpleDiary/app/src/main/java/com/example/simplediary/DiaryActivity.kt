package com.example.simplediary

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.EditText
import androidx.core.content.edit
import androidx.core.widget.addTextChangedListener

class DiaryActivity : AppCompatActivity() {

    private val editDiary : EditText by lazy {
        findViewById(R.id.et_diary)
    }

    private val handler = Handler(Looper.getMainLooper()) // 메인쓰레드와 연결된 핸들러

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)

        val detailPreferences = getSharedPreferences("diary", Context.MODE_PRIVATE)

        editDiary.setText(detailPreferences.getString("detail",""))

        // 몇 초 이후헤 쓰레드를 실행
        val runnable = Runnable {
            getSharedPreferences("diary",Context.MODE_PRIVATE).edit {
                putString("detail", editDiary.text.toString())
            }
            Log.d("DiaryActivity", "Saved message :: ${editDiary.text.toString()}")

        }

        editDiary.addTextChangedListener {
            // 핸들러 , 메인쓰레드가 아닌 새로운 쓰레드가 생겼을때 메인쓰래드와 연결해주는 역할 = 핸들러 행
            Log.d("DiaryActivity", "Text chaged :: ${it}")
            handler.removeCallbacks(runnable)
            handler.postDelayed(runnable, 500)
        }

    }
}