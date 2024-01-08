package io.github.andraantariksa.crates.feature_crates.ui.sign_in

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import io.github.andraantariksa.crates.feature_crates.ui.common.theme.CratesTheme
import io.github.andraantariksa.crates.feature_crates.ui.sign_in.screen.SignIn

class SignInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CratesTheme {
                SignIn()
            }
        }
    }
}