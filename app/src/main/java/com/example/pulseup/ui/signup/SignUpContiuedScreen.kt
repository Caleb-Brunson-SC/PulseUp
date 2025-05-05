package com.example.pulseup.ui.signup

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
import androidx.compose.material3.TextButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pulseup.PulseUpTopAppBar
import com.example.pulseup.R
import com.example.pulseup.ui.navigation.NavigationDestination

/**
 * Companion object for the Sign Up Continued Screen's Navigation Destination.
 */
object SignUpContiuedDestination : NavigationDestination {
    override val route = "signup_continued"
    override val titleRes = R.string.sign_up_continued
}

/**
 * Entry route for Sign Up Continued screen.
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpContinuedScreen(
    onCompleteButtonClicked: () -> Unit = {},
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    var age by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var dailyStepGoal by remember { mutableStateOf("") }
    var dailyCalorieGoal by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            PulseUpTopAppBar(
                title = stringResource(SignUpContiuedDestination.titleRes),
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
                value = age,
                onValueChange = { age = it },
                label = { Text("Age") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = height,
                onValueChange = { height = it },
                label = { Text("Height") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = weight,
                onValueChange = { weight = it },
                label = { Text("Weight") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = dailyStepGoal,
                onValueChange = { dailyStepGoal = it },
                label = { Text("Daily Step Goal") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = dailyCalorieGoal,
                onValueChange = { dailyCalorieGoal = it },
                label = { Text("Daily Calorie Goal") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = onCompleteButtonClicked
            ) {
                Text(stringResource(R.string.complete))
            }
        }
    }
}