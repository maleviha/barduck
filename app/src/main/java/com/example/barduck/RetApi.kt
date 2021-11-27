package com.example.barduck

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RetApi {
    @POST("user/login")
    fun login(@Body hashMap: HashMap<String, String>): Call<Login>

    @POST("Auth/register")
    fun registration(@Body hashMap: HashMap<String, String>): Call<Void>


}