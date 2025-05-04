package com.example.pulseup.ui.navigation


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
//import com.example.pulseup.UserViewModel
import com.example.pulseup.ui.activities.ActivitiesDestination
import com.example.pulseup.ui.home.HomeDestination
import com.example.pulseup.ui.profile.ProfileDestination
import com.example.pulseup.ui.record.RecordDestination
import com.example.pulseup.UserViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

/**
 * Resource: https://medium.com/@santosh_yadav321/bottom-navigation-bar-in-jetpack-compose-5b3c5f2cea9b
 */

@Composable
fun BottomNavigationBar(
    navController: NavController,
    userViewModel: UserViewModel = hiltViewModel(),
//    viewModel: UserViewModel
) {
//    val viewModel = UserViewModel = hiltViewModel()

    val selectedNavigationIndex = rememberSaveable {
        mutableIntStateOf(0)
    }

    val navigationItems = listOf(
        NavigationItem(
            title = "Home",
            icon = Icons.Default.Home,
            route = HomeDestination.route
        ),
        NavigationItem(
            title = "Record",
            icon = Icons.Default.AddCircle,
            route = RecordDestination.route
        ),
        NavigationItem(
            title = "Activities",
            icon = Icons.Default.DateRange,
            route = ActivitiesDestination.route
        ),
        NavigationItem(
            title = "Profile",
            icon = Icons.Default.Person,
            route = ProfileDestination.route
        )
    )

    NavigationBar(
        containerColor = Color.White
    ) {
        navigationItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedNavigationIndex.intValue == index,
                onClick = {
                    selectedNavigationIndex.intValue = index
//                    navController.navigate(item.route)
                    if (item.route == ProfileDestination.route) {
//                        val email = userViewModel.user.value?.email
                        val username = userViewModel.user.value?.username ?: ""
                        navController.navigate("profile/$username")
                    } else {
                        navController.navigate(item.route)
                    }
                },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = item.title)
                },
                label = {
                    Text(
                        item.title,
                        color = if (index == selectedNavigationIndex.intValue)
                            Color.Black
                        else Color.Gray
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.surface,
                    indicatorColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    }
}

data class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val route: String
)