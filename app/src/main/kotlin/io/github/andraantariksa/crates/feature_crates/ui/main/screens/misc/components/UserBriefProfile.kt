package io.github.andraantariksa.crates.feature_crates.ui.main.screens.misc.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import io.github.andraantariksa.crates.feature_crates.domain.entity.user.User

@Composable
private fun UserBriefProfileUnauthenticated(onSignIn: () -> Unit = {}) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                imageVector = Icons.Default.Person,
                contentDescription = "Default user profile picture",
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
            )
            Text("You have not yet signed in")
        }
        Button(
            onClick = onSignIn,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.secondary,
            )
        ) {
            Text(text = "Sign In")
        }
    }
}

@Composable
fun UserBriefProfileAuthenticated(user: User, onSignOut: () -> Unit) {
    var showSignOutDialog by remember { mutableStateOf(false) }
    val fallbackImage = rememberVectorPainter(Icons.Default.Person)

    if (showSignOutDialog) {
        AlertDialog(
            onDismissRequest = {
                showSignOutDialog = false
            },
            title = {
                Text("Are you sure you want to sign out?")
            },
            text = {
                Text("You need to sign in again to access your account")
            },
            confirmButton = {
                Button(
                    onClick = {
                        onSignOut()
                        showSignOutDialog = false
                    }
                ) {
                    Text("Yes")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        showSignOutDialog = false
                    }
                ) {
                    Text("Cancel")
                }
            }
        )
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = user.avatar,
                placeholder = fallbackImage,
                error = fallbackImage,
                contentDescription = "User profile picture",
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
            )
            Column {
                Text(user.name, fontWeight = FontWeight.Bold)
                Text(user.email)
            }
        }
        Button(
            onClick = {
                showSignOutDialog = true
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.secondary,
            )
        ) {
            Text(text = "Sign Out")
        }
    }
}

@Composable
fun UserBriefProfile(
    modifier: Modifier = Modifier,
    user: User? = null,
    onSignOut: () -> Unit = {},
    onSignIn: () -> Unit = {}
) {
    Box(modifier) {
        if (user == null) {
            UserBriefProfileUnauthenticated(onSignIn = onSignIn)
        } else {
            UserBriefProfileAuthenticated(user = user, onSignOut = onSignOut)
        }
    }
}

@Preview
@Composable
fun PreviewUserBriefProfileAuthenticated() {
    UserBriefProfile()
}

@Preview
@Composable
fun PreviewUserBriefProfileUnauthenticated() {
    UserBriefProfile(
        user = User(
            userId = 0,
            name = "Andra Antariksa Prihadi",
            avatar = null,
            email = "andra.antariksa@gmail.com",
            emailVerificationSent = false,
            emailVerified = false,
            username = "andraantariksa",
            url = ""
        )
    )
}