package com.example.pulseup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pulseup.PulseUpNavigation
import com.example.pulseup.UserViewModel
import com.example.pulseup.ui.theme.PulseUpTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            PulseUpTheme {
                val userViewModel: UserViewModel = hiltViewModel()
                PulseUpNavigation(userViewModel )
            }
        }
    }
}

