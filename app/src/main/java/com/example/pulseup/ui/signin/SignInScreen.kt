package com.example.pulseup.ui.signin

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pulseup.PulseUpTopAppBar
import com.example.pulseup.R
import com.example.pulseup.UserViewModel
import com.example.pulseup.ui.navigation.NavigationDestination
import androidx.hilt.navigation.compose.hiltViewModel

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
    userViewModel: UserViewModel = hiltViewModel(),
    onLoginSuccess: () -> Unit,
    onSignUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    val user by userViewModel.user.observeAsState()

    val errorMessage = userViewModel.errorMessage.observeAsState()

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    LaunchedEffect(user) {
        if (user != null) {
            onLoginSuccess()
        }
    }

    Scaffold(
        topBar = {
            PulseUpTopAppBar(
                title = stringResource(SignInDestination.titleRes),
                showActionsIcon = false,
                canNavigateBack = true,
                navigateUp = navigateBack
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    userViewModel.login(username, password)
                    onCompleteButtonClicked()
                }
            ) {
                Text(stringResource(R.string.sign_in))
            }
        }
    }
}