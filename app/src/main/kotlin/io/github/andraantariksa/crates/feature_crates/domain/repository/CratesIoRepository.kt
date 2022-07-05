package io.github.andraantariksa.crates.feature_crates.domain.repository

import io.github.andraantariksa.crates.feature_crates.data.source.remote.model.detail.CrateDetail
import io.github.andraantariksa.crates.feature_crates.data.source.remote.model.detail.User
import io.github.andraantariksa.crates.feature_crates.data.source.remote.model.me.Me
import io.github.andraantariksa.crates.feature_crates.data.source.remote.model.sign_in.AuthBegin
import io.github.andraantariksa.crates.feature_crates.domain.model.summary.CratesSummary

interface CratesIoRepository {
    suspend fun getCratesSummary(): Result<CratesSummary>
    suspend fun getCrateDetails(id: Int): Result<CrateDetail>
    suspend fun getBeginAuthData(): Result<AuthBegin>
    suspend fun authorizeOauth(code: String, state: String): Result<Me>
}