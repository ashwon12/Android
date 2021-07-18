package com.example.numberlottery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    private val clearButton : Button by lazy{
        findViewById(R.id.btn_clear)
    }

    private val addButton :Button by lazy {
        findViewById(R.id.btn_add)
    }

    private val runButton: Button by lazy {
        findViewById(R.id.btn_run)
    }

    private val numTextViewList : List<TextView> by lazy {
        listOf<TextView>(
                findViewById(R.id.tv_num1)
                ,findViewById(R.id.tv_num2)
                ,findViewById(R.id.tv_num3)
                ,findViewById(R.id.tv_num4)
                ,findViewById(R.id.tv_num5)
                ,findViewById(R.id.tv_num6))
    }

    private var didRun = false
    private val pickNumSet = hashSetOf<Int>()

    private val numPick : NumberPicker by lazy { findViewById(R.id.np_num) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numPick.minValue = 1
        numPick.maxValue = 45

        initRunButton()
        initAddButton()
        initClearButton()
    }

    private fun initAddButton() {
        addButton.setOnClickListener {
            if(didRun){
                Toast.makeText(this,"초기화 후에 시도해주세요.",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(pickNumSet.size >= 5){
                Toast.makeText(this,"숫자는 최대 5개까지 선택할 수 있습니다.",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(pickNumSet.contains(numPick.value)){
                Toast.makeText(this,"이미 선택한 숫자입니다..",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val textView = numTextViewList[pickNumSet.size]
            textView.isVisible = true
            textView.text = numPick.value.toString()

            pickNumSet.add(numPick.value)
        }
    }

    private fun initClearButton(){
        clearButton.setOnClickListener {
            pickNumSet.clear()
            numTextViewList.forEach{
                it.isVisible = false
            }

            didRun = false
        }
    }

    private fun initRunButton() {
        runButton.setOnClickListener {
            val list = getRandom()
            didRun = true

            list.forEachIndexed { index, number ->
                val textView = numTextViewList[index]

                textView.text = number.toString()
                textView.isVisible = true
            }
        }
    }

    //랜덤으로 숫자 반환시켜주기
    private fun getRandom(): List<Int> {
        val numList = mutableListOf<Int>()
                .apply {
                    for(i in 1..45){
                        if(pickNumSet.contains(i)){
                            continue
                        }
                        this.add(i)
                    }
                }
        numList.shuffle()

        val newList = pickNumSet.toList() + numList.subList(0,6- pickNumSet.size)
        return newList.sorted()
    }


}