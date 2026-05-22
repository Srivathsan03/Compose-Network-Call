package com.sri.testnetworkcall.ui.screens.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sri.testnetworkcall.ui.screens.home.model.UsersUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersListViewModel @Inject constructor(
    private val repository: UsersListRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<UsersUiState> = MutableStateFlow(UsersUiState.Loading)
    val uiState: StateFlow<UsersUiState> = _uiState.asStateFlow()

    init {
        getUsers()
    }

    fun getUsers() {
        _uiState.value = UsersUiState.Loading
        viewModelScope.launch {
            try {
                _uiState.value = UsersUiState.Success(repository.getUsers())
            } catch (e: Exception) {
                _uiState.value = UsersUiState.Error(e.message ?: "An unknown error occurred")
                e.printStackTrace()
            }
        }
    }
}