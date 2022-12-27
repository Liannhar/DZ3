package com.example.my.ui.screens.login

import androidx.compose.runtime.mutableStateOf
import com.example.my.*
import com.example.my.model.service.AccountService
import com.example.my.ui.screens.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val accountService: AccountService): ViewModel() {
    var uiState = mutableStateOf(LoginUiState())
        private set
    private val email
        get() = uiState.value.email
    private val password
        get() = uiState.value.password

    fun onEmailChange(newValue: String) {
        uiState.value = uiState.value.copy(email = newValue)
    }

    fun onPasswordChange(newValue: String) {
        uiState.value = uiState.value.copy(password = newValue)
    }

    fun onSignUpClick(openAndPopUp: (String, String) -> Unit) = openAndPopUp(SIGN_UP_SCREEN,LOGIN_SCREEN )

    fun onBackClick(openScreen: (String) -> Unit) = openScreen(START_SCREEN)
    fun onProfile(openAndPopUp: (String, String) -> Unit) = openAndPopUp(PROFILE_SCREEN,LOGIN_SCREEN)
}