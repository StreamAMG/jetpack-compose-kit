package com.sabero.jetpack.compose.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sabero.jetpack.compose.demo.ui.theme.JetpackComposeKitTheme
import com.sabero.jetpack.compose.toolkit.*
import com.sabero.jetpack.compose.toolkit.composable.buttons.SimpleButtonConfig
import com.sabero.jetpack.compose.toolkit.composable.forms.SignInForm
import com.sabero.jetpack.compose.toolkit.composable.forms.SignUpForm
import com.sabero.jetpack.compose.toolkit.composable.layouts.HomeLayout
import kotlinx.coroutines.launch


val defaultSimpleButtonConfig = SimpleButtonConfig(
    height = 50,
    text = "",
    backgroundColor = 0xFF6200EE,
    textColor = 0xFFFFFFFF
)

val signInButtonConfig = defaultSimpleButtonConfig.copy(text = "Sign In")
val signUpButtonConfig = defaultSimpleButtonConfig.copy(text = "Sign Up")

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeKitTheme {
                val scaffoldState = rememberBackdropScaffoldState(
                    BackdropValue.Concealed
                )
                val scope = rememberCoroutineScope()
                BackdropScaffold(
                    scaffoldState = scaffoldState,
                    appBar = {
                        TopAppBar(
                            title = { Text("JetPack Compose Kit") },
                            navigationIcon = {
                                if (scaffoldState.isConcealed) {
                                    IconButton(
                                        onClick = {
                                            scope.launch { scaffoldState.reveal() }
                                        }
                                    ) {
                                        Icon(
                                            Icons.Default.Menu,
                                            contentDescription = "Menu"
                                        )
                                    }
                                } else {
                                    IconButton(
                                        onClick = {
                                            scope.launch { scaffoldState.conceal() }
                                        }
                                    ) {
                                        Icon(
                                            Icons.Default.Close,
                                            contentDescription = "Close"
                                        )
                                    }
                                }
                            },
                            elevation = 0.dp,
                            backgroundColor = Color.Transparent
                        )
                    },
                    backLayerContent = {
                        // Back layer content
                    },
                    frontLayerContent = {
                        // A surface container using the 'background' color from the theme
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colors.background
                        ) {
                            Content()
                        }
                    }
                )

            }
        }
    }

    @Composable
    fun Content() {
        var navigateToSignUp by remember { mutableStateOf(false) }
        var navigateToHomeScreen by remember { mutableStateOf(false) }
        when {
            navigateToSignUp -> navigateToSignUpScreen()
            navigateToHomeScreen -> HomeLayout()
            else -> SignInForm (
                signInButtonConfig = signInButtonConfig,
                onSignUpLinkClicked = { navigateToSignUp = true }
            ) {
                navigateToHomeScreen = true
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        JetpackComposeKitTheme {
            Content()
        }
    }

    @Composable
    private fun navigateToSignUpScreen() {
        var navigateToHomeScreen by remember { mutableStateOf(false) }
        when {
            navigateToHomeScreen -> HomeLayout()
            else -> SignUpForm (signUpButtonConfig) {
                navigateToHomeScreen = true
            }
        }
    }
}
