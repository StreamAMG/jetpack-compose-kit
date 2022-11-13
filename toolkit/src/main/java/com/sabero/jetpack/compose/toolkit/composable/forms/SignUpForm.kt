package com.sabero.jetpack.compose.toolkit.composable.forms

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.sabero.jetpack.compose.toolkit.composable.buttons.SimpleButton
import com.sabero.jetpack.compose.toolkit.composable.buttons.SimpleButtonConfig
import com.sabero.jetpack.compose.toolkit.composable.fields.OutlinedEmailField
import com.sabero.jetpack.compose.toolkit.composable.fields.OutlinedPasswordField
import com.sabero.jetpack.compose.toolkit.composable.fields.OutlinedTextField
import com.sabero.jetpack.compose.toolkit.composable.modifiers.*
import timber.log.Timber

@Composable
fun SignUpForm(
    signUpButtonConfig: SimpleButtonConfig,
    onSignUpButtonClicked: () -> Unit
) {
    val context = LocalContext.current
    ConstraintLayout {
        val (logo, firstNameField, lastNameField, emailField, passwordField, confirmPasswordField, signUpButton) = createRefs()

        val logoModifier = logo.innerConstrainModifier(
            scope = this,
            margins = Margins(top = 100, startEnd = MARGIN_MEDIUM)
        )

        val firstNameFieldModifier = firstNameField.underConstrainModifier(
            underReference = logo,
            scope = this,
            margins = Margins(start = MARGIN_MEDIUM, top = MARGIN_MEDIUM, end = MARGIN_MEDIUM)
        )

        val lastNameFieldModifier = lastNameField.underConstrainModifier(
            underReference = firstNameField,
            scope = this,
            margins = Margins(start = MARGIN_MEDIUM, top = MARGIN_MEDIUM, end = MARGIN_MEDIUM)
        )

        val emailFieldModifier = emailField.underConstrainModifier(
            underReference = lastNameField,
            scope = this,
            margins = Margins(start = MARGIN_MEDIUM, top = MARGIN_MEDIUM, end = MARGIN_MEDIUM)
        )

        val passwordFieldModifier = passwordField.underConstrainModifier(
            underReference = emailField,
            scope = this,
            margins = Margins(start = MARGIN_MEDIUM, top = MARGIN_MEDIUM, end = MARGIN_MEDIUM)
        )

        val confirmPasswordFieldModifier = confirmPasswordField.underConstrainModifier(
            underReference = passwordField,
            scope = this,
            margins = Margins(start = MARGIN_MEDIUM, top = MARGIN_MEDIUM, end = MARGIN_MEDIUM)
        )

        val signUpButtonModifier = signUpButton.underConstrainModifier(
            underReference = confirmPasswordField,
            scope = this,
            margins = Margins(start = MARGIN_MEDIUM, top = MARGIN_MEDIUM, end = MARGIN_MEDIUM)
        )

        val focusManager = LocalFocusManager.current
        Text(text = "Sign Up", modifier = logoModifier, fontSize = 22.sp, color = Color(0xFFBB86FC))
        OutlinedTextField(label = "First name", modifier = firstNameFieldModifier, focusManager)
        OutlinedTextField(label = "Last name", modifier = lastNameFieldModifier, focusManager)
        OutlinedEmailField(label = "Email", modifier = emailFieldModifier, focusManager)
        OutlinedPasswordField(label = "Password", modifier = passwordFieldModifier, focusManager)
        OutlinedPasswordField(label = "Confirm password", modifier = confirmPasswordFieldModifier, focusManager)

        SimpleButton(
            config = signUpButtonConfig,
            modifier = signUpButtonModifier
        ) {
            onSignUpButtonClicked()
            Toast.makeText(context, "Sign Up clicked", Toast.LENGTH_LONG).show()
        }
    }
}

@Preview
@Composable
fun SignUpFormPreview() {
    val signUpButtonConfig = SimpleButtonConfig(
        text = "Sign Up",
        backgroundColor = 0xFF6200EE,
        textColor = 0xFFFFFFFF
    )

    SignUpForm(signUpButtonConfig) {
        Timber.i(" ---> Sign Up clicked")
    }
}