package io.github.andraantariksa.crates.feature_crates.ui.settings

import android.content.Intent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import io.github.andraantariksa.crates.feature_crates.ui.main.screens.misc.components.SettingsItem

@Composable
fun SettingsScreen() {
    val context = LocalContext.current

    LazyColumn() {
        item {
            SettingsItem(
                "Theme",
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 18.dp)
                    .fillMaxWidth(),
                icon = {
                    Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings")
                }
            ) {
                context.startActivity(
                    Intent(context, SettingsActivity::class.java)
                )
            }
        }
    }
}