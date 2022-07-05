package io.github.andraantariksa.crates.feature_crates.ui.main.screens.misc.components

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.andraantariksa.crates.feature_crates.domain.model.user.User
import io.github.andraantariksa.crates.feature_crates.ui.sign_in.SignInActivity

@Composable
fun UserBriefProfile(
    modifier: Modifier = Modifier,
    user: User? = null,
    onSignOut: () -> Unit = {},
    onSignIn: () -> Unit = {}
) {
    Box(modifier) {
        if (user == null) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Default user profile picture",
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                )
                Button(
                    onClick = onSignIn,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.secondary,
                    )
                ) {
                    Text(text = "Sign In")
                }
            }
        } else {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row {
//                    AsyncImage(
//                        imageVector = Icons.Default.Person,
//                        contentDescription = "User profile picture",
//                        modifier = Modifier
//                            .width(50.dp)
//                            .height(50.dp)
//                    )
                    Text(user.name)
                    Text(user.email)
                }
                Button(
                    onClick = onSignOut,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.secondary,
                    )
                ) {
                    Text(text = "Sign Out")
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewUserBriefProfile() {
    UserBriefProfile()
}