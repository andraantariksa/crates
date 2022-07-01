package io.github.andraantariksa.crates.feature_crates.ui.main.screens.misc

import android.content.Intent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.andraantariksa.crates.BuildConfig
import io.github.andraantariksa.crates.feature_crates.ui.main.screens.misc.components.MiscItem
import io.github.andraantariksa.crates.feature_crates.ui.main.screens.misc.components.UserBriefProfile
import io.github.andraantariksa.crates.feature_crates.ui.settings.SettingsActivity

@Composable
fun SettingsScreen() {
    val context = LocalContext.current
    LazyColumn(modifier = Modifier.padding(vertical = 15.dp)) {
        item {
            UserBriefProfile(
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .padding(horizontal = 10.dp)
            )
        }
        item {
            MiscItem(
                "Settings",
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
            MiscItem(
                "About",
                "Version ${BuildConfig.VERSION_NAME}",
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 18.dp)
                    .fillMaxWidth(),
                icon = {
                    Icon(imageVector = Icons.Default.Info, contentDescription = "About")
                }
            )
        }
    }
}

@Composable
@Preview
fun PreviewSettingsScreen() {
    SettingsScreen()
}
