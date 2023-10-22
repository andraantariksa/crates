package io.github.andraantariksa.crates.feature_crates.data.source.local

import io.github.andraantariksa.crates.feature_crates.data.source.local.database.CratesDatabase
import io.github.andraantariksa.crates.feature_crates.data.source.local.model.user.toMyUserDBEntity
import io.github.andraantariksa.crates.feature_crates.domain.entity.user.User
import kotlinx.coroutines.flow.Flow

class UserDataSourceLocalImpl(
    cratesDatabase: CratesDatabase,
) : UserDataSourceLocal {
    private val userDao = cratesDatabase.userDao()
    private val cookieDao = cratesDatabase.cookieDao()

    override fun get(): Flow<User?> = userDao.get()

    override suspend fun addOrReplaceCurrentUser(user: User) =
        userDao.add(user.toMyUserDBEntity())

    override suspend fun removeCurrentUser() {
        userDao.remove()
        cookieDao.removeAll()
    }
}