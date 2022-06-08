package io.github.andraantariksa.crates.ui.main.screens

import MainBottomNavigation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.andraantariksa.crates.ui.common.BottomNavigationItem

val mainBottomNavigationItems = listOf(
    BottomNavigationItem(
        name = "Explore",
        icon = Icons.Default.Explore,
        route = MainNavigationGraph.CratesSummary.route
    ),
    BottomNavigationItem(
        name = "Settings",
        icon = Icons.Default.Settings,
        route = MainNavigationGraph.Settings.route
    ),
)

@Composable
fun MainScreen() {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        val mainState = rememberMainState()

        Scaffold(
            bottomBar = {
                MainBottomNavigation(mainState.navHostController, mainBottomNavigationItems)
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier.padding(paddingValues)
            ) {
                MainNavigation(mainState)
            }
        }
    }
}