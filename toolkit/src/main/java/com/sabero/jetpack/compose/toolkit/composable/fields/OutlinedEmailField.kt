package com.sabero.jetpack.compose.toolkit.composable.fields

import android.util.Patterns
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
import java.util.regex.Pattern

@Composable
fun OutlinedEmailField(label: String, modifier: Modifier, focusManager: FocusManager) {
    var email by rememberSaveable { mutableStateOf("") }
    var isError by rememberSaveable { mutableStateOf(false) }
    return androidx.compose.material.OutlinedTextField(
        value = email,
        onValueChange = {
            email = it
            isError = email.isNotValidEmail()
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
            onDone = { isError = email.isNotValidEmail() },
            onNext = {
                isError = email.isNotValidEmail()
                focusManager.moveFocus(FocusDirection.Down)
            }
        ),
        modifier = modifier
    )
}

private fun String.isNotValidEmail(): Boolean {
    val pattern: Pattern = Patterns.EMAIL_ADDRESS
    return this.isEmpty() || !pattern.matcher(this).matches()
}