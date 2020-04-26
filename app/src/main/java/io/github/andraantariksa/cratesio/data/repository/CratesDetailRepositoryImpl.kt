package io.github.andraantariksa.cratesio.data.repository

import androidx.lifecycle.LiveData
import io.github.andraantariksa.cratesio.data.network.datasource.CratesDetailDatasource
import io.github.andraantariksa.cratesio.data.network.model.CratesDetail.CratesDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CratesDetailRepositoryImpl(
    private val cratesDetailDatasource: CratesDetailDatasource
) : CratesDetailRepository {
    override suspend fun getCratesDetail(crateId: String): LiveData<CratesDetail> {
        return withContext(Dispatchers.IO) {
            cratesDetailDatasource.getDetail(crateId)
            return@withContext cratesDetailDatasource.cratesDetail
        }
    }
}