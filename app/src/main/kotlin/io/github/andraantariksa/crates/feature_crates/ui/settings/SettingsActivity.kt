package io.github.andraantariksa.crates.feature_crates.ui.settings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import io.github.andraantariksa.crates.feature_crates.ui.common.theme.CratesTheme

class SettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CratesTheme {
                SettingsScreen()
            }
        }
    }
}