package com.example.getjson.repository

import com.example.getjson.api.RetrofitInstance
import com.example.getjson.model.Post
import retrofit2.Response

class Repository{

    suspend fun getPost() : Response<Post> {
        return RetrofitInstance.api.getPost()
    }
}