package io.github.andraantariksa.cratesio.data.repository

import androidx.lifecycle.LiveData
import io.github.andraantariksa.cratesio.data.api.datasource.CratesDatasource
import io.github.andraantariksa.cratesio.data.api.model.CrateSummary.CrateSummary
import io.github.andraantariksa.cratesio.data.api.model.CratesDetail.CratesDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CrateSummaryRepositoryImpl(
//    private val crateSummaryDao: CrateSummaryDao,
    private val cratesDatasource: CratesDatasource
) : CrateSummaryRepository {
    override suspend fun getCrateSummary(): LiveData<CrateSummary> {
        return withContext(Dispatchers.IO) {
            initSummaryData()
            return@withContext cratesDatasource.crateSummary
        }
    }

    private suspend fun initSummaryData() {
        fetchSummaryData()
    }

    private suspend fun fetchSummaryData() {
        cratesDatasource.getCrateSummary()
    }

    override suspend fun getCratesDetail(cratesId: Int): LiveData<CratesDetail> {
        return withContext(Dispatchers.IO) {
            return@withContext cratesDatasource.getCratesDetail(cratesId)
        }
    }
}