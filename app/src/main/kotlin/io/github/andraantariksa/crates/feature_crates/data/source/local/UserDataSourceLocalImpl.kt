package io.github.andraantariksa.crates.feature_crates.data.source.local

import io.github.andraantariksa.crates.feature_crates.data.source.local.database.CratesDatabase
import io.github.andraantariksa.crates.feature_crates.domain.model.user.User
import kotlinx.coroutines.flow.Flow

class UserDataSourceLocalImpl(
    cratesDatabase: CratesDatabase,
) : UserDataSourceLocal {
    private val userDao = cratesDatabase.userDao()

    override fun get(): Flow<User?> = userDao.get()

    override suspend fun addOrReplaceCurrentUser(user: User) = userDao.add(user.toUserEntity())

    override suspend fun removeCurrentUser() = userDao.remove()
}