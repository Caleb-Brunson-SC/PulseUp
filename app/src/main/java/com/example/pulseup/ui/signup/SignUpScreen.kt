package com.example.pulseup.ui.signup

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pulseup.R
import com.example.pulseup.ui.navigation.NavigationDestination

/**
 * Companion object for the Sign Up Screen's Navigation Destination.
 */
object SignUpDestination : NavigationDestination {
    override val route = "signup"
    override val titleRes = R.string.sign_up
}

/**
 * Entry route for Sign Up screen.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier
) {

}