package com.streamamg.jetpack.compose.toolkit.config


data class ThemeConfig(
    val version: String,
    val darkTheme: ColorPaletteConfig,
    val lightTheme: ColorPaletteConfig
)

data class ColorPaletteConfig(
    val primaryColor: Long,
    val secondaryColor: Long,
    val tertiaryColor: Long,
    val backgroundColor: Long,
    val surfaceColor: Long
)

val lightColorPaletteConfig = ColorPaletteConfig(
    primaryColor = 0xFF6d23f9,
    secondaryColor = 0xFF684ab6,
    tertiaryColor = 0xFF7d5260,
    backgroundColor = 0xFFFFFFFF,
    surfaceColor = 0xFFfffbff
)

val darkColorPaletteConfig = ColorPaletteConfig(
    primaryColor = 0xFFcfbdff,
    secondaryColor = 0xFFcfbdff,
    tertiaryColor = 0xFFefb8c8,
    backgroundColor = 0xFF1c1b1e,
    surfaceColor = 0xFF1c1b1e
)

val defaultTheme = ThemeConfig(
    version = "1.0",
    darkTheme = darkColorPaletteConfig,
    lightTheme = lightColorPaletteConfig
)