package com.example.pulseup

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.pulseup.ui.signin.SignInScreen
import com.example.pulseup.ui.signup.SignUpScreen
import com.example.pulseup.UserViewModel
import com.example.pulseup.ui.navigation.PulseUpNavHost
import com.example.pulseup.ui.theme.PulseUpTheme

@Composable
fun PulseUpNavigation(userViewModel: UserViewModel ) {
    val navController = rememberNavController()

    PulseUpTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            PulseUpNavHost(
                userViewModel = userViewModel,
                navController = navController)


        }
    }
}
