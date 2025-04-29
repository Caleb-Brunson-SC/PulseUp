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
 * Companion object for the Sign Up Screen's Navigation Destination.
 */
object SignUpDestination : NavigationDestination {
    override val route = "signup"
    override val titleRes = R.string.sign_up
}

/**
 * Entry route for Sign Up screen.
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    viewModel: UserViewModel = hiltViewModel(),
    onSignUpSuccess: () -> Unit,
    onLogin: () -> Unit,


//    onCompleteButtonClicked: () -> Unit = {},
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val user = viewModel.user.observeAsState()
    val errorMessage = viewModel.errorMessage.observeAsState()

//    var fullName by remember { mutableStateOf("") }
//    var username by remember { mutableStateOf("") }
//    var email by remember { mutableStateOf("") }
//    var dateOfBirth by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//    var confirmPassword by remember{ mutableStateOf("") }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var dailyStepGoal by remember { mutableStateOf("") }
    var dailyCalorieGoal by remember { mutableStateOf("") }

    LaunchedEffect(user) {
        if (user.value != null) {
            onSignUpSuccess()
        }
    }

    Scaffold(
        topBar = {
            PulseUpTopAppBar(
                title = stringResource(SignUpDestination.titleRes),
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
//            OutlinedTextField(
//                value = fullName,
//                onValueChange = { fullName = it },
//                label = { Text("Full Name") },
//                modifier = Modifier.fillMaxWidth()
//            )
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            OutlinedTextField(
//                value = username,
//                onValueChange = { username = it },
//                label = { Text("Username") },
//                modifier = Modifier.fillMaxWidth()
//            )
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            OutlinedTextField(
//                value = email,
//                onValueChange = { email = it },
//                label = { Text("Email") },
//                modifier = Modifier.fillMaxWidth()
//            )
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            OutlinedTextField(
//                value = dateOfBirth,
//                onValueChange = { dateOfBirth = it },
//                label = { Text("Birthday") },
//                modifier = Modifier.fillMaxWidth()
//            )
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            OutlinedTextField(
//                value = password,
//                onValueChange = { password = it },
//                label = { Text("Password") },
//                modifier = Modifier.fillMaxWidth()
//            )
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            OutlinedTextField(
//                value = confirmPassword,
//                onValueChange = { confirmPassword = it },
//                label = { Text("Confirm Password") },
//                modifier = Modifier.fillMaxWidth()
//            )
//
//            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = firstName,
                onValueChange = { firstName = it },
                label = { Text("First Name") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = lastName,
                onValueChange = { lastName = it },
                label = { Text("Last Name") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

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
                onClick = {viewModel.register(
                    firstName,
                    lastName,
                    username,
                    email,
                    password,
                    age.toInt(),
                    height.toFloat(),
                    weight.toFloat(),
                    dailyStepGoal.toInt(),
                    dailyCalorieGoal.toInt()
                )
                }) {
                Text("Sign Up")}

            Spacer(modifier = Modifier.height(16.dp))

            TextButton(
                onClick = onLogin,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Already have an account? Login")
            }

                Text(stringResource(R.string.complete))
            }
        }
    }
