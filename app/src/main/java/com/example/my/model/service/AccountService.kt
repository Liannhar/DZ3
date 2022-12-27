package com.example.my.model.service

import com.example.my.model.User
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.Flow


interface AccountService {
    val currentUserId: String
    val hasUser: Boolean

    val currentUser: Flow<User>

    suspend fun authenticate(email: String, password: String)
    suspend fun sendRecoveryEmail(email: String)
    suspend fun createAnonymousAccount()
    suspend fun deleteAccount()
    suspend fun signOut()
    suspend fun linkAccount(email: String, password: String)
}