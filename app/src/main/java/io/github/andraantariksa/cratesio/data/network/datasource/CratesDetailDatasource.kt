package io.github.andraantariksa.cratesio.data.network.datasource

import androidx.lifecycle.LiveData
import io.github.andraantariksa.cratesio.data.network.model.CratesDetail.CratesDetail

interface CratesDetailDatasource {
    val cratesDetail: LiveData<CratesDetail>

    suspend fun getDetail(cratesId: String)
}