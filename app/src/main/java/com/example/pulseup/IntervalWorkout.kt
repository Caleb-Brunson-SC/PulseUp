package com.example.pulseup

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "intervals")
data class IntervalWorkout (
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val workoutId: String,
    val sets: Int,
    val reps: Int,
    val restTime: Int,

    )