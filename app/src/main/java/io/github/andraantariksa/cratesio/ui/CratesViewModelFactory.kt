package io.github.andraantariksa.cratesio.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.andraantariksa.cratesio.data.repository.CratesRepository

class CratesViewModelFactory(
    private val cratesRepository: CratesRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CratesViewModel(cratesRepository) as T
    }
}