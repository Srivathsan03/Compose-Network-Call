package com.sri.testnetworkcall.network

import com.sri.testnetworkcall.ui.screens.home.model.UsersResp
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): UsersResp
}