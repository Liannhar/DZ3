package com.example.my.ui.screens.randomhobby

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import com.example.my.*
import com.example.my.model.Event
import com.example.my.model.Group
import com.example.my.model.Hobby
import com.example.my.model.service.StorageService
import com.example.my.ui.screens.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import kotlin.coroutines.coroutineContext
import kotlin.random.Random


@HiltViewModel
class RandomHobbyViewModel @Inject constructor(
    private val storageService: StorageService,
) : ViewModel() {

    fun getRandomHobby():Hobby
    {

        return
    }

    fun onBackButtonClick(openAndPopUp: (String, String) -> Unit) = openAndPopUp(START_SCREEN,RANDOMHOBBY_SCREEN)

}