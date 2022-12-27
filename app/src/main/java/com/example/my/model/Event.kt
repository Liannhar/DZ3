package com.example.my.model

import com.google.firebase.firestore.DocumentId

data class Event (
    @DocumentId val id: String="",
    val title: String = "",
    val image: String ="",
    val description:String="",
    val subscribe:Boolean=false,
    val dueDate: String = "",
    val dueTime: String = "" )