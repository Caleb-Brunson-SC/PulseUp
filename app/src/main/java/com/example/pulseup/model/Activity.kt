package com.example.pulseup.model

import androidx.annotation.DrawableRes

/**
 * [Activity] is the data class to represent the Activity components.
 */
data class Activity(
    @DrawableRes val imageResourceId: Int,
    val imageDescription: String,
    val userFullName: String,
    val date: String,
    val location: String
)
