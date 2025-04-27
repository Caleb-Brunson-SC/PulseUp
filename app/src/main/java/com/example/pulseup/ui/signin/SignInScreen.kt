package com.example.pulseup.ui.signin

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pulseup.PulseUpTopAppBar
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
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(
    onCompleteButtonClicked: () -> Unit = {},
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            PulseUpTopAppBar(
                title = stringResource(SignInDestination.titleRes),
                canNavigateBack = true,
                navigateUp = navigateBack
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            OutlinedButton(
                modifier = Modifier.weight(1f),
                onClick = onCompleteButtonClicked
            ) {
                Text(stringResource(R.string.complete))
            }
        }
    }
}