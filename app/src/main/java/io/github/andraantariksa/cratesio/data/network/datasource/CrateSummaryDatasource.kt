package io.github.andraantariksa.cratesio.data.network.datasource

import androidx.lifecycle.LiveData
import io.github.andraantariksa.cratesio.data.network.model.CrateSummary.CrateSummary

interface CrateSummaryDatasource {
    val crateSummary: LiveData<CrateSummary>

    suspend fun getSummary()
}