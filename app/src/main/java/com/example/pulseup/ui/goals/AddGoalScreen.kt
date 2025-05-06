package com.example.pulseup.ui.goals

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.example.pulseup.PulseUpTopAppBar
import com.example.pulseup.R
import com.example.pulseup.ui.navigation.NavigationDestination
import com.example.pulseup.ui.profile.EditProfileDestination
import com.example.pulseup.ui.record.DatePickerFieldToModal
import com.example.pulseup.ui.record.convertMillisToDate
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Companion object for the Add Goal Screen's Navigation Destination.
 */
object AddGoalDestination : NavigationDestination {
    override val route = "add_goal"
    override val titleRes = R.string.add_goal
}

/**
 * Entry route for Add Goal screen.
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddGoalScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    var title by remember { mutableStateOf("") }

    var checked by remember { mutableStateOf(false) }

    // recurring dropdown selection
    // expanded state of the Text Field
    var recurringExpanded by remember { mutableStateOf(false) }
    // create a list of activity types
    val days = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    // Create a string value to store the selected activity type
    var daySelection by remember { mutableStateOf("") }
    var recurringTextFieldSize by remember { mutableStateOf(Size.Zero) }

    // Date picker
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    val selectedDate = datePickerState.selectedDateMillis?.let {
        convertMillisToDate(it)
    } ?: ""

    // Activity dropdown selection
    // expanded state of the Text Field
    var activityExpanded by remember { mutableStateOf(false) }
    // create a list of activity types
    val activityTypes = listOf("Run", "Walk", "Bike", "Swim", "Weight Training", "Calisthenics")
    // Create a string value to store the selected activity type
    var activitySelection by remember { mutableStateOf("") }
    var activityTextFieldSize by remember { mutableStateOf(Size.Zero) }

    // Goal content
    var goalContent by remember { mutableStateOf("")}

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
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Title") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    "Is Recurring?"
                )
                Checkbox(
                    checked = checked,
                    onCheckedChange = { checked = it }
                )
            }

            if (checked) {
                // Activity type dropdown selection menu
                // Up and down icons for expansion
                val icon = if (recurringExpanded)
                    Icons.Filled.KeyboardArrowUp
                else
                    Icons.Filled.KeyboardArrowDown

                Column {
                    // Text field with icon and not expanded
                    OutlinedTextField(
                        value = daySelection,
                        onValueChange = { daySelection = it },
                        readOnly = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .onGloballyPositioned { coordinates ->
                                // This value is to assign the DropDown the same width
                                recurringTextFieldSize = coordinates.size.toSize()
                            },
                        label = {Text("Day")},
                        trailingIcon = {
                            Icon(icon, "day to repeat on",
                                Modifier.clickable { recurringExpanded = !recurringExpanded })
                        }
                    )

                    // Create a drop-down menu with list of activity types
                    // When clicked, set the Text Field text as the city selected
                    DropdownMenu(
                        expanded = recurringExpanded,
                        onDismissRequest = { recurringExpanded = false },
                        modifier = Modifier
                            .width(with(LocalDensity.current){recurringTextFieldSize.width.toDp()})
                    ) {
                        days.forEach { label ->
                            DropdownMenuItem(
                                onClick = {
                                    daySelection = label
                                    recurringExpanded = false
                                },
                                text = { Text(text = label) }
                            )
                        }
                    }
                }
                if (daySelection != "") {
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        "Goal repeats every ${daySelection}."
                    )
                }
            } else {
                // Date picker
                DatePickerFieldToModal()
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Activity type dropdown selection menu
            // Up and down icons for expansion
            val icon = if (activityExpanded)
                Icons.Filled.KeyboardArrowUp
            else
                Icons.Filled.KeyboardArrowDown

            Column {
                // Text field with icon and not expanded
                OutlinedTextField(
                    value = activitySelection,
                    onValueChange = { activitySelection = it },
                    readOnly = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned { coordinates ->
                            // This value is to assign the DropDown the same width
                            activityTextFieldSize = coordinates.size.toSize()
                        },
                    label = {Text("Activity Type")},
                    trailingIcon = {
                        Icon(icon, "type of activity",
                            Modifier.clickable { activityExpanded = !activityExpanded })
                    }
                )

                // Create a drop-down menu with list of activity types
                // When clicked, set the Text Field text as the city selected
                DropdownMenu(
                    expanded = activityExpanded,
                    onDismissRequest = { activityExpanded = false },
                    modifier = Modifier
                        .width(with(LocalDensity.current){activityTextFieldSize.width.toDp()})
                ) {
                    activityTypes.forEach { label ->
                        DropdownMenuItem(
                            onClick = {
                                activitySelection = label
                                activityExpanded = false
                            },
                            text = { Text(text = label) }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = goalContent,
                onValueChange = { goalContent = it },
                label = { Text("Goal Content") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedButton(
                // maybe reduce width
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    /* todo */
                }
            ) {
                Text(stringResource(R.string.publish_goal))
            }
        }
    }
}

@Composable
fun DatePickerFieldToModal(modifier: Modifier = Modifier) {
    var selectedDate by remember { mutableStateOf<Long?>(null) }
    var showModal by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = selectedDate?.let { convertMillisToDate(it) } ?: "",
        onValueChange = { },
        label = { Text("Date") },
        placeholder = { Text("MM/DD/YYYY") },
        trailingIcon = {
            Icon(Icons.Default.DateRange, contentDescription = "Select date")
        },
        modifier = modifier
            .fillMaxWidth()
            .pointerInput(selectedDate) {
                awaitEachGesture {
                    // Modifier.clickable doesn't work for text fields, so we use Modifier.pointerInput
                    // in the Initial pass to observe events before the text field consumes them
                    // in the Main pass.
                    awaitFirstDown(pass = PointerEventPass.Initial)
                    val upEvent = waitForUpOrCancellation(pass = PointerEventPass.Initial)
                    if (upEvent != null) {
                        showModal = true
                    }
                }
            }
    )

    if (showModal) {
        DatePickerModal(
            onDateSelected = { selectedDate = it },
            onDismiss = { showModal = false }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerModal(
    onDateSelected: (Long?) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState()

    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = {
                onDateSelected(datePickerState.selectedDateMillis)
                onDismiss()
            }) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    ) {
        DatePicker(state = datePickerState)
    }
}

fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}