package com.streamamg.jetpack.compose.toolkit.composable.fields

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun OutlinedTextField(label: String, modifier: Modifier, focusManager: FocusManager) {
    var text by rememberSaveable { mutableStateOf("") }
    var isError by rememberSaveable { mutableStateOf(false) }
    return androidx.compose.material.OutlinedTextField(
        value = text,
        onValueChange = {
            text = it
            isError = text.isEmpty()
        },
        singleLine = true,
        maxLines = 1,
        label = { Text(label) },
        isError = isError,
        trailingIcon = {
            if (isError)
                Icon(Icons.Filled.Error, "error", tint = MaterialTheme.colors.error)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onDone = { isError = text.isEmpty() },
            onNext = {
                isError = text.isEmpty()
                focusManager.moveFocus(FocusDirection.Down)
            }
        ),
        modifier = modifier
    )
}