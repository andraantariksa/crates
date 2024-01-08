package io.github.andraantariksa.crates.feature_crates.ui.main.screens.crates_summary

import io.github.andraantariksa.crates.common.util.CratesResult
import io.github.andraantariksa.crates.feature_crates.domain.entity.summary.CratesSummary

data class CratesSummaryState(
    val cratesSummary: CratesResult<CratesSummary> = CratesResult.Loading(),
)