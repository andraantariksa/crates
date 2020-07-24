package io.github.andraantariksa.cratesio.data.api.datasource

import androidx.lifecycle.LiveData
import io.github.andraantariksa.cratesio.data.api.model.CrateSummary.CrateSummary

interface CrateSummaryDatasource {
    val crateSummary: LiveData<CrateSummary>

    suspend fun getSummary()
}