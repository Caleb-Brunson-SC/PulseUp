package com.example.pulseup.ui.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
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
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.pulseup.UserViewModel


/**
 * Companion object for the Profile Screen's Navigation Destination.
 */
object ProfileDestination : NavigationDestination {
    override val route = "profile/{email}"
    const val emailArg = "email"
    override val titleRes = R.string.profile
}

/**
 * Entry route for Profile screen.
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    viewModel: UserViewModel,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier

) {

    Scaffold(
        topBar = {
            PulseUpTopAppBar(
                title = stringResource(ProfileDestination.titleRes),
                showActionsIcon = true,
                canNavigateBack = true,
                navigateUp = navigateBack
            )
        }
    ) {
        Column (
            modifier = Modifier
                .padding(start = 4.dp, top = 100.dp, end = 4.dp)
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
            Row {
                Text(
                    text = "This is giga chad's user profile description text segment."
                )
            }
        }

    }
}








