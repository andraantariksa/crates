package io.github.andraantariksa.crates.feature_crates.data.source.remote

import io.github.andraantariksa.crates.feature_crates.domain.model.summary.CratesSummary
import io.github.andraantariksa.crates.feature_crates.data.source.remote.service.CratesIoAPIService
import io.github.andraantariksa.crates.feature_crates.data.source.remote.model.detail.CrateDetail
import io.github.andraantariksa.crates.feature_crates.data.source.remote.model.sign_in.AuthBegin
import javax.inject.Inject

class CratesIoDataSourceRemoteImpl
@Inject constructor(
    private val cratesIoAPIService: CratesIoAPIService
) : CratesIoDataSourceRemote {
    override suspend fun getCratesSummary(): CratesSummary = cratesIoAPIService.getSummary()

    override suspend fun getCrateDetail(id: Int): CrateDetail = cratesIoAPIService.getCrateDetail(id)

    override suspend fun getBeginAuthData(): AuthBegin = cratesIoAPIService.getBeginAuthData()
}
