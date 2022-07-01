package io.github.andraantariksa.crates.feature_crates.ui.sign_in.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.andraantariksa.crates.feature_crates.data.source.remote.service.CratesIoAPIService
import io.github.andraantariksa.crates.feature_crates.domain.repository.CratesIoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(val s : CratesIoAPIService, private val cratesIoRepository: CratesIoRepository) :
    ViewModel() {
    private val _signInOauthUrl = MutableStateFlow<String?>(null)
    val signInOauthUrl = _signInOauthUrl.asStateFlow()

    fun getSignInOauthUrl() = viewModelScope.launch {
        val authData = cratesIoRepository.getBeginAuthData()
        if (authData.isSuccess) {
            val authData = authData.getOrThrow()
            _signInOauthUrl.value = authData.url
        }
    }

    fun a(code: String, state: String) = viewModelScope.launch {
        Log.d("XXXXXXXXX", s.authorizeOauth(code, state))
    }
}