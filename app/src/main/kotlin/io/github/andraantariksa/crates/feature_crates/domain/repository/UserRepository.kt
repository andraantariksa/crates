package io.github.andraantariksa.crates.feature_crates.domain.repository

import io.github.andraantariksa.crates.feature_crates.domain.model.user.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun signIn(user: User)
    fun get(): Flow<User?>
    suspend fun refreshUserData()
    suspend fun signOut()
}