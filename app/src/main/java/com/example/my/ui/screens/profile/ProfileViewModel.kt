package com.example.my.ui.screens.profile

import androidx.compose.runtime.mutableStateOf
import com.example.my.RANDOMHOBBY_SCREEN
import com.example.my.START_SCREEN
import com.example.my.model.service.AccountService
import com.example.my.ui.screens.ViewModel
import com.example.my.ui.screens.login.LoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val accountService: AccountService,
) : ViewModel() {
    var uiState = mutableStateOf(ProfileUiState())
        private set

    fun onBackButtonClick(openScreen: (String) -> Unit) = openScreen(START_SCREEN)

    fun onSignOutClick(restartApp: (String) -> Unit) {
        launchCatching {
            accountService.signOut()
            restartApp(START_SCREEN)
        }
    }
}