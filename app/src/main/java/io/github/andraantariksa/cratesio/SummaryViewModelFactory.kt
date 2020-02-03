package io.github.andraantariksa.cratesio

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.andraantariksa.cratesio.data.repository.CrateSummaryRepository

class SummaryViewModelFactory(
    private val crateSummaryRepository: CrateSummaryRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SummaryViewModel(crateSummaryRepository) as T
    }
}