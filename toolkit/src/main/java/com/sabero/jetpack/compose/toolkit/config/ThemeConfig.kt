package com.sabero.jetpack.compose.toolkit.config


data class ThemeConfig(
    val version: String,
    val darkTheme: ColorPaletteConfig,
    val lightTheme: ColorPaletteConfig
)

data class ColorPaletteConfig(
    val primaryColor: Long,
    val primaryVariantColor: Long,
    val secondaryColor: Long,
    val backgroundColor: Long,
    val surfaceColor: Long
)

val darkColorPaletteConfig = ColorPaletteConfig(
    primaryColor = 0xFFBB86FC,
    primaryVariantColor = 0xFF3700B3,
    secondaryColor = 0xFF03DAC5,
    backgroundColor = 0xFF000000,
    surfaceColor = 0xFFFFFFFF
)

val lightColorPaletteConfig = ColorPaletteConfig(
    primaryColor = 0xFF6200EE,
    primaryVariantColor = 0xFF3700B3,
    secondaryColor = 0xFF03DAC5,
    backgroundColor = 0xFFFFFFFF,
    surfaceColor = 0xFF000000
)

val defaultTheme = ThemeConfig(
    version = "1.0",
    darkTheme = darkColorPaletteConfig,
    lightTheme = lightColorPaletteConfig
)