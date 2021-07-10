package io.github.andraantariksa.cratesio.data.source

import io.github.andraantariksa.cratesio.data.models.summary.CratesSummary
import io.github.andraantariksa.cratesio.data.source.internet.CratesSummaryDataSource
import io.github.andraantariksa.cratesio.data.source.internet.CratesSummaryDataSourceInternet
import javax.inject.Inject

class CratesSummaryRepository @Inject constructor(
    private val cratesSummaryDataSource: CratesSummaryDataSourceInternet
) {
    suspend fun fetchCratesSummary(): CratesSummary {
        return cratesSummaryDataSource.fetchCratesSummary()
    }
}
