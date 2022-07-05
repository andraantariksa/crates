package io.github.andraantariksa.crates.feature_crates.data.source.local

import io.github.andraantariksa.crates.feature_crates.domain.model.user.User
import kotlinx.coroutines.flow.Flow

interface UserDataSourceLocal {
    suspend fun addOrReplaceCurrentUser(user: User)
    suspend fun removeCurrentUser()
    fun get(): Flow<User?>
}