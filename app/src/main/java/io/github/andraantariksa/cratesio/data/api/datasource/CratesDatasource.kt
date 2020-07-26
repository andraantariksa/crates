package io.github.andraantariksa.cratesio.data.api.datasource

import androidx.lifecycle.LiveData
import io.github.andraantariksa.cratesio.data.api.model.CrateSummary.CrateSummary
import io.github.andraantariksa.cratesio.data.api.model.CratesDetail.CratesDetail

interface CratesDatasource {
    val crateSummary: LiveData<CrateSummary>

    suspend fun getCrateSummary()
    suspend fun getCratesDetail(cratesId: Int): LiveData<CratesDetail>
}
