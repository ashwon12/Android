package com.example.mvvmretrofit.model


data class DataList (val items: Data)

data class Data (val name : String, val description : String, val owner : Owner)

data class Owner(val avatar_url : String)