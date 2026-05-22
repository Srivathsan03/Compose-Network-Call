package com.sri.testnetworkcall.ui.screens.home.viewmodel

import com.sri.testnetworkcall.ui.screens.home.model.UsersResp

interface UsersListRepository {

    suspend fun getUsers(): UsersResp
}