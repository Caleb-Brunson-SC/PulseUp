package com.example.pulseup

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pulseup.ui.navigation.PulseUpNavHost
import com.example.pulseup.R.string
import com.example.pulseup.ui.activities.ActivitiesDestination
import com.example.pulseup.ui.goals.AddGoalDestination
import com.example.pulseup.ui.goals.GoalsDestination
import com.example.pulseup.ui.home.HomeDestination
import com.example.pulseup.ui.navigation.BottomNavigationBar
import com.example.pulseup.ui.profile.EditProfileDestination
import com.example.pulseup.ui.profile.ProfileDestination
import com.example.pulseup.ui.record.RecordDestination
import com.example.pulseup.ui.settings.SettingsDestination
import com.example.pulseup.ui.signin.SignInDestination
import com.example.pulseup.ui.signup.SignUpContiuedDestination
import com.example.pulseup.ui.signup.SignUpDestination
import com.example.pulseup.ui.welcome.WelcomeDestination

/**
 * Top level composable that represents screens for the application.
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PulseUpApp(navController: NavHostController = rememberNavController()) {
    var showBottomBar by rememberSaveable { mutableStateOf(true) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    showBottomBar = when (navBackStackEntry?.destination?.route) {
//        WelcomeDestination.route -> false // on this screen bottom bar should be hidden
//        SignInDestination.route -> false // here too
//        SignUpDestination.route -> false // also here
//        SignUpContiuedDestination.route -> false // also here
//        EditProfileDestination.route -> false
//        AddGoalDestination.route -> false
//        else -> true // in all other cases show bottom bar


        WelcomeDestination.route -> true // on this screen bottom bar should be hidden
        HomeDestination.route -> true // on this screen bottom bar should be shown
        ProfileDestination.route -> true // on this screen bottom bar should be shown
        RecordDestination.route -> true // on this screen bottom bar should be shown
        ActivitiesDestination.route -> true // on this screen bottom bar should be shown
        SettingsDestination.route -> true // on this screen bottom bar should be shown
        SignInDestination.route -> false // here too
        SignUpDestination.route -> false // also here
        else -> true // in all other cases show bottom bar
    }

    /* if (navBackStackEntry?.destination?.route == WelcomeDestination.route) {

    } */

    // Useful solution:
    // https://stackoverflow.com/questions/66837991/hide-top-and-bottom-navigator-on-a-specific-screen-inside-scaffold-jetpack-compo
    Scaffold(
        // Need to figure out how to hide this bottom bar for the Welcome, SignIn and SignUp Screens
        bottomBar = { if (showBottomBar) BottomNavigationBar(navController) },
        floatingActionButton = {
            when (navBackStackEntry?.destination?.route) {
                ProfileDestination.route -> {
                    // Edit profile floating action button
                    ExtendedFloatingActionButton(
                        onClick = { /* todo navigate to edit screen */
                            navController.navigate(EditProfileDestination.route)
                        },
                        icon = { Icon(Icons.Filled.Edit, "Edit profile FAB.") },
                        text = { Text(text = "Edit Profile") }
                    )
                }
                GoalsDestination.route -> {
                    // Edit goals floating action button
                    ExtendedFloatingActionButton(
                        onClick = { /* todo navigate to edit screen */
                            navController.navigate(AddGoalDestination.route)
                        },
                        icon = { Icon(Icons.Filled.Add, "Add goal FAB.") },
                        text = { Text(text = "Add Goal") }
                    )
                }
            }
        }
    ) {
        PulseUpNavHost(navController = navController)
    }
}



/**
 * Top app bar to display the title and conditionally display the back navigation.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PulseUpTopAppBar(
    title: String,
    showActionsIcon: Boolean,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigateUp: () -> Unit = {}
) {
    val openNotificationsDialog = remember { mutableStateOf(false) }

    CenterAlignedTopAppBar(
        title = { Text(title) },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(string.back_button)
                    )
                }
            }
        },
        actions = {
            if (showActionsIcon) {
                IconButton(onClick = {
                    openNotificationsDialog.value = !openNotificationsDialog.value
                }) {
                    Icon(
                        imageVector = Icons.Filled.Notifications,
                        contentDescription = "Notifications"
                    )
                }
                /*
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "Settings"
                    )
                }
                */
                when {
                    // [START_EXCLUDE]
                    openNotificationsDialog.value -> {
                        NotificationsDialog(
                            onDismissRequest = { openNotificationsDialog.value = false },
                        )
                    }
                }
            }
        },
    )
}

// Create notifications dialog?
@Composable
fun NotificationsDialog(onDismissRequest: () -> Unit) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Text(
                text = "This is a minimal dialog",
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                textAlign = TextAlign.Center,
            )
        }
    }
}


// Create settings dialog?
