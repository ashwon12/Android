package com.example.mvvmretrofit.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmretrofit.model.DataList
import com.example.mvvmretrofit.network.RetroInstance
import com.example.mvvmretrofit.network.RetroService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    var recyclerList : MutableLiveData<DataList>

    init {
        recyclerList = MutableLiveData()
    }

    fun getRecyclerListDataObserver() : MutableLiveData<DataList>{
        return recyclerList
    }

    // input받는 값에 따라 live로 데이터를 호출해주기.
    fun makeApiCall(input : String){
        val instance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        val call = instance.getDataFromAPI("input")
        call.enqueue(object : Callback<DataList> {
            override fun onResponse(call: Call<DataList>, response: Response<DataList>) {
                if(response.isSuccessful){
                    val log = response.body()?.items
                    Log.d("reponseBody 성공",log.toString())

                    //업데이트 시켜주기.
                    recyclerList.postValue(response.body())
                }else{
                    recyclerList.postValue(null)
                }
            }

            override fun onFailure(call: Call<DataList>, t: Throwable) {
                Log.d("mainActivity","Fail")
            }
        })
    }
}