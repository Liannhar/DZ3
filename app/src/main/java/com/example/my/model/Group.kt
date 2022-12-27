package com.example.my.model

import com.google.firebase.firestore.DocumentId

data class Group (
    @DocumentId val id: String = "",
    val name: String = "",
    val image: String ="",
    val description:String="",
    val subscribe:Boolean=false,
    val members:Int=0)