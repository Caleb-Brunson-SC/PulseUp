package com.example.pulseup.model

data class Goal(
    val title: String,
    val isRecurring: Boolean,
    val daySelection: String, // "" if none
    val dateSelection: String, // "" if none
    val activityType: String,
    val goalContent: String
)
