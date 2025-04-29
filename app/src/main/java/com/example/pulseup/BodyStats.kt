package com.example.pulseup

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.net.URL
import java.util.UUID

@Entity(tableName = "body_stats")
class BodyStats (
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val userId: String,
    val date: String,
    val weight: Float,
    val photoURL: String
)