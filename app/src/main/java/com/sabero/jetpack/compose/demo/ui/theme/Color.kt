package com.sabero.jetpack.compose.demo.ui.theme

import androidx.compose.ui.graphics.Color
import com.sabero.jetpack.compose.toolkit.config.defaultTheme

val darkThemeConfig = defaultTheme.darkTheme
val lightThemeConfig = defaultTheme.darkTheme

val darkPrimary = Color(darkThemeConfig.primaryColor)
val darkPrimaryVariantColor = Color(darkThemeConfig.primaryVariantColor)
val darkSecondaryColor = Color(darkThemeConfig.secondaryColor)
val darkBackgroundColor = Color(darkThemeConfig.backgroundColor)
val darkSurfaceColor = Color(darkThemeConfig.surfaceColor)

val lightPrimary = Color(lightThemeConfig.primaryColor)
val lightPrimaryVariantColor = Color(lightThemeConfig.primaryVariantColor)
val lightSecondaryColor = Color(lightThemeConfig.secondaryColor)
val lightBackgroundColor = Color(lightThemeConfig.backgroundColor)
val lightSurfaceColor = Color(lightThemeConfig.surfaceColor)