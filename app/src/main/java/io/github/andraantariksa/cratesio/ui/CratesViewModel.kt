package io.github.andraantariksa.cratesio.ui

import androidx.lifecycle.ViewModel
import io.github.andraantariksa.cratesio.data.repository.CratesRepository
import io.github.andraantariksa.cratesio.internal.lazyDeferred

class CratesViewModel(
    private val cratesRepository: CratesRepository
) : ViewModel() {
    val crateSummaryLast = cratesRepository.getCratesSummaryLast()

    val crateSummary by lazyDeferred {
        cratesRepository.getCrateSummary()
    }
}
