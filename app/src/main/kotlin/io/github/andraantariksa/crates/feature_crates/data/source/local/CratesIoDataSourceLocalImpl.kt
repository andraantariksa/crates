package io.github.andraantariksa.crates.feature_crates.data.source.local

import io.github.andraantariksa.crates.feature_crates.data.source.remote.model.detail.CrateDetail
import io.github.andraantariksa.crates.feature_crates.domain.model.summary.CratesSummary

class CratesIoDataSourceLocalImpl : CratesIoDataSourceLocal {
    override suspend fun getCratesSummary(): CratesSummary {
        TODO("Not yet implemented")
    }

    override suspend fun getCrateDetails(id: Int): CrateDetail {
        TODO("Not yet implemented")
    }
}