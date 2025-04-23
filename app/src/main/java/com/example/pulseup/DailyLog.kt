package com.example.pulseup

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "daily_logs")
data class DailyLog (
    @PrimaryKey val date: String,
    val userName: String,
    val steps: Int,
    val calories: Int,
    val description: String

)