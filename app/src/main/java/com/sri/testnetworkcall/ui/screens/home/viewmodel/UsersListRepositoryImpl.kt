package com.sri.testnetworkcall.ui.screens.home.viewmodel

import com.sri.testnetworkcall.network.ApiService
import com.sri.testnetworkcall.ui.screens.home.model.UsersResp
import javax.inject.Inject

class UsersListRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : UsersListRepository {
    override suspend fun getUsers(): UsersResp {
        return apiService.getUsers()
    }
}