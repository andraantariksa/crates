package io.github.andraantariksa.crates.feature_crates.ui.sign_in.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.andraantariksa.crates.feature_crates.domain.entity.user.User
import io.github.andraantariksa.crates.feature_crates.domain.repository.CratesIoRepository
import io.github.andraantariksa.crates.feature_crates.domain.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignInViewModel(
    private val cratesIoRepository: CratesIoRepository,
    private val userRepository: UserRepository
) : ViewModel() {
    private val _signInOauthUrl = MutableStateFlow<String?>(null)
    val signInOauthUrl = _signInOauthUrl.asStateFlow()

    fun getSignInOauthUrl() = viewModelScope.launch {
        val authData = cratesIoRepository.getBeginAuthData()
        if (authData.isSuccess) {
            _signInOauthUrl.value = authData.getOrThrow().url
        }
    }

    suspend fun authorizeOauth(code: String, state: String): Result<User> {
        val me = cratesIoRepository.authorizeOauth(code, state)
        me.getOrNull()?.let { myUser ->
            userRepository.signIn(myUser)
        }
        return me
    }
}