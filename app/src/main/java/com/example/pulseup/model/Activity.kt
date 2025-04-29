package com.example.pulseup.model

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

/**
 * [Activity] is the data class to represent the Activity components.
 */
@Entity(tableName = "activities")
data class Activity(
    @DrawableRes val imageResourceId: Int,
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val userId: String,
    val imageDescription: String,
    val userFullName: String,
    val date: String,
    val location: String,
    val title: String,
    val type: String, // could be made an enumeration later
    val duration: String,
    val caloriesBurned: String,
    val workout: String,
    val notes: String
)



