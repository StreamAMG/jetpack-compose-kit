package com.streamamg.jetpack.compose.toolkit.composable.buttons


import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun SimpleButton(
    config: SimpleButtonConfig,
    modifier: Modifier,
    onSimpleButtonClicked: () -> Unit
) {
    return Button(
        onClick = {
            onSimpleButtonClicked()
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(config.backgroundColor)),
        modifier = when {
            config.height != null && config.width != null -> {
                modifier.height(config.height.dp).width(config.width.dp)
            }
            config.height != null && config.width == null -> {
                modifier.height(config.height.dp)
            }
            config.height == null && config.width != null -> {
                modifier.width(config.width.dp)
            }
            else -> {
                modifier
            }
        }
    ) {
        Text(
            text = config.text,
            style = TextStyle(
                color = Color(config.textColor)
            )
        )
    }
}

data class SimpleButtonConfig(
    val width: Int? = null,
    val height: Int? = null,
    val text: String,
    val backgroundColor: Long,
    val textColor: Long
)