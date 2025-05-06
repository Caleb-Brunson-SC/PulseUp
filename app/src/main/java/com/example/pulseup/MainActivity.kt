package com.example.pulseup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pulseup.ui.theme.PulseUpTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PulseUpTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                ) {
//                    PulseUpApp()
//                }

                val userViewModel: UserViewModel = hiltViewModel()
                PulseUpNavigation(userViewModel )
            }
        }
    }
}

/**
 * Thinking about having the Home screen be just a premade list of random user's ("followings")
 * activities. Then, have the Activities screen use a functional Room database.
 */