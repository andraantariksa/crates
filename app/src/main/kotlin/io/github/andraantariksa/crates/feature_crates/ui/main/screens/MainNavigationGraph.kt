package io.github.andraantariksa.crates.feature_crates.ui.main.screens

sealed class MainNavigationGraph(val route: String) {
    object CratesSummary : MainNavigationGraph("crates_summary")
    object Settings : MainNavigationGraph("settings")
}