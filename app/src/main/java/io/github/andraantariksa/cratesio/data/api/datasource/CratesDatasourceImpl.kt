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

    private val cratesummaryMut = MutableLiveData<CrateSummary>()
    override val crateSummary: LiveData<CrateSummary>
        get() = cratesummaryMut

    override suspend fun getCrateSummary() {
        try {
            val fetchedCrateSummary = cratesioAPIService
                .getSummary()
            cratesummaryMut.postValue(fetchedCrateSummary)
        } catch (ex: NoConnectivityException) {
            Log.d("Connectivity", "No connection", ex)
        }
    }

    override suspend fun getCratesDetail(cratesId: Int): LiveData<CratesDetail> {
        val cratesDetailMut = MutableLiveData<CratesDetail>()
        try {
            val fetchedCratesDetail = cratesioAPIService
                .getCratesDetail(cratesId)
            cratesDetailMut.postValue(fetchedCratesDetail)
        } catch (ex: NoConnectivityException) {
            Log.d("Connectivity", "No connection", ex)
        }
        return cratesDetailMut
    }
}
