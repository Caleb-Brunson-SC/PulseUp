package com.example.pulseup.model

import androidx.annotation.DrawableRes

/**
 * [User] is the data class to represent the User components.
 */
data class User(
    @DrawableRes val imageResourceId: Int,
    val imageDescription: String,
    val fullName: String,
    val username: String,
    val email: String,
    val age: String,
    val password: String,
    val height: String,
    val weight: String,
    val dailyStepGoal: String,
    val dailyCalorieGoal: String,
    val following: String,
    val followers: String
)
