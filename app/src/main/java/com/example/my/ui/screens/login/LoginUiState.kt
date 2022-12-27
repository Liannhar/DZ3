package com.example.my.ui.screens.login

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isAnonymousAccount: Boolean=true)