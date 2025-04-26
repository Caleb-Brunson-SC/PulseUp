package com.example.pulseup.ui.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pulseup.R
import com.example.pulseup.ui.navigation.NavigationDestination

/**
 * Companion object for the Home Screen's Navigation Destination.
 */
object HomeDestination : NavigationDestination {
    override val route = "home"
    override val titleRes = R.string.home
}

/**
 * Entry route for Home screen.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {

}