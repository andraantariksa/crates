package io.github.andraantariksa.crates.domain.repository

import io.github.andraantariksa.crates.domain.models.detail.CrateDetail
import io.github.andraantariksa.crates.domain.models.sign_in.AuthBegin
import io.github.andraantariksa.crates.domain.models.summary.CratesSummary

interface CratesIoRepository {
    suspend fun getCratesSummary(): CratesSummary
    suspend fun getCrateDetails(id: Int): CrateDetail
    suspend fun getBeginAuthData(): AuthBegin
}