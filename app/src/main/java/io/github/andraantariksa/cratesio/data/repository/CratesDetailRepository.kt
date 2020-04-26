package io.github.andraantariksa.cratesio.data.repository

import androidx.lifecycle.LiveData
import io.github.andraantariksa.cratesio.data.network.model.CratesDetail.CratesDetail

interface CratesDetailRepository {
    suspend fun getCratesDetail(crateId: String): LiveData<CratesDetail>
}