package com.example.my.ui.screens.events

import com.example.my.EVENT_SCREEN
import com.example.my.NameofHobbies
import com.example.my.RANDOMHOBBY_SCREEN
import com.example.my.START_SCREEN
import com.example.my.model.Event
import com.example.my.model.Group
import com.example.my.model.Hobby
import com.example.my.model.service.StorageService
import com.example.my.ui.screens.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class EventsViewModel @Inject constructor(
    private val storageService: StorageService,
) : ViewModel() {
    val hobbies = storageService.hobbies

    fun EventList(hobby: Hobby): Flow<List<Event>>
    {
        val events = flow {
            val event= storageService.getCollectionEvent(hobby)
            emit(event)
        }
        return events
    }

    fun getHobby(count:Int):Flow<Hobby?>
    {
        val hobbies = flow {
            val hobby = storageService.getHobby(NameofHobbies[count])
            emit(hobby)
        }
        return hobbies
    }

    fun onBackButtonClick(openScreen: (String) -> Unit) = openScreen(START_SCREEN)

}