package io.github.andraantariksa.crates.ui.main.screens.crates_summary

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import io.github.andraantariksa.crates.ui.common.components.Crate
import io.github.andraantariksa.crates.ui.main.screens.UIEvent
import kotlinx.coroutines.flow.collectLatest

@Preview
@Composable
fun CratesSummaryScreen(
    cratesSummaryViewModel: CratesSummaryViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {
        cratesSummaryViewModel.eventFlow.collectLatest { event ->
            when (event) {
                is UIEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        event.message,
                        event.actionLabel,
                        event.duration
                    )
                }
            }
        }
    }
    when (cratesSummaryViewModel.cratesSummary.value) {
        CratesSummaryState.Failed -> {
            Text("Failed")
        }
        is CratesSummaryState.Loaded -> {
            Crate("Test", "v1.2.3")
        }
        CratesSummaryState.Loading -> {
            CircularProgressIndicator()
        }
    }
}