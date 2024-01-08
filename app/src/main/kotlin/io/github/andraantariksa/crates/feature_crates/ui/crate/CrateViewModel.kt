package io.github.andraantariksa.crates.feature_crates.ui.crate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.andraantariksa.crates.feature_crates.domain.repository.CratesIoRepository
import kotlinx.coroutines.launch

class CrateViewModel(
    private val cratesIoRepository: CratesIoRepository
) : ViewModel() {
    fun load(crateId: String?) {
        viewModelScope.launch {
            cratesIoRepository.getCrateDetails()
        }
    }
}