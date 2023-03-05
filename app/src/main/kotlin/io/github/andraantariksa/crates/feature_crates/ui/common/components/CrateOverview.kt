package io.github.andraantariksa.crates.feature_crates.ui.common.components

import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.dp
import io.github.andraantariksa.crates.feature_crates.domain.entity.crate.Crate

@Composable
fun CrateOverview(
    crate: Crate? = null,
    onClick: (() -> Unit)? = null
) {
    val density = LocalDensity.current
    Surface(
        elevation = 4.dp
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
                Column() {
                    if (crate != null) {
                        Text(crate.name)
                        Text(crate.maxVersion)
                    } else {
                        with(density) {
                            Box(
                                modifier = Modifier
                            )
                            Box(
                                modifier = Modifier
                            )
                        }
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
