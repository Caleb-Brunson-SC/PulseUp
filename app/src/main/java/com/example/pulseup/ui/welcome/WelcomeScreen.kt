package com.example.pulseup.ui.welcome

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import com.example.pulseup.ui.navigation.NavigationDestination
import com.example.pulseup.R

/**
 * Companion object for the Welcome Screen's Navigation Destination.
 */
object WelcomeDestination : NavigationDestination {
    override val route = "welcome"
    override val titleRes = R.string.app_name
}

/**
 * Entry route for welcome screen.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier
) {
    Text(text = "hello")


}