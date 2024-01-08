package io.github.andraantariksa.crates.feature_crates.ui.sign_in.screen

import android.app.Activity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignIn(signInViewModel: SignInViewModel = koinViewModel()) {
    SignInScreen(
        getSignInOauthURL = signInViewModel::getSignInOauthUrl,
        authorizeOauth = signInViewModel::authorizeOauth,
        signInURLFlow = signInViewModel.signInURL
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(
    getSignInOauthURL: () -> Unit,
    authorizeOauth: suspend (String, String, () -> Unit) -> Unit,
    signInURLFlow: Flow<String?>
) {
    val context = LocalContext.current
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val _signInURL by signInURLFlow.collectAsState(initial = null)
    val signInURL = _signInURL

    LaunchedEffect(Unit) {
        getSignInOauthURL()
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Sign In")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        (context as? Activity)?.finish()
                    }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Localized description"
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
        ) {
            if (signInURL != null) {
                SignInWebView(
                    authorizeOauth = authorizeOauth,
                    signInURL = signInURL,
                )
            } else {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewSignInScreen() {
    SignInScreen(
        getSignInOauthURL = {},
        authorizeOauth = { _, _, _ -> },
        signInURLFlow = flowOf(null)
    )
}

@Composable
fun SignInWebView(
    authorizeOauth: suspend (String, String, () -> Unit) -> Unit,
    signInURL: String
) {
    val context = LocalContext.current
    val webViewState = rememberWebViewState(signInURL)
    val currentUrl = webViewState.lastLoadedUrl

    LaunchedEffect(currentUrl) {
        if (currentUrl?.startsWith("https://crates.io/github-redirect.html?") == true) {
            val code = currentUrl.substringAfter("code=").substringBefore("&")
            val state = currentUrl.substringAfter("state=")
            authorizeOauth(code, state) {
                (context as? Activity)?.finish()
            }
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
}