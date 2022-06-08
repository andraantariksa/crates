package io.github.andraantariksa.crates.ui.common.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Crate(title: String, version: String) {
    Row() {
        Row() {
            Text(title)
            Spacer(Modifier.padding(horizontal = 5.dp))
            Text(version)
        }
        Icon(
            imageVector = Icons.Default.ChevronRight,
            contentDescription = "See crate details"
        )
    }
}
