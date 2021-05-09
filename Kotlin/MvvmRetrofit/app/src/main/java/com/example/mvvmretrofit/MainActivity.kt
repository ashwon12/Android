package com.example.mvvmretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.mvvmretrofit.model.DataList
import com.example.mvvmretrofit.network.RetroInstance
import com.example.mvvmretrofit.network.RetroService
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.ViewModelProviders.of
import com.example.mvvmretrofit.viewmodel.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Array.get
import java.util.EnumSet.of

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //관찰자 만들기
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.getRecyclerListDataObserver().observe(this, Observer<DataList>{
            if(it != null){
                //어댑터로 데이터 전달해주기
            }else{
                Log.d("view","view에서 viewModel 관찰 실패")
            }
        })

        //버튼을 눌렀을때~ 리스너 호출
        viewModel.makeApiCall("string")
    }
}