package com.example.pulseup.ui.welcome

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pulseup.PulseUpTopAppBar
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
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(
    onSignInButtonClicked: () -> Unit = {},
    onSignUpButtonClicked: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            PulseUpTopAppBar(
                title = stringResource(WelcomeDestination.titleRes),
                showActionsIcon = false,
                canNavigateBack = false,
                navigateUp = { } // not sure what to make this
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = onSignInButtonClicked
            ) {
                Text(stringResource(R.string.sign_in))
            }

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = onSignUpButtonClicked
            ) {
                Text(stringResource(R.string.sign_up))
            }
        }
    }
}