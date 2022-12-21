package com.streamamg.jetpack.compose.toolkit.composable.layouts.tabs

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

data class TabContent(
    val name: String,
    val icon: ImageVector,
    val content: @Composable () -> Unit
)