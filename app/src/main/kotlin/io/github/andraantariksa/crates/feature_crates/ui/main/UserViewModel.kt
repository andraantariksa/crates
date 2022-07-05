package io.github.andraantariksa.crates.feature_crates.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.andraantariksa.crates.feature_crates.domain.model.user.User
import io.github.andraantariksa.crates.feature_crates.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    val user: Flow<User?> = userRepository.get().shareIn(viewModelScope, SharingStarted.Eagerly)

    suspend fun refreshUserData() = userRepository.refreshUserData()

    suspend fun signOut() = userRepository.signOut()
}