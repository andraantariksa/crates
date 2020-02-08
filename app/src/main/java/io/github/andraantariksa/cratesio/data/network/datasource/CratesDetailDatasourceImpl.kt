package io.github.andraantariksa.cratesio.data.network.datasource

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.andraantariksa.cratesio.data.network.CratesioAPIService
import io.github.andraantariksa.cratesio.data.network.model.CratesDetail.CratesDetail
import io.github.andraantariksa.cratesio.internal.exception.NoConnectivityException

class CratesDetailDatasourceImpl(
    private val cratesioAPIService: CratesioAPIService
): CratesDetailDatasource {

    private val _cratesDetail = MutableLiveData<CratesDetail>()
    override val cratesDetail: LiveData<CratesDetail>
        get() = _cratesDetail

    override suspend fun getDetail(cratesId: String) {
        try {
            val fetchedCratesDetail = cratesioAPIService
                .getCratesDetail(cratesId)
            _cratesDetail.postValue(fetchedCratesDetail)
        } catch (ex: NoConnectivityException) {
            Log.d("Connectivity", "No connection", ex)
        }
    }

}