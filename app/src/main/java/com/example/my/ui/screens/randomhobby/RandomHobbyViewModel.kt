package com.example.my.ui.screens.randomhobby

import com.example.my.*
import com.example.my.model.Event
import com.example.my.model.Group
import com.example.my.model.Hobby
import com.example.my.model.service.DBHandler
import com.example.my.model.service.StorageService
import com.example.my.ui.screens.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class RandomHobbyViewModel @Inject constructor(
    private val storageService: StorageService,
    private val dbHandler: DBHandler
) : ViewModel() {

    fun getRandomHobby(): Hobby {
        val rand = (NameofHobbies.indices).random()
        return dbHandler.getHobby(NameofHobbies[rand])
    }

    fun getEvents(hobby:Hobby):List<Event> =dbHandler.getEvents(hobby.name)
    fun getGroups(hobby:Hobby):List<Group> =dbHandler.getGroups(hobby.name)

    fun onBackButtonClick(openAndPopUp: (String, String) -> Unit) = openAndPopUp(START_SCREEN,RANDOMHOBBY_SCREEN)

}