package com.streamamg.jetpack.compose.toolkit.composable.forms



import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.streamamg.jetpack.compose.toolkit.composable.buttons.SimpleButton
import com.streamamg.jetpack.compose.toolkit.composable.buttons.SimpleButtonConfig
import com.streamamg.jetpack.compose.toolkit.composable.fields.OutlinedEmailField
import com.streamamg.jetpack.compose.toolkit.composable.fields.OutlinedPasswordField
import com.streamamg.jetpack.compose.toolkit.composable.fields.OutlinedTextField
import com.streamamg.jetpack.compose.toolkit.composable.modifiers.*

@Composable
fun SignUpForm(
    signUpButtonConfig: SimpleButtonConfig,
    onSignInLinkClicked: () -> Unit,
    onSignUpButtonClicked: () -> Unit
) {
    ConstraintLayout {
        val (logo, firstNameField, lastNameField, emailField, passwordField, confirmPasswordField, signUpButton, signInLink) = createRefs()

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

        val signInLinkModifier = signInLink.underConstrainModifier(
            underReference = signUpButton,
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

        ClickableText(
            text = AnnotatedString("Already have an account? Just Sign In"),
            onClick = {
                onSignInLinkClicked()
            },
            modifier = signInLinkModifier,
            style = TextStyle.Default.copy(color = Color(0xFFBB86FC), fontSize = 14.sp)
        )
        
        SimpleButton(
            config = signUpButtonConfig,
            modifier = signUpButtonModifier
        ) {
            onSignUpButtonClicked()
        }
    }
}