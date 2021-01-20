package io.github.andraantariksa.cratesio.data.source.internet

import io.github.andraantariksa.cratesio.data.models.summary.CratesSummary

class CratesSummaryDataSourceInternet(
    private val cratesioAPIService: CratesioAPIService
) : CratesSummaryDataSource {
    override suspend fun fetchCratesSummary(): CratesSummary {
        return cratesioAPIService.getSummary()
    }
}
