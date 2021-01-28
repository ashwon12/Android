package com.example.getjson.api

import com.example.getjson.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {

    @GET("posts")
    suspend fun getPost(): Response<Post>
}