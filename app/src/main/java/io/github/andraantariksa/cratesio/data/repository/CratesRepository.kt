package io.github.andraantariksa.cratesio.data.repository

import androidx.lifecycle.LiveData
import io.github.andraantariksa.cratesio.data.api.model.CrateSummary.CrateSummary
import io.github.andraantariksa.cratesio.data.api.model.CratesDetail.CratesDetail

interface CratesRepository {
    suspend fun getCrateSummary(): LiveData<CrateSummary>
    suspend fun getCratesDetail(cratesId: Int): LiveData<CratesDetail>
    fun getCratesSummaryLast(): CrateSummary?
}
