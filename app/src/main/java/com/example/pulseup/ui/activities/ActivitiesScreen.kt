package com.example.pulseup.ui.activities

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pulseup.R
import com.example.pulseup.ui.navigation.NavigationDestination

/**
 * Companion object for the Activities Navigation Destination.
 */
object ActivitiesDestination : NavigationDestination {
    override val route = "activities"
    override val titleRes = R.string.activities
}

/**
 * Entry route for Activities screen.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivitiesScreen(
    modifier: Modifier = Modifier
) {

}