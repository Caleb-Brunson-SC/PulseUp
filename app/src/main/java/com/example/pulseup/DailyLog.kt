package com.example.pulseup

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "daily_logs")
data class DailyLog (
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val date: String,
    val userName: String,
    val steps: Int,
    val calories: Int,
    val description: String,
    val workoutMinutes: Int

)