package com.sri.testnetworkcall.ui.screens.home.model

sealed interface UsersUiState {
    data object Loading : UsersUiState
    data class Success(val users: UsersResp) : UsersUiState
    data class Error(val message: String) : UsersUiState
}