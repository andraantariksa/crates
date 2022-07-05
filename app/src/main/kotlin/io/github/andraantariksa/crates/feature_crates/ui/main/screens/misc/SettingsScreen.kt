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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import io.github.andraantariksa.crates.BuildConfig
import io.github.andraantariksa.crates.feature_crates.ui.main.UserViewModel
import io.github.andraantariksa.crates.feature_crates.ui.main.screens.misc.components.MiscItem
import io.github.andraantariksa.crates.feature_crates.ui.main.screens.misc.components.UserBriefProfile
import io.github.andraantariksa.crates.feature_crates.ui.settings.SettingsActivity
import io.github.andraantariksa.crates.feature_crates.ui.sign_in.SignInActivity
import kotlinx.coroutines.launch

@Composable
fun SettingsScreen(userViewModel: UserViewModel = hiltViewModel()) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    LazyColumn(modifier = Modifier.padding(vertical = 15.dp)) {
        item {
            val user by userViewModel.user.collectAsState(initial = null)
            UserBriefProfile(
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .padding(horizontal = 10.dp),
                user = user,
                onSignIn = {
                    context.startActivity(
                        Intent(context, SignInActivity::class.java)
                    )
                },
                onSignOut = {
                    coroutineScope.launch {
                        userViewModel.signOut()
                    }
                }
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
