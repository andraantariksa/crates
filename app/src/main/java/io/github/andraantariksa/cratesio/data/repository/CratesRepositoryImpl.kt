package io.github.andraantariksa.cratesio.data.repository

import androidx.lifecycle.LiveData
import io.github.andraantariksa.cratesio.data.api.datasource.CratesDatasource
import io.github.andraantariksa.cratesio.data.api.model.CrateSummary.CrateSummary
import io.github.andraantariksa.cratesio.data.api.model.CratesDetail.CratesDetail
import io.github.andraantariksa.cratesio.data.db.Converter
import io.github.andraantariksa.cratesio.data.db.CratesSummaryDao
import io.github.andraantariksa.cratesio.data.db.entity.CratesSummaryEntry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDateTime

class CratesRepositoryImpl(
    private val cratesSummaryDao: CratesSummaryDao,
    private val cratesDatasource: CratesDatasource
) : CratesRepository {
    companion object {
        @Volatile
        private var instance: CratesRepositoryImpl? = null

        fun getInstance(
            cratesSummaryDao: CratesSummaryDao,
            cratesDatasource: CratesDatasource
        ) =
            instance ?: synchronized(this) {
                instance ?: CratesRepositoryImpl(
                    cratesSummaryDao,
                    cratesDatasource
                ).also {
                    instance = it
                }
            }
    }

    init {
        cratesDatasource.apply {
            cratesSummary.observeForever { newCratesSummary ->
                persistFetchedCratesSummaryWeather(newCratesSummary)
            }
        }
    }

    override suspend fun getCrateSummary(): LiveData<CrateSummary> {
        return withContext(Dispatchers.IO) {
            getCratesSummaryData()
            return@withContext cratesSummaryDao.getLastCrateSummary()!!.getCrateSummaryLiveData()
        }
    }

    private suspend fun getCratesSummaryData() {
        fetchCratesSummary()
    }

    private suspend fun fetchDetailsData(cratesId: Int) {
        cratesDatasource.fetchCratesDetail(cratesId)
    }

    override suspend fun getCratesDetail(cratesId: Int): LiveData<CratesDetail> {
        return withContext(Dispatchers.IO) {
            fetchDetailsData(cratesId)
            return@withContext cratesDatasource.cratesDetail
        }
    }

    private fun persistFetchedCratesSummaryWeather(cratesSummary: CrateSummary) {
        fun deleteOldCratesSummaryData() {
            val today = LocalDateTime.now()
            cratesSummaryDao.deleteCrateSummary(today)
        }

        GlobalScope.launch(Dispatchers.IO) {
            deleteOldCratesSummaryData()
            val cratesSummaryEntry = CratesSummaryEntry(
                null,
                cratesSummary,
                Converter.localDateTimeToString(LocalDateTime.now())!!
            )
            cratesSummaryDao.insert(cratesSummaryEntry)
        }
    }

    private suspend fun fetchCratesSummary() {
        val lastCratesSummaryDataTime = cratesSummaryDao.getLastCrateSummary()
        if (lastCratesSummaryDataTime == null ||
            isFetchCratesSummaryNeeded(
                Converter.stringToLocalDateTime(lastCratesSummaryDataTime.date)!!
            )
        ) {
            cratesDatasource.fetchCrateSummary()
        }
    }

    private fun isFetchCratesSummaryNeeded(lastFetchTime: LocalDateTime): Boolean {
        val timesAgo = LocalDateTime.now().minusMinutes(30)
        return lastFetchTime.isBefore(timesAgo)
    }
}
