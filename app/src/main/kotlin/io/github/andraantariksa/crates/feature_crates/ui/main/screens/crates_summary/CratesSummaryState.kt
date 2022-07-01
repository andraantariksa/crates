package io.github.andraantariksa.crates.feature_crates.ui.main.screens.crates_summary

import io.github.andraantariksa.crates.feature_crates.domain.model.summary.CratesSummary

sealed class CratesSummaryState {
    class Loaded(val cratesSummary: CratesSummary): CratesSummaryState()
    object Loading: CratesSummaryState()
    object Failed: CratesSummaryState()
}