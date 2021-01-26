package com.example.retrofit.retrofit

import android.nfc.Tag
import android.util.Log
import com.example.retrofit.utils.Constans.TAG
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//싱글턴 , 메모리를 하나만 사용하는 것!!
object RetrofitClient {
    //레트로핏 클라이언트 선언

    private var retrofitClient: Retrofit? = null

    //레트로핏 클라이언트 가져오기
    fun getClient(baseUrl: String): Retrofit? {
        Log.d(TAG,"RtrofitCilent - getInstance() called")

        if (retrofitClient == null) {

            //레트로핏 빌더를 통해 인스턴스 생성
            retrofitClient = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofitClient
    }
}