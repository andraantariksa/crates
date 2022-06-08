package io.github.andraantariksa.crates.ui.main.screens.crates_summary

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.andraantariksa.crates.domain.repository.CratesIoRepository
import io.github.andraantariksa.crates.ui.main.screens.UIEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CratesSummaryViewModel @Inject constructor(
    private val cratesIoRepository: CratesIoRepository
) : ViewModel() {
    private val _cratesSummary = mutableStateOf<CratesSummaryState>(CratesSummaryState.Loading)
    val cratesSummary get() = _cratesSummary

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            _cratesSummary.value = CratesSummaryState.Loaded(cratesIoRepository.getCratesSummary())
        }
    }
}
