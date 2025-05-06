package com.example.pulseup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.pulseup.UserViewModel
import com.example.pulseup.ui.home.HomeScreen
import com.example.pulseup.ui.navigation.BottomNavigationBar

//@Composable
//fun DashboardScreen(
//    userViewModel: UserViewModel = hiltViewModel(),
//
//
//) {
//
//
//
//    Column(
//        modifier = Modifier.padding(16.dp)
//    ) {
//        Text("Dashboard", style = MaterialTheme.typography.headlineMedium)
//    }
//
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Text(
//                text = "Dashboard",
//                style = MaterialTheme.typography.headlineMedium
////                text = "Welcome,User"",
////                style = MaterialTheme.typography.headlineMedium
//            )
//
//            Button(onClick = {
//                // Implement logout functionality when ready
//            }) {
//                Text("Logout")
//            }
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
////        Card(
////            modifier = Modifier.fillMaxWidth()
////        ) {
////            Column(modifier = Modifier.padding(16.dp)) {
////                Text("Your Fitness Goals", style = MaterialTheme.typography.titleLarge)
////                Spacer(modifier = Modifier.height(8.dp))
////                Text("Daily Step Goal: ${user?.dailyStepGoal ?: 0}")
////                Text("Daily Calorie Goal: ${user?.dailyCalorieGoal ?: 0}")
////            }
////        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Placeholder for future dashboard content
//        Text("Your fitness journey starts here!", style = MaterialTheme.typography.bodyLarge)
//    }
//}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    navController: NavHostController,
    userViewModel: UserViewModel = hiltViewModel(),
) {
    val currentDestination = navController.currentBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            PulseUpTopAppBar(
                title = stringResource(R.string.home),
                showActionsIcon = true,
                canNavigateBack = false
            )
        },
        bottomBar = {
            BottomNavigationBar(

                navController = navController,
//                viewModel = userViewModel,
//                currentDestination = currentDestination
            )
        }
    ) { innerPadding ->
        HomeScreen(
            modifier = Modifier.padding(innerPadding),
            userViewModel = userViewModel
        )
    }
}
