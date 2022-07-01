package io.github.andraantariksa.crates.feature_crates.ui.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import io.github.andraantariksa.crates.feature_crates.domain.model.crate.Crate

@Composable
fun CrateOverview(crate: Crate, onClick: (() -> Unit)? = null) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.surface)
            .shadow(3.dp)
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Column() {
                Text(crate.name)
                Text(crate.maxVersion)
            }
            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = "See crate details"
            )
        }
    }
}
