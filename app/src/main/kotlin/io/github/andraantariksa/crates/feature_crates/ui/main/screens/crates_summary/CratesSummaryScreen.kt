package io.github.andraantariksa.crates.feature_crates.ui.main.screens.crates_summary

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import io.github.andraantariksa.crates.common.util.Resource
import io.github.andraantariksa.crates.feature_crates.ui.common.components.CrateOverview
import io.github.andraantariksa.crates.feature_crates.ui.crate.CrateActivity
import io.github.andraantariksa.crates.feature_crates.ui.main.screens.UIEvent
import io.github.andraantariksa.crates.feature_crates.ui.main.screens.crates_summary.component.CrateOverviews
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
    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 16.dp)
    ) {
        when (val cratesSummary = cratesSummaryViewModel.cratesSummaryState.cratesSummary) {
            is Resource.Error -> {
                item {
                    Text("Error")
                }
            }
            is Resource.Loaded -> {
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
            is Resource.Loading -> {
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