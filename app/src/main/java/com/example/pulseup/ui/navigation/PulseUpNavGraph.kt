package com.example.pulseup.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
            WelcomeScreen()
        }
    }
}