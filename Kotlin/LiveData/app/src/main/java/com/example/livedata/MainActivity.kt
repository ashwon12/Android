package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() , View.OnClickListener {

    lateinit var myViewModel : MyViewModel
    private val btnPlus : Button by lazy { findViewById<Button>(R.id.button) }
    private val btnMinus : Button by lazy { findViewById<Button>(R.id.button2) }
    private val etInput : EditText by lazy { findViewById(R.id.et_input) }
    private val tvNumber : TextView by lazy { findViewById(R.id.tv_number) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        //값이 변경됐을때 observe 하겠다는 것을 설정. Observe 패턴 생성.
        myViewModel.currentValue.observe(this, Observer {
            Log.d("로그"," currentLiveData value change : $it")
            tvNumber.text = it.toString()
        })

       
    }

}