package io.github.andraantariksa.crates.ui.main.screens

sealed class MainNavigationGraph(val route: String) {
    object CratesSummary : MainNavigationGraph("crates_summary")
    object Settings : MainNavigationGraph("settings")
}