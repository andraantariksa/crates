package io.github.andraantariksa.cratesio.data.repository

import androidx.lifecycle.LiveData
import io.github.andraantariksa.cratesio.data.api.datasource.CrateSummaryDatasource
import io.github.andraantariksa.cratesio.data.api.model.CrateSummary.CrateSummary
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CrateSummaryRepositoryImpl(
//    private val crateSummaryDao: CrateSummaryDao,
    private val crateSummaryDatasource: CrateSummaryDatasource
) : CrateSummaryRepository {

//    private lateinit var crateSummary: CrateSummary

//    init {
//        crateSummaryDatasource.crateSummary.observeForever {
//            crateSummary = it
//        }
//    }

    override suspend fun getSummary(): LiveData<CrateSummary> {
        return withContext(Dispatchers.IO) {
            initSummaryData()
//            return@withContext crateSummaryDao.getCrateSummary()
            return@withContext crateSummaryDatasource.crateSummary
        }
    }

//    private fun persistCrateSummary(crateSummary: CrateSummary) {
//        GlobalScope.launch(Dispatchers.IO) {
//            crateSummaryDao.upsert(crateSummary)
//        }
//    }

    private suspend fun initSummaryData() {
        fetchSummaryData()
    }

    private suspend fun fetchSummaryData() {
        crateSummaryDatasource.getSummary()
    }
}