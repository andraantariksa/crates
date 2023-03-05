package io.github.andraantariksa.crates.feature_crates.ui.main.screens.crates_summary

import io.github.andraantariksa.crates.common.util.Resource
import io.github.andraantariksa.crates.feature_crates.domain.entity.summary.CratesSummary

data class CratesSummaryState(
    val cratesSummary: Resource<CratesSummary> = Resource.Loading(),
)