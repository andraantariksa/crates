package io.github.andraantariksa.crates.feature_crates.ui.sign_in.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.andraantariksa.crates.feature_crates.domain.entity.user.User
import io.github.andraantariksa.crates.feature_crates.domain.repository.CratesIoRepository
import io.github.andraantariksa.crates.feature_crates.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignInViewModel(
    private val cratesIoRepository: CratesIoRepository,
    private val userRepository: UserRepository
) : ViewModel() {
    private val _signInURL = MutableStateFlow<String?>(null)
    val signInURL = _signInURL.asStateFlow()

    fun getSignInOauthUrl() {
        viewModelScope.launch {
            _signInURL.value = cratesIoRepository.getBeginAuthData().url
        }
    }

    suspend fun authorizeOauth(code: String, state: String, onComplete: () -> Unit) {
        viewModelScope.launch {
            cratesIoRepository.authorizeOauth(code, state)?.getOrNull()?.let { myUser ->
                userRepository.signIn(myUser)
            }
        }
    }
}
