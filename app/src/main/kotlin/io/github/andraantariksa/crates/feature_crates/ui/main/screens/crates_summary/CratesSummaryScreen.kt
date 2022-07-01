package io.github.andraantariksa.crates.feature_crates.ui.main.screens.crates_summary

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import io.github.andraantariksa.crates.feature_crates.ui.common.components.CrateOverview
import io.github.andraantariksa.crates.feature_crates.ui.main.screens.UIEvent
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
    when (val cratesSummary = cratesSummaryViewModel.cratesSummary.value) {
        CratesSummaryState.Failed -> {
            Text("Failed")
        }
        is CratesSummaryState.Loaded -> {
            LazyColumn {
                item {
                    Text("New Crates")
                    Column {
                        cratesSummary.cratesSummary.newCrates.forEach { item ->
                            CrateOverview(item)
                        }
                    }
                }

                item {
                    Text("Most Downloaded")
                    Column {
                        cratesSummary.cratesSummary.mostDownloaded.forEach { item ->
                            CrateOverview(item)
                        }
                    }
                }

                item {
                    Text("Just Updated")
                    Column {
                        cratesSummary.cratesSummary.justUpdatedCrate.forEach { item ->
                            CrateOverview(item)
                        }
                    }
                }
            }
        }
        CratesSummaryState.Loading -> {
            Column() {

            }
        }
    }
}