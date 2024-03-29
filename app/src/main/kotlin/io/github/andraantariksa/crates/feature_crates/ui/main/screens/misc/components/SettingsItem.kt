package io.github.andraantariksa.crates.feature_crates.ui.main.screens.misc.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SettingsItem(
    title: String,
    subtitle: String? = null,
    modifier: Modifier = Modifier,
    icon: (@Composable () -> Unit)? = null,
    onClick: (() -> Unit)? = null
) {
    val _modifier = if (onClick != null) {
        Modifier
            .clickable {
                onClick()
            }
            .then(modifier)
    } else {
        modifier
    }
    Row(
        modifier = _modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon?.invoke()
        val textStartPadding = if (icon != null) 10.dp else 0.dp
        Column(
            modifier = Modifier.padding(start = textStartPadding),
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold
            )
            subtitle?.let { subtitle ->
                Text(
                    text = subtitle,
                    fontSize = MaterialTheme.typography.subtitle1.fontSize
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewSettingsItem() {
    SettingsItem(
        title = "Test",
        subtitle = "Some explanation"
    )
}
