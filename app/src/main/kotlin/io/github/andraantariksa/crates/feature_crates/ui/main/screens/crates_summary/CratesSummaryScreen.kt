package io.github.andraantariksa.crates.feature_crates.ui.main.screens.crates_summary

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.andraantariksa.crates.common.util.CratesResult
import io.github.andraantariksa.crates.feature_crates.ui.main.screens.UIEvent
import io.github.andraantariksa.crates.feature_crates.ui.main.screens.crates_summary.component.CrateOverviews
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun CratesSummaryScreen(
    cratesSummaryViewModel: CratesSummaryViewModel = koinViewModel()
) {
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(Unit) {
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
    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 16.dp)
    ) {
        when (val cratesSummary = cratesSummaryViewModel.cratesSummaryState.cratesSummary) {
            is CratesResult.Error -> {
                item {
                    Text("Error")
                }
            }
            is CratesResult.Loaded -> {
                item {
                    CrateOverviews("New Crates", cratesSummary.data.newCrates)
                }
                item {
                    CrateOverviews("Most Downloaded", cratesSummary.data.mostDownloaded)
                }
                item {
                    CrateOverviews("Just Updated", cratesSummary.data.justUpdatedCrate)
                }
            }
            is CratesResult.Loading -> {
                item {
                    CrateOverviews("New Crates")
                }
                item {
                    CrateOverviews("Most Downloaded")
                }
                item {
                    CrateOverviews("Just Updated")
                }
            }
        }
    }
}