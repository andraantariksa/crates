package io.github.andraantariksa.cratesio.data.repository

import androidx.lifecycle.LiveData
import io.github.andraantariksa.cratesio.data.network.model.CrateSummary

interface CrateSummaryRepository {
    suspend fun getSummary(): LiveData<CrateSummary>
}