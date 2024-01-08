package io.github.andraantariksa.crates.feature_crates.ui.crate

import android.app.Activity
import android.widget.TextView
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddToQueue
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Balance
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import org.koin.androidx.compose.koinViewModel

@Composable
fun CrateScreen(crateId: String?, crateViewModel: CrateViewModel = koinViewModel()) {
    LaunchedEffect(Unit) {
        crateViewModel.load(crateId)
    }

    Crate(example)
}

data class CrateExample(
    val title: String,
    val version: String,
    val description: String,
    val tags: List<String>
)

val example = CrateExample(
    "Register",
    "v1.0.2",
    "Common interface for MMIO and CPU registers",
    listOf("cpu", "embedded", "bare-metal", "registers", "mmio")
)

enum class CrateTabs {
    Readme,
    Versions,
    Dependencies,
    Dependents
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun Crate(
    crate: CrateExample
) {
    val context = LocalContext.current
    val pagerState = rememberPagerState(pageCount = { 4 })

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Column {
                        Row {
                            Text(crate.title)
                            Text(crate.version)
                        }
                        Text(
                            crate.description,
                            fontSize = MaterialTheme.typography.bodySmall.fontSize
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {
                        (context as? Activity)?.finish()
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            HorizontalPager(state = pagerState) { page ->
                when (page) {
                    0 -> Readme()
                    else -> {}
                }
            }
        }
    }
}

@Preview
@Composable
fun CratePreview() {
    Crate(example)
}

@Composable
fun Readme() {
    Column {
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = {
                TextView(it).apply {
                    text = "Thumbs"
                }
            },
            update = {

            }
        )
    }
    Column {
        Text("Metadata")
        Row {
            Icon(
                imageVector = Icons.Default.CalendarMonth,
                contentDescription = null
            )
            Text("about 3 years ago")
        }
        Row {
            Icon(imageVector = Icons.Default.Balance, contentDescription = null)
            Text("MIT or Apache-2.0")
        }
        Row {
            Icon(
                imageVector = Icons.Default.AddToQueue,
                contentDescription = null
            )
            Text("8.6 KiB")
        }
    }
}

@Preview
@Composable
fun PreviewReadme() {
    Readme()
}