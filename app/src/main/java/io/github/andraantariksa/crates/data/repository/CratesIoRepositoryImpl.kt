package io.github.andraantariksa.crates.data.repository

import io.github.andraantariksa.crates.data.source.remote.internet.CratesIoDataSourceInternet
import io.github.andraantariksa.crates.domain.models.detail.CrateDetail
import io.github.andraantariksa.crates.domain.models.sign_in.AuthBegin
import io.github.andraantariksa.crates.domain.models.summary.CratesSummary
import io.github.andraantariksa.crates.domain.repository.CratesIoRepository
import javax.inject.Inject

class CratesIoRepositoryImpl @Inject constructor(
    private val cratesIoDatasourceInternet: CratesIoDataSourceInternet
) : CratesIoRepository {
    override suspend fun getCratesSummary(): CratesSummary =
        cratesIoDatasourceInternet.getCratesSummary()

    override suspend fun getCrateDetails(id: Int): CrateDetail =
        cratesIoDatasourceInternet.getCrateDetails(id)

    override suspend fun getBeginAuthData(): AuthBegin =
        cratesIoDatasourceInternet.getBeginAuthData()
}
