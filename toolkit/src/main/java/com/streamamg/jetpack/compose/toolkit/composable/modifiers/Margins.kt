package com.streamamg.jetpack.compose.toolkit.composable.modifiers

const val MARGIN_MEDIUM = 16

data class Margins(
    val all: Int? = null,
    val topBottom: Int? = null,
    val startEnd: Int? = null,
    val start: Int? = null,
    val top: Int? = null,
    val end: Int? = null,
    val bottom: Int? = null
)