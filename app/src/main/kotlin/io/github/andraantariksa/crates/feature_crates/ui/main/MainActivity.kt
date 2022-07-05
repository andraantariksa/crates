package io.github.andraantariksa.crates.feature_crates.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import io.github.andraantariksa.crates.feature_crates.ui.common.theme.CratesTheme
import io.github.andraantariksa.crates.feature_crates.ui.main.screens.MainScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        preprocess()

        setContent {
            CratesTheme {
                MainScreen()
            }
        }
    }

    private val userViewModel by viewModels<UserViewModel>()

    private fun preprocess() {
        lifecycleScope.launchWhenCreated {
            val isLoggedInPreviously = MutableStateFlow(false)
            userViewModel.user.onEach { user ->
                val isLoggedIn = user !== null
                if (isLoggedIn && !isLoggedInPreviously.value) {
                    userViewModel.refreshUserData()
                }
                isLoggedInPreviously.value = isLoggedIn
            }.launchIn(this)
        }
    }
}
