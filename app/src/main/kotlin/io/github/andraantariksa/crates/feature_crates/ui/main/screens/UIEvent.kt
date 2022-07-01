package io.github.andraantariksa.crates.feature_crates.ui.main.screens

import androidx.compose.material.SnackbarDuration

sealed class UIEvent {
    class ShowSnackbar(
        val message: String,
        val actionLabel: String?,
        val duration: SnackbarDuration
    ): UIEvent()
}