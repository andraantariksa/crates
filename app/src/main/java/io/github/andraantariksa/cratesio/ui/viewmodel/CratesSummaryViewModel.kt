package io.github.andraantariksa.cratesio.ui.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import io.github.andraantariksa.cratesio.data.models.summary.CratesSummary
import io.github.andraantariksa.cratesio.data.source.CratesSummaryRepository
import io.github.andraantariksa.cratesio.data.source.internet.ConnectivityInterceptor
import io.github.andraantariksa.cratesio.data.source.internet.CratesSummaryDataSourceInternet
import io.github.andraantariksa.cratesio.data.source.internet.CratesioAPIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CratesSummaryViewModel @Inject constructor(
    private val cratesSummaryRepository: CratesSummaryRepository
) : ViewModel() {

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
