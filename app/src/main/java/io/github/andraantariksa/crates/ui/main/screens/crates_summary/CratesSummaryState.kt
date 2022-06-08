package io.github.andraantariksa.crates.ui.main.screens.crates_summary

import io.github.andraantariksa.crates.domain.models.summary.CratesSummary

sealed class CratesSummaryState {
    class Loaded(val cratesSummary: CratesSummary): CratesSummaryState()
    object Loading: CratesSummaryState()
    object Failed: CratesSummaryState()
}