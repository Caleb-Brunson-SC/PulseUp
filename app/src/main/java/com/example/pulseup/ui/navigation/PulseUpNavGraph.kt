package com.example.pulseup.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pulseup.UserViewModel
import com.example.pulseup.ui.goals.GoalsDestination
import com.example.pulseup.ui.goals.GoalsScreen
import com.example.pulseup.ui.activities.ActivitiesDestination
import com.example.pulseup.ui.activities.ActivitiesScreen
import com.example.pulseup.ui.goals.AddGoalDestination
import com.example.pulseup.ui.goals.AddGoalScreen
import com.example.pulseup.ui.home.HomeDestination
import com.example.pulseup.ui.home.HomeScreen
import com.example.pulseup.ui.profile.EditProfileDestination
import com.example.pulseup.ui.profile.EditProfileScreen
import com.example.pulseup.ui.profile.ProfileDestination
import com.example.pulseup.ui.profile.ProfileScreen
import com.example.pulseup.ui.record.RecordDestination
import com.example.pulseup.ui.record.RecordScreen
import com.example.pulseup.ui.settings.SettingsDestination
import com.example.pulseup.ui.settings.SettingsScreen
import com.example.pulseup.ui.signin.SignInDestination
import com.example.pulseup.ui.signin.SignInScreen
import com.example.pulseup.ui.signup.SignUpContinuedScreen
import com.example.pulseup.ui.signup.SignUpContiuedDestination
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
    userViewModel: UserViewModel = hiltViewModel()
) {
    NavHost(
        navController = navController,
        startDestination = WelcomeDestination.route,
        modifier = modifier
    ) {
        composable(route = WelcomeDestination.route) {
            WelcomeScreen(
                onSignInButtonClicked = { navController.navigate(SignInDestination.route) },
                onSignUpButtonClicked = { navController.navigate(SignUpDestination.route) }
            )
        }
        composable(route = SignInDestination.route) {
            SignInScreen(
                onCompleteButtonClicked = { navController.navigate(HomeDestination.route) },
                onLoginSuccess = { navController.navigate(HomeDestination.route) },
                onSignUp = { navController.navigate(SignUpDestination.route) },
                navigateBack = { navController.navigateUp() }
            )
        }
        composable(route = SignUpDestination.route) {
            SignUpScreen(
                viewModel = userViewModel,
                onSignUpSuccess = { navController.navigate(HomeDestination.route) },
                onLogin = { navController.navigate(SignInDestination.route) },
                navigateBack = { navController.navigateUp() }
                //onContinueButtonClicked = { navController.navigate(SignUpContiuedDestination.route) },
            )
        }
        composable(route = SignUpContiuedDestination.route) {
            SignUpContinuedScreen(
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
        composable(route = GoalsDestination.route) {
            GoalsScreen()
        }
        composable(route = AddGoalDestination.route) {
            AddGoalScreen(
                navigateBack = { navController.navigateUp() }
            )
        }
        composable(route = ProfileDestination.route) {
            ProfileScreen()
        }
        composable(route = EditProfileDestination.route) {
            EditProfileScreen(
                navigateBack = { navController.navigateUp() }
            )
        }
        composable(route = SettingsDestination.route) {
            SettingsScreen()
        }
    }
}