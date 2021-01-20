package io.github.andraantariksa.cratesio.data.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.andraantariksa.cratesio.data.models.summary.CratesSummary
import io.github.andraantariksa.cratesio.data.source.CratesSummaryRepository
import io.github.andraantariksa.cratesio.data.source.internet.ConnectivityInterceptor
import io.github.andraantariksa.cratesio.data.source.internet.CratesSummaryDataSourceInternet
import io.github.andraantariksa.cratesio.data.source.internet.CratesioAPIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CratesSummaryViewModel(val context: Context) : ViewModel() {
    private val cratesSummaryRepository =
        CratesSummaryRepository(
            CratesSummaryDataSourceInternet(
                CratesioAPIService.invoke(
                    ConnectivityInterceptor(context)
                )
            )
        )

    private val _cratesSummary = MutableLiveData<CratesSummary>()
    val cratesSummary: LiveData<CratesSummary>
        get() = _cratesSummary

    fun fetchCratesSummary() {
        viewModelScope.launch(Dispatchers.IO) {
            _cratesSummary.postValue(
                cratesSummaryRepository.fetchCratesSummary()
            )
        }
    }
}
