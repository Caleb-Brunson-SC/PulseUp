package com.example.pulseup.ui.profile

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.pulseup.PulseUpTopAppBar
import com.example.pulseup.R
import com.example.pulseup.ui.navigation.NavigationDestination
import com.example.pulseup.ui.signup.SignUpContiuedDestination

/**
 * Companion object for the Profile Screen's Navigation Destination.
 */
object EditProfileDestination : NavigationDestination {
    override val route = "edit_profile"
    override val titleRes = R.string.edit_profile
}

/**
 * Entry route for Profile screen.
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            PulseUpTopAppBar(
                title = stringResource(EditProfileDestination.titleRes),
                showActionsIcon = false,
                canNavigateBack = true,
                navigateUp = navigateBack
            )
        }
    ) {

    }
}