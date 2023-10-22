package io.github.andraantariksa.crates.feature_crates.ui.sign_in.screen

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState
import io.github.andraantariksa.crates.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignInScreen(signInViewModel: SignInViewModel = koinViewModel()) {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        val context = LocalContext.current
        val activity = remember(context) { context as? Activity }

        LaunchedEffect(Unit) {
            signInViewModel.getSignInOauthUrl()
        }

        val _signInOauthUrl by signInViewModel.signInOauthUrl.collectAsState()
        val signInOauthUrl = _signInOauthUrl

        Column {
            val containerColor = MaterialTheme.colors.primary
            val contentColor = contentColorFor(containerColor)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(containerColor),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(
                    onClick = {
                        activity?.finish()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close",
                        tint = contentColor
                    )
                }
                Text(
                    text = "Sign In",
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    color = contentColor
                )
            }
            if (signInOauthUrl != null) {
                val webViewState = rememberWebViewState(signInOauthUrl)
                val currentUrl = webViewState.lastLoadedUrl

                LaunchedEffect(currentUrl) {
                    if (currentUrl?.startsWith("https://crates.io/github-redirect.html?") == true) {
                        val code = currentUrl.substringAfter("code=").substringBefore("&")
                        val state = currentUrl.substringAfter("state=")
                        signInViewModel.authorizeOauth(code, state)
                        activity?.finish()
                    }
                }

                WebView(
                    webViewState,
                    captureBackPresses = false,
                    onCreated = { webView ->
                        webView.settings.run {
                            @Suppress("setJavaScriptEnabled")
                            javaScriptEnabled = true
                        }
                    }
                )
            } else {
                val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
                LottieAnimation(
                    composition,
                )
                Text(text = "Loading...")
            }
        }
    }
}

@Preview
@Composable
fun PreviewSignInScreen() {
    SignInScreen()
}