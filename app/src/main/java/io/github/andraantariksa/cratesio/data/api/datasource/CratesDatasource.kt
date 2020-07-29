package io.github.andraantariksa.cratesio.data.api.datasource

import androidx.lifecycle.LiveData
import io.github.andraantariksa.cratesio.data.api.model.CrateSummary.CrateSummary
import io.github.andraantariksa.cratesio.data.api.model.CratesDetail.CratesDetail

interface CratesDatasource {
    val cratesSummary: LiveData<CrateSummary>
    val cratesDetail: LiveData<CratesDetail>

    suspend fun fetchCrateSummary()
    suspend fun fetchCratesDetail(cratesId: Int)
}
