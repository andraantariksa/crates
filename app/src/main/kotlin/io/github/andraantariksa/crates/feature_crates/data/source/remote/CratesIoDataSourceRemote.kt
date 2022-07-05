package io.github.andraantariksa.crates.feature_crates.data.source.remote

import io.github.andraantariksa.crates.feature_crates.data.source.remote.model.detail.CrateDetail
import io.github.andraantariksa.crates.feature_crates.data.source.remote.model.me.Me
import io.github.andraantariksa.crates.feature_crates.data.source.remote.model.sign_in.AuthBegin
import io.github.andraantariksa.crates.feature_crates.domain.model.summary.CratesSummary

interface CratesIoDataSourceRemote {
    suspend fun getCratesSummary(): CratesSummary
    suspend fun getCrateDetail(id: Int): CrateDetail
    suspend fun getBeginAuthData(): AuthBegin
    suspend fun authorizeOauth(code: String, state: String): Me
    suspend fun getMe(): Result<Me>
    suspend fun signOut(): Result<Unit>
}
