package io.github.andraantariksa.crates.feature_crates.data.repository

import io.github.andraantariksa.crates.feature_crates.data.exception.UnauthenticatedException
import io.github.andraantariksa.crates.feature_crates.data.source.local.CratesIoDataSourceLocal
import io.github.andraantariksa.crates.feature_crates.data.source.local.UserDataSourceLocal
import io.github.andraantariksa.crates.feature_crates.data.source.remote.CratesIoDataSourceRemote
import io.github.andraantariksa.crates.feature_crates.domain.model.user.User
import io.github.andraantariksa.crates.feature_crates.domain.repository.CookieRepository
import io.github.andraantariksa.crates.feature_crates.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val cratesIoDataSourceRemote: CratesIoDataSourceRemote,
    private val userDataSourceLocal: UserDataSourceLocal,
    private val cookieRepository: CookieRepository
) : UserRepository {

    override suspend fun signIn(user: User) = userDataSourceLocal.addOrReplaceCurrentUser(user)

    override fun get(): Flow<User?> = userDataSourceLocal.get()

    override suspend fun refreshUserData() {
        val me = cratesIoDataSourceRemote.getMe()
        if (me.isSuccess) {
            val data = me.getOrNull()!!
            userDataSourceLocal.addOrReplaceCurrentUser(data.user)
        } else {
            val exception = me.exceptionOrNull()!!
            if (exception is UnauthenticatedException) {
                signOut()
            }
        }
    }

    override suspend fun signOut() {
        cookieRepository.remove("crates.io")
        userDataSourceLocal.removeCurrentUser()
    }
}