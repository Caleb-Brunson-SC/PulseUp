package com.example.pulseup.ui.signin

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pulseup.R
import com.example.pulseup.ui.navigation.NavigationDestination

/**
 * Companion object for the Sign In Screen's Navigation Destination.
 */
object SignInDestination : NavigationDestination {
    override val route = "signin"
    override val titleRes = R.string.sign_in
}

/**
 * Entry route for Sign In screen.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(
    modifier: Modifier = Modifier
) {

}