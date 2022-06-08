package io.github.andraantariksa.crates.ui.sign_in.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState
import io.github.andraantariksa.crates.R
import io.github.andraantariksa.crates.util.getActivity

@Composable
fun SignInScreen(signInViewModel: SignInViewModel = hiltViewModel()) {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        val context = LocalContext.current

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
                        context.getActivity()?.finish()
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
                val currentUrl = webViewState.content.getCurrentUrl()

                LaunchedEffect(currentUrl) {
                    if (currentUrl?.startsWith("https://crates.io/github-redirect.html?") == true) {
                        val code = currentUrl.substringAfter("code=").substringBefore("&")
                        val state = currentUrl.substringAfter("state")
                        signInViewModel.a(code, state)
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