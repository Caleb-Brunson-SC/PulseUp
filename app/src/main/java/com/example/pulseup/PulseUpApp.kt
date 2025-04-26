package com.example.pulseup

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pulseup.ui.navigation.PulseUpNavHost

/**
 * Top level composable that represents screens for the application.
 */
@Composable
fun PulseUpApp(navController: NavHostController = rememberNavController()) {
    PulseUpNavHost(navController = navController)
}

/**
 * Top app bar to display the title and conditionally display the back navigation.
 */
