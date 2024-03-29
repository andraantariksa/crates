package io.github.andraantariksa.crates.feature_crates.ui.common.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CratesTheme(content: @Composable () -> Unit) {
    val colors = remember {
        lightColors(
            secondary = Color(0xffffc933),
            primary = Color(0xff3b6837),
            background = Color(0xfff9f7ec),
            surface = Color.White,
            onSurface = Color(0xff383838),
            onPrimary = Color(0xffffffff),
            onSecondary = Color(0xff383838)
        )
    }
    MaterialTheme(colors) {
        content()
    }
}

@Composable
@Preview
fun PreviewCratesTheme() {
    CratesTheme {
        Text(text = "Hello there")
    }
}