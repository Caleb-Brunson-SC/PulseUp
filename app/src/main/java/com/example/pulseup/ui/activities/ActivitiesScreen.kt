package com.example.pulseup.ui.activities

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.pulseup.PulseUpTopAppBar
import com.example.pulseup.R
import com.example.pulseup.ui.home.HomeDestination
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
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivitiesScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            PulseUpTopAppBar(
                title = stringResource(ActivitiesDestination.titleRes),
                showActionsIcon = true,
                canNavigateBack = false
            )
        }
    ) {

    }
}