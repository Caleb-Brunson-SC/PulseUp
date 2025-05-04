package com.example.pulseup.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pulseup.DashboardScreen
import com.example.pulseup.UserViewModel
//import com.example.pulseup.LoginScreen
//import com.example.pulseup.DashboardScreen
import com.example.pulseup.ui.activities.ActivitiesDestination
import com.example.pulseup.ui.activities.ActivitiesScreen
import com.example.pulseup.ui.home.HomeDestination
import com.example.pulseup.ui.home.HomeScreen
import com.example.pulseup.ui.profile.ProfileDestination
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.pulseup.ui.profile.ProfileScreen
import com.example.pulseup.ui.record.RecordDestination
import com.example.pulseup.ui.record.RecordScreen
import com.example.pulseup.ui.settings.SettingsDestination
import com.example.pulseup.ui.settings.SettingsScreen
import com.example.pulseup.ui.signin.SignInDestination
import com.example.pulseup.ui.signin.SignInScreen
import com.example.pulseup.ui.signup.SignUpDestination
import com.example.pulseup.ui.signup.SignUpScreen
import com.example.pulseup.ui.welcome.WelcomeDestination
import com.example.pulseup.ui.welcome.WelcomeScreen

@Composable
fun PulseUpNavHost(
    modifier: Modifier = Modifier,
    userViewModel: UserViewModel = hiltViewModel(),
    navController: NavHostController,
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
            )
        }


        composable(route = HomeDestination.route) {
            DashboardScreen(
                navController = navController,
                userViewModel = userViewModel
            )
        }

        composable(route = RecordDestination.route) {
            RecordScreen(
                navigateBack = { navController.navigateUp() }

            )
        }

        composable(route = ActivitiesDestination.route) {
            ActivitiesScreen(
                navigateBack = { navController.navigateUp() }
            )
        }

        composable(route = ProfileDestination.route) {
            ProfileScreen(
                viewModel = userViewModel,
                navigateBack = { navController.navigateUp() }

            )

        }



        composable(route = SettingsDestination.route) {
            SettingsScreen()
        }
    }
}
