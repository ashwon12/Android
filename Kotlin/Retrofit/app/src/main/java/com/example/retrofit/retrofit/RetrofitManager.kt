package com.example.retrofit.retrofit

import android.util.Log
import com.example.retrofit.utils.API
import com.example.retrofit.utils.Constans.TAG
import com.example.retrofit.utils.RESPONSE_STATE
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Response

class RetrofitManager{

    companion object {
        val instance = RetrofitManager()
    }

    //레트로핏 인터페이스 가져오기
    private val iRetrofit : IRetrofit? = RetrofitClient.getClient(API.BASE_URL)?.create(IRetrofit::class.java)

    //사진 검색 api 호출
    fun searchPhoto(keyword: String?,completion: (RESPONSE_STATE,String)-> Unit ) {
        
        val term = keyword.let {
            it
        }?:""

        val call = iRetrofit?.searchPhoto(keyword = term).let{
            it
        }?: return

        call.enqueue(object : retrofit2.Callback<JsonElement>{
            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d(TAG,"응답 실패")

                completion(RESPONSE_STATE.FAIL,t.toString())
            }

            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d(TAG,"응답 성공")

                completion(RESPONSE_STATE.OK,response.raw().toString())
            }

        })

    }
}