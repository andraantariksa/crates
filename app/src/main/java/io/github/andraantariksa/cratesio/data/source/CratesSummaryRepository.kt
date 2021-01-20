package io.github.andraantariksa.cratesio.data.source

import io.github.andraantariksa.cratesio.data.models.summary.CratesSummary
import io.github.andraantariksa.cratesio.data.source.internet.CratesSummaryDataSource

class CratesSummaryRepository(
    private val cratesSummaryDataSource: CratesSummaryDataSource
) {
    suspend fun fetchCratesSummary(): CratesSummary {
        return cratesSummaryDataSource.fetchCratesSummary()
    }
}
