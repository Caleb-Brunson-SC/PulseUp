package com.example.pulseup.ui.navigation

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pulseup.ui.signin.SignInDestination
import com.example.pulseup.ui.signin.SignInScreen
import com.example.pulseup.ui.signup.SignUpDestination
import com.example.pulseup.ui.signup.SignUpScreen
import com.example.pulseup.ui.welcome.WelcomeDestination
import com.example.pulseup.ui.welcome.WelcomeScreen

/**
 * Provides Navigation graph for the application.
 */
@Composable
fun PulseUpNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = WelcomeDestination.route,
        modifier = modifier
    ) {
        composable(route = WelcomeDestination.route) {
            WelcomeScreen(
                onSignInButtonClicked = { navController.navigate(SignInDestination.route) },
                onSignUpButtonClicked = { navController.navigate(SignUpDestination.route) },
            )
        }
        composable(route = SignInDestination.route) {
            SignInScreen()
        }
        composable(route = SignUpDestination.route) {
            SignUpScreen()
        }
    }
}