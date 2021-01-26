package com.example.retrofit.utils

object Constans{
    const val TAG : String = "로그"
}

enum class SEARCH_TYPE{
    PHOTO,
    USER
}

enum class RESPONSE_STATE{
    OK,
    FAIL
}

object API{
    const val BASE_URL = "https://api.unsplash.com/"

    const val CLIENT_ID = ""

    const val SEARCH_PHOTO = "search/photos"
    const val SEARCH_USER = "search/users"
}