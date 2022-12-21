package com.streamamg.jetpack.compose.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.LiveTv
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.streamamg.jetpack.compose.toolkit.composable.buttons.SimpleButtonConfig
import com.streamamg.jetpack.compose.toolkit.composable.forms.SignInForm
import com.streamamg.jetpack.compose.toolkit.composable.forms.SignUpForm
import com.streamamg.jetpack.compose.toolkit.composable.layouts.HomeLayout
import com.streamamg.jetpack.compose.demo.ui.theme.JetpackComposeKitTheme
import com.streamamg.jetpack.compose.toolkit.composable.layouts.tabs.TabContent


val defaultSimpleButtonConfig = SimpleButtonConfig(
    height = 50,
    text = "",
    backgroundColor = 0xFF6200EE,
    textColor = 0xFFFFFFFF
)


val tabs = listOf(
    TabContent(name = "Live", icon = Icons.Default.LiveTv) { LiveTabContent() },
    TabContent(name = "Upcoming", icon = Icons.Default.ArrowForward) { UpcomingTabContent() },
    TabContent(name = "Replay", icon = Icons.Default.ArrowBack) { ReplayTabContent() }
)

@Composable
fun LiveTabContent() {
    simpleTextContent("Welcome to Live Screen")
}

@Composable
fun UpcomingTabContent() {
    simpleTextContent("Welcome to Upcoming Screen")
}

@Composable
fun ReplayTabContent() {
    simpleTextContent("Welcome to Replay Screen")
}

@Composable
fun simpleTextContent (text: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFF6d23f9),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}



const val tabLayoutTitle = "Home"

val signInButtonConfig = defaultSimpleButtonConfig.copy(text = "Sign In")
val signUpButtonConfig = defaultSimpleButtonConfig.copy(text = "Sign Up")

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeKitTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    Content()
                }
            }
        }
    }

    @Composable
    fun Content() {
        var navigateToSignUp by remember { mutableStateOf(false) }
        var navigateToSignIn by remember { mutableStateOf(false) }
        var navigateToHomeScreen by remember { mutableStateOf(false) }
        when {
            navigateToHomeScreen -> HomeLayout(
                title = tabLayoutTitle,
                tabs = tabs,
                scrollable = false
            )
            navigateToSignUp -> SignInForm (
                signInButtonConfig = signInButtonConfig,
                onSignUpLinkClicked = { navigateToSignUp = true }
            ) {
                navigateToHomeScreen = true
            }
            else -> SignUpForm (
                signUpButtonConfig = signUpButtonConfig,
                onSignInLinkClicked = { navigateToSignIn = true }
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
}
