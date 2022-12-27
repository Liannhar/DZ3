package com.example.my.model

import com.google.firebase.firestore.DocumentId

data class Hobby (
    @DocumentId val id: String="",
    val title: String = "",
    val image: String ="",
    val description:String="",
    val favorite:Boolean = false)