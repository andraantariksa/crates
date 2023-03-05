package io.github.andraantariksa.crates.feature_crates.ui.crate

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.andraantariksa.crates.feature_crates.domain.repository.CratesIoRepository
import javax.inject.Inject

@HiltViewModel
class CrateViewModel @Inject constructor(
    private val cratesIoRepository: CratesIoRepository
) : ViewModel() {
    init {

    }
}