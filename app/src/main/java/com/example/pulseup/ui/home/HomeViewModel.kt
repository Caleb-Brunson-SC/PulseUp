package com.example.pulseup.ui.home

import androidx.lifecycle.ViewModel
import com.example.pulseup.ActivityRepository
import com.example.pulseup.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val activityRepository: ActivityRepository,
    private val userRepository: UserRepository
) : ViewModel() {
    val activities = activityRepository.getAllActivities()

}
