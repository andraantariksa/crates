package io.github.andraantariksa.crates.feature_crates.ui.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer
import io.github.andraantariksa.crates.feature_crates.domain.entity.crate.Crate

@Composable
fun CrateOverview(
    crate: Crate? = null,
    onClick: (() -> Unit)? = null
) {
    Surface(
        elevation = 4.dp,
        modifier = Modifier.clickable(onClick != null, onClick = onClick ?: {})
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colors.surface)
                .padding(8.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    if (crate != null) {
                        Text(crate.name, fontWeight = FontWeight.Bold)
                        Text(crate.maxVersion)
                        Text(crate.description)
                    } else {
                        Text(
                            Crate.dummy.name,
                            modifier = Modifier
                                .placeholder(
                                    visible = true,
                                    highlight = PlaceholderHighlight.shimmer(),
                                )
                        )
                        Text(
                            Crate.dummy.maxVersion,
                            modifier = Modifier
                                .placeholder(
                                    visible = true,
                                    highlight = PlaceholderHighlight.shimmer(),
                                )
                        )
                        Text(
                            Crate.dummy.description,
                            modifier = Modifier
                                .placeholder(
                                    visible = true,
                                    highlight = PlaceholderHighlight.shimmer(),
                                )
                        )
                    }
                }
                Icon(
                    imageVector = Icons.Default.ChevronRight,
                    contentDescription = "See crate details"
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewCrateOverviewLoading() {
    CrateOverview()
}

@Preview
@Composable
fun PreviewCrateOverview() {
    CrateOverview(crate = Crate.dummy)
}
