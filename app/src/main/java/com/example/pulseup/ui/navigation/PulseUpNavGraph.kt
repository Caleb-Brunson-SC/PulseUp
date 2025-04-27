package com.example.pulseup.ui.navigation

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pulseup.ui.activities.ActivitiesDestination
import com.example.pulseup.ui.activities.ActivitiesScreen
import com.example.pulseup.ui.home.HomeDestination
import com.example.pulseup.ui.home.HomeScreen
import com.example.pulseup.ui.profile.ProfileDestination
import com.example.pulseup.ui.profile.ProfileScreen
import com.example.pulseup.ui.record.RecordDestination
import com.example.pulseup.ui.record.RecordScreen
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
            SignInScreen(
                onCompleteButtonClicked = { navController.navigate(HomeDestination.route) },
                navigateBack = { navController.navigateUp() }
            )
        }
        composable(route = SignUpDestination.route) {
            SignUpScreen(
                onCompleteButtonClicked = { navController.navigate(HomeDestination.route) },
                navigateBack = { navController.navigateUp() }
            )
        }
        composable(route = HomeDestination.route) {
            HomeScreen()
        }
        composable(route = RecordDestination.route) {
            RecordScreen()
        }
        composable(route = ActivitiesDestination.route) {
            ActivitiesScreen()
        }
        composable(route = ProfileDestination.route) {
            ProfileScreen()
        }
    }
}