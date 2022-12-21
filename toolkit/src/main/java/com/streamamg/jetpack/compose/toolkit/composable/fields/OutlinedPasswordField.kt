package com.streamamg.jetpack.compose.toolkit.composable.fields

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun OutlinedPasswordField(label: String, modifier: Modifier, focusManager: FocusManager) {
    var password by rememberSaveable { mutableStateOf("") }
    var visibility by remember { mutableStateOf(false) }
    return androidx.compose.material.OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        singleLine = true,
        maxLines = 1,
        label = { Text(label) },
        visualTransformation = if (visibility) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
        ),
        trailingIcon = {
            val image = if (visibility)
                Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff

            IconButton(onClick = {
                visibility = !visibility
            }) {
                Icon(imageVector = image, "")
            }
        },
        modifier = modifier
    )
}

fun String.isValidPassword(): Boolean {
    return this.length > 6
}