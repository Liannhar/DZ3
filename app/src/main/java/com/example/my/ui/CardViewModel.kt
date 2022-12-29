package com.example.my.ui

import com.example.my.NameofHobbies
import com.example.my.RANDOMHOBBY_SCREEN
import com.example.my.START_SCREEN
import com.example.my.model.Event
import com.example.my.model.Group
import com.example.my.model.Hobby
import com.example.my.model.service.StorageService
import com.example.my.ui.screens.ViewModel
import com.google.firebase.storage.StorageReference
import dagger.hilt.android.lifecycle.HiltViewModel
import io.grpc.Context.Storage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class CardViewModel @Inject constructor(
    private val storageService: StorageService,
) : ViewModel() {
}