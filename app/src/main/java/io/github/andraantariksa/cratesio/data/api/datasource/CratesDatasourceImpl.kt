package io.github.andraantariksa.cratesio.data.api.datasource

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.andraantariksa.cratesio.data.api.CratesioAPIService
import io.github.andraantariksa.cratesio.data.api.model.CrateSummary.CrateSummary
import io.github.andraantariksa.cratesio.data.api.model.CratesDetail.CratesDetail
import io.github.andraantariksa.cratesio.internal.exception.NoConnectivityException

class CratesDatasourceImpl(
    private val cratesioAPIService: CratesioAPIService
) : CratesDatasource {

    private val cratesSummaryMut = MutableLiveData<CrateSummary>()
    override val cratesSummary: LiveData<CrateSummary>
        get() = cratesSummaryMut

    override suspend fun fetchCrateSummary() {
        try {
            val fetchedCrateSummary = cratesioAPIService
                .getSummary()
            cratesSummaryMut.postValue(fetchedCrateSummary)
        } catch (ex: NoConnectivityException) {
            Log.d("Connectivity", "No connection", ex)
        }
    }


    private val cratesDetailMut = MutableLiveData<CratesDetail>()
    override val cratesDetail: LiveData<CratesDetail>
        get() = cratesDetailMut

    override suspend fun fetchCratesDetail(cratesId: Int) {
        val cratesDetailMut = MutableLiveData<CratesDetail>()
        try {
            val fetchedCratesDetail = cratesioAPIService
                .getCratesDetail(cratesId)
            cratesDetailMut.postValue(fetchedCratesDetail)
        } catch (ex: NoConnectivityException) {
            Log.d("Connectivity", "No connection", ex)
        }
    }
}
