package io.github.andraantariksa.crates.feature_crates.ui.main.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import io.github.andraantariksa.crates.feature_crates.ui.main.screens.crates_summary.CratesSummaryScreen
import io.github.andraantariksa.crates.feature_crates.ui.main.screens.misc.SettingsScreen

@Composable
fun MainNavigation(mainState: MainState) {
    NavHost(
        navController = mainState.navHostController,
        startDestination = MainNavigationGraph.CratesSummary.route
    ) {
        composable(MainNavigationGraph.CratesSummary.route) {
            CratesSummaryScreen()
        }
        composable(MainNavigationGraph.Settings.route) {
            SettingsScreen()
        }
    }
}

@Preview
@Composable
fun PreviewMainNavigation() {
    MainNavigation(mainState = rememberMainState())
}