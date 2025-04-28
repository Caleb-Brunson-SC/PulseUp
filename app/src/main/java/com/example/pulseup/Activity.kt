package com.example.pulseup

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity(tableName = "activities")
data class Activity(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val userId: String,
    val activityType: String,
    val duration: Long,
    val distance: Float,
    val caloriesBurned: Int,
    val date: Date

    )