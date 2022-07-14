package io.github.andraantariksa.crates.feature_crates.ui.main.screens.crates_summary

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.andraantariksa.crates.common.util.mapToResource
import io.github.andraantariksa.crates.feature_crates.domain.repository.CratesIoRepository
import io.github.andraantariksa.crates.feature_crates.ui.main.screens.UIEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CratesSummaryViewModel @Inject constructor(
    private val cratesIoRepository: CratesIoRepository
) : ViewModel() {
    var cratesSummaryState by mutableStateOf(CratesSummaryState())
        private set

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        loadCratesSummary()
    }

    private fun loadCratesSummary() = viewModelScope.launch {
        val result = cratesIoRepository.getCratesSummary()
        cratesSummaryState = cratesSummaryState.copy(cratesSummary = result.mapToResource())
    }
}
