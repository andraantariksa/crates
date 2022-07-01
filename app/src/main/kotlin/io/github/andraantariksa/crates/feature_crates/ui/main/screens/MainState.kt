package io.github.andraantariksa.crates.feature_crates.ui.main.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

data class MainState(
    val navHostController: NavHostController
)

@Composable
fun rememberMainState(): MainState {
    val navHostController = rememberNavController()
    return remember(navHostController) {
        MainState(
            navHostController = navHostController
        )
    }
}
