package io.github.andraantariksa.crates.data.source.remote.internet

import io.github.andraantariksa.crates.domain.models.summary.CratesSummary
import io.github.andraantariksa.crates.data.source.CratesSummaryDataSource
import io.github.andraantariksa.crates.domain.models.detail.CrateDetail
import io.github.andraantariksa.crates.domain.models.sign_in.AuthBegin
import javax.inject.Inject

class CratesIoDataSourceInternet @Inject constructor(
    private val cratesioAPIService: CratesIoAPIService
) : CratesSummaryDataSource {
    override suspend fun getCratesSummary(): CratesSummary = cratesioAPIService.getSummary()

    override suspend fun getCrateDetails(id: Int): CrateDetail = cratesioAPIService.getCratesDetail(id)

    override suspend fun getBeginAuthData(): AuthBegin = cratesioAPIService.getBeginAuthData()
}
