package com.example.my.model

import com.google.firebase.firestore.DocumentId

data class Hobby (
    val id: String="",
    val name: String = "",
    val image: String ="",
    val description:String="",
    val favorite:Boolean = false)