package com.cmps312.todoapp.viewmodel

import androidx.lifecycle.ViewModel
import com.cmps312.todoapp.data.entity.User
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SignInViewModel: ViewModel() {
    private val _user: MutableStateFlow<User?> = MutableStateFlow(null)
    val user: StateFlow<User?> = _user

    suspend fun setSignInValue(email: String, displayName: String) {
        delay(2000)
        _user.value = User(email, displayName)
    }
}