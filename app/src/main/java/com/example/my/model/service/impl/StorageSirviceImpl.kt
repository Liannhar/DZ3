package com.example.my.model.service.impl


import android.util.Log
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.my.NameofHobbies
import com.example.my.model.Event
import com.example.my.model.Group
import com.example.my.model.Hobby
import com.example.my.model.service.StorageService
import com.example.my.trace
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class StorageServiceImpl
@Inject
constructor(private val firestore: FirebaseFirestore,

) : StorageService {


    override suspend fun hobbies(): List<Hobby>
    {
        val snapshot = firestore.collection("Hobby").get().await()
        val hobbys = snapshot.toObjects(Hobby::class.java)
        return hobbys
    }
    override suspend fun getImage(url:String): Flow<StorageReference> = flow {
        val storage = FirebaseStorage.getInstance()
        val gsReference = storage.getReferenceFromUrl(url)
        emit(gsReference)
    }



    override suspend fun getHobby(hobbyId: String): Hobby? = firestore.collection("Hobby").document(hobbyId).get().await().toObject()



    override suspend fun getCollectionGroup(hobby: Hobby): List<Group> {

        val snapshot = firestore.collection("Hobby").document(hobby.id).collection("Group").get().await()
        return snapshot.toObjects(Group::class.java)
    }

    override suspend fun getCollectionEvent(hobby: Hobby): List<Event> {
        val snapshot = firestore.collection("Hobby").document(hobby.id).collection("Event").get().await()
        return snapshot.toObjects(Event::class.java)
    }

    override suspend fun getGroup(groupId: String,hobby:Hobby): Group? =
        firestore.collection("Hobby").document(hobby.id).collection("Group").document(groupId).get().await().toObject()

    override suspend fun getEvent(eventId: String,hobby:Hobby): Event? =
        firestore.collection("Hobby").document(hobby.id).collection("Event").document(eventId).get().await().toObject()


    override suspend fun favorite(hobbyId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun subscribeGroup(groupId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun subscribeEvent(eventId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun updateHobbies(hobby: Hobby):Unit =
        trace("updateHobbies") {
            firestore.collection("Hobby").document(hobby.id).set(hobby).await()
        }

    override suspend fun updateGroups(hobby: Hobby,group:Group) {
        trace("updateGroups") {
            firestore.collection("Hobby").document(hobby.id).set(group).await()
        }
    }

    override suspend fun updateEvents(hobby: Hobby,event:Event) {
        trace("updateEvents") {
            firestore.collection("Hobby").document(hobby.id).set(event).await()
        }
    }
}