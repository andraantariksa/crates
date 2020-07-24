package io.github.andraantariksa.cratesio.data.api.datasource

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.andraantariksa.cratesio.data.api.CratesioAPIService
import io.github.andraantariksa.cratesio.data.api.model.CrateSummary.CrateSummary
import io.github.andraantariksa.cratesio.internal.exception.NoConnectivityException

class CrateSummaryDatasourceImpl(
    private val cratesioAPIService: CratesioAPIService
): CrateSummaryDatasource {

    private val _crateSummary = MutableLiveData<CrateSummary>()
    override val crateSummary: LiveData<CrateSummary>
        get() = _crateSummary

    override suspend fun getSummary() {
        try {
            val fetchedCrateSummary = cratesioAPIService
                .getSummary()
            _crateSummary.postValue(fetchedCrateSummary)
        } catch (ex: NoConnectivityException) {
            Log.d("Connectivity", "No connection", ex)
        }
    }
}