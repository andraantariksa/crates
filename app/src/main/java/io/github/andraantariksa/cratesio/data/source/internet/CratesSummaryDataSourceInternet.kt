package io.github.andraantariksa.cratesio.data.source.internet

import io.github.andraantariksa.cratesio.data.models.summary.CratesSummary
import javax.inject.Inject

class CratesSummaryDataSourceInternet @Inject constructor(
    private val cratesioAPIService: CratesioAPIService
) : CratesSummaryDataSource {
    override suspend fun fetchCratesSummary(): CratesSummary {
        return cratesioAPIService.getSummary()
    }
}
