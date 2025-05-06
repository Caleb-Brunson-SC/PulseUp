package com.example.pulseup.ui.goals

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pulseup.PulseUpTopAppBar
import com.example.pulseup.R
import com.example.pulseup.ui.navigation.NavigationDestination
import com.example.pulseup.ui.profile.EditProfileDestination

/**
 * Companion object for the Add Goal Screen's Navigation Destination.
 */
object AddGoalDestination : NavigationDestination {
    override val route = "add_goal"
    override val titleRes = R.string.add_goal
}

/**
 * Entry route for Add Goal screen.
 * Title
 * Recurring: Yes or No
 * Activity Type: dropdown
 * Goal contents:
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddGoalScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    var title by remember { mutableStateOf("") }

    // Activity dropdown selection
    // expanded state of the Text Field
    var expanded by remember { mutableStateOf(false) }
    // create a list of activity types
    val activityTypes = listOf("Run", "Walk", "Bike", "Swim", "Weight Training", "Calisthenics")
    // Create a string value to store the selected activity type
    var activityType by remember { mutableStateOf("") }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    Scaffold(
        topBar = {
            PulseUpTopAppBar(
                title = stringResource(AddGoalDestination.titleRes),
                showActionsIcon = false,
                canNavigateBack = true,
                navigateUp = navigateBack
            )
        }
    ) {
        Column (
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Full Name") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Create a drop-down menu with list of activity types
            // When clicked, set the Text Field text as the city selected
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .width(with(LocalDensity.current){textFieldSize.width.toDp()})
            ) {
                activityTypes.forEach { label ->
                    DropdownMenuItem(
                        onClick = {
                            activityType = label
                            expanded = false
                        },
                        text = { Text(text = label) }
                    )
                }
            }
        }
    }
}