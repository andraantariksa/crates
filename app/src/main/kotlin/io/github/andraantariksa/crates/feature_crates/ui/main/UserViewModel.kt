package io.github.andraantariksa.crates.feature_crates.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.andraantariksa.crates.feature_crates.domain.entity.user.User
import io.github.andraantariksa.crates.feature_crates.domain.repository.UserRepository
import kotlinx.coroutines.flow.*

class UserViewModel(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?>
        get() = _user

    init {
        userRepository.get()
            .onEach {
                _user.value = it
            }
            .launchIn(viewModelScope)
    }

//    suspend fun refreshUserData() = userRepository.refreshUserData()

    suspend fun signOut() = userRepository.signOut()
}