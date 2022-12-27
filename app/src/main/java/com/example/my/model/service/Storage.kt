package com.example.my.model.service

import com.example.my.model.Event
import com.example.my.model.Group
import com.example.my.model.Hobby
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.storage.StorageReference
import dagger.Module
import kotlinx.coroutines.flow.Flow


interface StorageService {
    val hobbies: Flow<List<Hobby>>

    suspend fun getImage(url:String):Flow<StorageReference>

    suspend fun getHobby(hobbyId: String): Hobby?
    suspend fun getGroup(groupId: String,hobby: Hobby): Group?
    suspend fun getEvent(eventId: String,hobby: Hobby): Event?

    suspend fun getCollectionGroup(hobby: Hobby):List<Group>
    suspend fun getCollectionEvent(hobby: Hobby):List<Event>


    suspend fun favorite(hobbyId: String)
    suspend fun subscribeGroup(groupId: String)
    suspend fun subscribeEvent(eventId: String)

    suspend fun updateHobbies(hobby:Hobby)
    suspend fun updateGroups(hobby:Hobby,group:Group)
    suspend fun updateEvents(hobby:Hobby,event:Event)
}
