package io.github.andraantariksa.crates.ui.common

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val icon: ImageVector,
    val name: String,
    val route: String
)