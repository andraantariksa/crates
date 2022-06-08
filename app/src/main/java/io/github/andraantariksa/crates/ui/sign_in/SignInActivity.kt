package io.github.andraantariksa.crates.ui.sign_in

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import io.github.andraantariksa.crates.ui.common.theme.CratesTheme
import io.github.andraantariksa.crates.ui.sign_in.screen.SignInScreen

@AndroidEntryPoint
class SignInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CratesTheme {
                SignInScreen()
            }
        }
    }
}