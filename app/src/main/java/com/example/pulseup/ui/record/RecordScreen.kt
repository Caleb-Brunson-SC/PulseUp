package com.example.pulseup.ui.record

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.example.pulseup.PulseUpTopAppBar
import com.example.pulseup.R
import com.example.pulseup.ui.home.HomeDestination
import com.example.pulseup.ui.navigation.NavigationDestination

/**
 * Companion object for the Record's Navigation Destination.
 */
object RecordDestination : NavigationDestination {
    override val route = "record"
    override val titleRes = R.string.record
}

/**
 * Entry route for Record screen.
 * Title, Date, Location, Type (Run, Bike, Swim, Walk, Weight Training, Calisthenics, etc.)
 * Duration (hours, minutes, seconds dropdowns in a row?), Calories, Workout content, notes
 * https://www.geeksforgeeks.org/drop-down-menu-in-android-using-jetpack-compose/
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecordScreen(
    modifier: Modifier = Modifier
) {
    var title by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") } // Might remove idk

    // Activity dropdown selection
    // expanded state of the Text Field
    var expanded by remember { mutableStateOf(false) }
    // create a list of activity types
    val activityTypes = listOf("Run", "Walk", "Bike", "Swim", "Weight Training", "Calisthenics")
    // Create a string value to store the selected activity type
    var activityType by remember { mutableStateOf("") }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    // Other variables
    var duration by remember { mutableStateOf("") }
    var calories by remember { mutableStateOf("") }
    var workoutContent by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            PulseUpTopAppBar(
                title = stringResource(RecordDestination.titleRes),
                showActionsIcon = true,
                canNavigateBack = false
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
                value = title,
                onValueChange = { title = it },
                label = { Text("Title" )},
                modifier = Modifier.fillMaxWidth()
            )

            // Activity type dropdown selection menu
            // Up and down icons for expansion
            val icon = if (expanded)
                Icons.Filled.KeyboardArrowUp
            else
                Icons.Filled.KeyboardArrowDown

            Column(Modifier.padding(20.dp)) {
                // Text field with icon and not expanded
                OutlinedTextField(
                    value = activityType,
                    onValueChange = { activityType = it },
                    readOnly = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned { coordinates ->
                            // This value is to assign the DropDown the same width
                            textFieldSize = coordinates.size.toSize()
                        },
                    label = {Text("Activity Type")},
                    trailingIcon = {
                        Icon(icon, "type of activity",
                            Modifier.clickable { expanded = !expanded })
                    }
                )

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

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedButton(
                // maybe reduce width
                modifier = Modifier.fillMaxWidth(),
                onClick = { /* todo */ }
            ) {
                Text(stringResource(R.string.publish))
            }
        }
    }
}
