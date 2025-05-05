package com.example.pulseup.ui.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pulseup.PulseUpTopAppBar
import com.example.pulseup.R
import com.example.pulseup.ui.navigation.NavigationDestination
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


/**
 * Companion object for the Profile Screen's Navigation Destination.
 */
object ProfileDestination : NavigationDestination {
    override val route = "profile"
    override val titleRes = R.string.profile
}

/**
 * Entry route for Profile screen.
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            PulseUpTopAppBar(
                title = stringResource(ProfileDestination.titleRes),
                showActionsIcon = true,
                canNavigateBack = false
            )
        }
    ) {
        Column (
            modifier = Modifier
                .padding(start = 8.dp, top = 75.dp, end = 8.dp)
                .fillMaxSize()
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                // user profile image
                Image(
                    painter = painterResource(R.drawable.gigachad),
                    contentDescription = "giga chad",
                    modifier = Modifier
                        .size(75.dp)
                        .clip(CircleShape)
                )
                // user name
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Giga Chad",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            }
            Spacer(Modifier.height(10.dp))
            Row {
                Text(
                    text = "This is giga chad's user profile description text segment."
                )
            }
            Spacer(Modifier.height(10.dp))
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Following"
                    )
                    Text(
                        text = "64",
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(Modifier.width(20.dp))
                Column {
                    Text(
                        text = "Followers"
                    )
                    Text(
                        text = "66",
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(Modifier.width(20.dp))
                OutlinedButton(
                    onClick = {}
                ) {
                    Text(
                        text = "Edit"
                    )
                }
            }

            // something new here
            Text(
                text = "Personal Data",
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Age: "
            )
            Text(
                text = "Height: "
            )
            Text(
                text = "Weight: "
            )
            Text(
                text = "Daily Step Goal: "
            )
            Text(
                text = "Daily Calorie Goal: "
            )
        }
    }
}