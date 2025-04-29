package com.example.pulseup.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * [Activity] is the data class to represent the Activity components.
 */
data class Activity(
    @DrawableRes val imageResourceId: Int,
    val imageDescription: String,
    val userFullName: String,
    val date: String,
    val title: String,
    val type: String, // could be made an enumeration later
    val duration: String,
    val caloriesBurned: String,
    val workout: String,
    val notes: String
)
