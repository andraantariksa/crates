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
import io.github.andraantariksa.crates.feature_crates.ui.sign_in.SignInActivity

data class UserBriefProfile(
    val name: String,
    val imageUrl: String
)

@Composable
fun UserBriefProfile(modifier: Modifier = Modifier, userBriefProfile: UserBriefProfile? = null) {
    val context = LocalContext.current
    Box(modifier) {
        if (userBriefProfile == null) {
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
                    onClick = {
                        context.startActivity(
                            Intent(context, SignInActivity::class.java)
                        )
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.secondary,
                    )
                ) {
                    Text(text = "Sign In")
                }
            }
        } else {

        }
    }
}

@Preview
@Composable
fun PreviewUserBriefProfile() {
    UserBriefProfile()
}