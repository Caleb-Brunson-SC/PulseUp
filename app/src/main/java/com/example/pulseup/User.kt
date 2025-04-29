package com.example.pulseup;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = "users")
data class User(
        @PrimaryKey val id: String = UUID.randomUUID().toString(),
        val firstName: String,
        val lastName: String,
        val username: String,
        val email: String,
        val password: String,
        val age: Int,
        val weight: Float,
        val height: Float,
        val dailyStepGoal: Int,
        val dailyCalorieGoal: Int
)