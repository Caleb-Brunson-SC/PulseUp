package com.example.pulseup.ui.goals

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.pulseup.PulseUpTopAppBar
import com.example.pulseup.R
import com.example.pulseup.data.Datasource
import com.example.pulseup.model.Goal
import com.example.pulseup.ui.navigation.NavigationDestination

/**
 * Companion object for the Goal Screen's Navigation Destination.
 */
object GoalsDestination: NavigationDestination {
    override val route = "goals"
    override val titleRes = R.string.goals
}

/**
 * Entry route for Goals screen.
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoalsScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            PulseUpTopAppBar(
                title = stringResource(GoalsDestination.titleRes),
                showActionsIcon = true,
                canNavigateBack = false
            )
        }
    ) {
        GoalList(
            goalList = Datasource().loadGoals()
        )
    }
}

@Composable
fun GoalList(goalList: List<Goal>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = Modifier
            .padding(start = 4.dp, top = 100.dp, end = 4.dp, bottom = 100.dp)
            .fillMaxSize()
    ) {
        items(goalList) { goal ->
            GoalCard(
                goal = goal,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun GoalCard(goal: Goal, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        ) {
            Text(
                text = goal.title,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row {
                Text(
                    text = "Date: ",
                    fontWeight = FontWeight.Bold
                )

                if (goal.isRecurring) {
                    Text(
                        text = "Every ${goal.daySelection}"
                    )
                } else {
                    Text(
                        text = goal.dateSelection
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row {
                Text(
                    text = "Type: ",
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = goal.activityType
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row {
                Text(
                    text = "Goal: ",
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = goal.goalContent
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                OutlinedButton(
                    onClick = {  }
                ) {
                    Icon(Icons.Filled.Check, "Complete")
                    Text("Complete")
                }

                OutlinedButton(
                    onClick = {  }
                ) {
                    Icon(Icons.Filled.Edit, "Edit activity")
                    Text("Edit")
                }

                OutlinedButton(
                    onClick = {  }
                ) {
                    Icon(Icons.Filled.Delete, "Remove activity")
                    Text("Remove")
                }
            }
        }
    }
}