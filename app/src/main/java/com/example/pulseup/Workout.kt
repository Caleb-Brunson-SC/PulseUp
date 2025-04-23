package com.example.pulseup

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID
import kotlin.time.Duration

@Entity(tableName = "workouts")
data class Workout(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val type: WorkoutType,
    val duration: Int,
    val calories: Int
    )