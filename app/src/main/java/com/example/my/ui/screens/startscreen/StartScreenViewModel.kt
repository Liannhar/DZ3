package com.example.my.ui.screens.startscreen

import androidx.compose.runtime.mutableStateOf
import com.example.my.EVENT_SCREEN
import com.example.my.LOGIN_SCREEN
import com.example.my.PROFILE_SCREEN
import com.example.my.RANDOMHOBBY_SCREEN
import com.example.my.model.service.AccountService
import com.example.my.ui.screens.ViewModel
import com.google.firebase.auth.FirebaseAuthException
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StartScreenViewModel @Inject constructor(private val accountService: AccountService
) : ViewModel() {
    val showError = mutableStateOf(false)

    fun onCenterButtonClick(openScreen: (String) -> Unit) = openScreen(RANDOMHOBBY_SCREEN)

    fun onAvatarClick(openScreen: (String) -> Unit) = openScreen(LOGIN_SCREEN)
    fun onEventClick(openScreen: (String) -> Unit) = openScreen(EVENT_SCREEN)

    fun onAppStart() {
        showError.value = false
        if (accountService.hasUser.not()) createAnonymousAccount()
    }

    private fun createAnonymousAccount() {
        launchCatching() {
            try {
                accountService.createAnonymousAccount()
            } catch (ex: FirebaseAuthException) {
                showError.value = true
                throw ex
            }
        }
    }
}
