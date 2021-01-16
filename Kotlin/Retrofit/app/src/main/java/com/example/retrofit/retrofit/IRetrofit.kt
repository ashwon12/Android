package com.example.retrofit.retrofit

import com.example.retrofit.utils.API
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IRetrofit {

    @GET(API.SEARCH_PHOTO)
    fun searchPhoto(@Query("query") keyword: String) : Call<JsonElement>

    @GET(API.SEARCH_USER)
    fun searchUsers(@Query("query") keyword: String): Call<JsonElement>

}