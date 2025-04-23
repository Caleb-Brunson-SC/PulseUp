package com.example.pulseup

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.net.URL

@Entity(tableName = "body_stats")
class BodyStats (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val userId: String,
    val date: String,
    val weight: Float,
    val photoURL: String
)