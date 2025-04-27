package com.example.pulseup.ui.home

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.pulseup.PulseUpTopAppBar
import com.example.pulseup.R
import com.example.pulseup.ui.navigation.BottomNavigationBar
import com.example.pulseup.ui.navigation.NavigationDestination
import com.example.pulseup.ui.signup.SignUpDestination

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
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            PulseUpTopAppBar(
                title = stringResource(HomeDestination.titleRes),
                canNavigateBack = false,
                navigateUp = { } // not sure what to make this
            )
        }
    ) {

    }
}