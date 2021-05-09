package com.example.mvvmretrofit.network

import retrofit2.http.GET
import retrofit2.http.Query
import com.example.mvvmretrofit.model.DataList
import retrofit2.Call

interface RetroService {

    @GET("repositories") //repositories?q=newyork
    fun getDataFromAPI(
        @Query("q") query: String
    ) : Call<DataList>
}