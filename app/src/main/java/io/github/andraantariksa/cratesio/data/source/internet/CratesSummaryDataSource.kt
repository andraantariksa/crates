package io.github.andraantariksa.cratesio.data.source.internet

import io.github.andraantariksa.cratesio.data.models.summary.CratesSummary

interface CratesSummaryDataSource {
    suspend fun fetchCratesSummary(): CratesSummary
}
