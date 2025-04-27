package com.example.pulseup.ui.record

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecordScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            PulseUpTopAppBar(
                title = stringResource(RecordDestination.titleRes),
                showProfileIcon = true,
                canNavigateBack = false
            )
        }
    ) {

    }
}