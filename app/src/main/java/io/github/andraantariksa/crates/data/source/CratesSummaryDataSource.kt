package io.github.andraantariksa.crates.data.source

import io.github.andraantariksa.crates.domain.models.detail.CrateDetail
import io.github.andraantariksa.crates.domain.models.sign_in.AuthBegin
import io.github.andraantariksa.crates.domain.models.summary.CratesSummary

interface CratesSummaryDataSource {
    suspend fun getCratesSummary(): CratesSummary
    suspend fun getCrateDetails(id: Int): CrateDetail
    suspend fun getBeginAuthData(): AuthBegin
}
