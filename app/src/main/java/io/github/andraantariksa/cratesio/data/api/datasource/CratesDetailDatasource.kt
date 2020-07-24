package io.github.andraantariksa.cratesio.data.api.datasource

import androidx.lifecycle.LiveData
import io.github.andraantariksa.cratesio.data.api.model.CratesDetail.CratesDetail

interface CratesDetailDatasource {
    val cratesDetail: LiveData<CratesDetail>

    suspend fun getDetail(cratesId: String)
}