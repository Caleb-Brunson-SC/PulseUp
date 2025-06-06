package com.example.pulseup.ui.activities

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pulseup.PulseUpTopAppBar
import com.example.pulseup.R
import com.example.pulseup.data.Datasource
import com.example.pulseup.model.Activity
import com.example.pulseup.ui.home.HomeDestination
import com.example.pulseup.ui.navigation.NavigationDestination
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight


/**
 * Companion object for the Activities Navigation Destination.
 */
object ActivitiesDestination : NavigationDestination {
    override val route = "activities"
    override val titleRes = R.string.activities
}

/**
 * Entry route for Activities screen.
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivitiesScreen(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit,
) {
    Scaffold(
        topBar = {
            PulseUpTopAppBar(
                title = stringResource(ActivitiesDestination.titleRes),
                showActionsIcon = true,
                canNavigateBack = true,
                navigateUp = navigateBack
            )
        }
    ) {
        ActivityList(
            activityList = Datasource().loadActivities(),
        )
    }
}

@Composable
fun ActivityList(activityList: List<Activity>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = Modifier
            .padding(start = 4.dp, top = 100.dp, end = 4.dp)
            .fillMaxSize()
    ) {
        items(activityList) { activity ->
            ActivityCard(
                activity = activity,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun ActivityCard(activity: Activity, modifier: Modifier = Modifier) {
    // column with rows inside of a card
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
    ) {
        Column {
            Row {
                // user profile image
                Image(
                    painter = painterResource(activity.imageResourceId),
                    contentDescription = activity.imageDescription,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                )
                // user name
                Spacer(modifier = Modifier.width(6.dp))
                Column {
                    Text(
                        text = activity.userFullName,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = activity.date
                    )
                }

            }
            Spacer(modifier = Modifier.height(2.dp))
            // Activity title
            Text (
                text = activity.title,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            // Row with Type, Duration, and Calories
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column {
                    Text(
                        text = "Type:",
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = activity.type
                    )
                }
                Column {
                    Text(
                        text = "Duration:",
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = activity.duration
                    )
                }
                Column {
                    Text(
                        text = "Calories:",
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = activity.caloriesBurned
                    )
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            // Activity Content
            Text(
                text = "Workout:",
                fontWeight = FontWeight.Bold
            )
            Text(
                text = activity.workout
            )
            Spacer(modifier = Modifier.height(2.dp))
            // Activity description
            Text(
                text = "Notes:",
                fontWeight = FontWeight.Bold
            )
            Text(
                text = activity.notes
            )
            // optional image??
        }
    }
}