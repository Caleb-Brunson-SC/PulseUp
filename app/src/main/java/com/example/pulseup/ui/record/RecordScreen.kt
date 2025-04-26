package com.example.pulseup.ui.record

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pulseup.R
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
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecordScreen(
    modifier: Modifier = Modifier
) {

}