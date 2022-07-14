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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import io.github.andraantariksa.crates.R
import io.github.andraantariksa.crates.common.util.Resource
import io.github.andraantariksa.crates.feature_crates.ui.common.components.CrateOverview
import io.github.andraantariksa.crates.feature_crates.ui.crate.CrateActivity
import io.github.andraantariksa.crates.feature_crates.ui.main.screens.UIEvent
import kotlinx.coroutines.flow.collectLatest

@Preview
@Composable
fun CratesSummaryScreen(
    cratesSummaryViewModel: CratesSummaryViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val context = LocalContext.current

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
    when (val cratesSummary = cratesSummaryViewModel.cratesSummaryState.cratesSummary) {
        is Resource.Error -> {
            Text("Failed")
        }
        is Resource.Loaded -> {
            val crateSummarySpacer = 8.dp
            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            ) {
                item {
                    Text("New Crates")
                    Column(
                        verticalArrangement = Arrangement.spacedBy(crateSummarySpacer),
                        modifier = Modifier
                            .padding(vertical = 2.dp)
                    ) {
                        cratesSummary.data.newCrates.forEach { item ->
                            CrateOverview(item)
                        }
                    }
                }

                item {
                    Text("Most Downloaded")
                    Column(verticalArrangement = Arrangement.spacedBy(crateSummarySpacer)) {
                        cratesSummary.data.mostDownloaded.forEach { item ->
                            CrateOverview(item)
                        }
                    }
                }

                item {
                    Text("Just Updated")
                    Column(verticalArrangement = Arrangement.spacedBy(crateSummarySpacer)) {
                        cratesSummary.data.justUpdatedCrate.forEach { item ->
                            CrateOverview(item) {
                                context.startActivity(
                                    Intent().apply {
                                        putExtra(
                                            CrateActivity.Companion.Extra.CRATE_ID_NAME,
                                            item.id
                                        )
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
        is Resource.Loading -> {
            val crateSummarySpacer = 8.dp
            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            ) {
                item {
                    Text("New Crates")
                    Column(
                        verticalArrangement = Arrangement.spacedBy(crateSummarySpacer),
                        modifier = Modifier
                            .padding(vertical = 2.dp)
                    ) {
                        CrateOverview()
                    }
                }

                item {
                    Text("Most Downloaded")
                    Column(verticalArrangement = Arrangement.spacedBy(crateSummarySpacer)) {
                        CrateOverview()
                    }
                }

                item {
                    Text("Just Updated")
                    Column(verticalArrangement = Arrangement.spacedBy(crateSummarySpacer)) {
                        CrateOverview()
                    }
                }
            }
        }
    }
}