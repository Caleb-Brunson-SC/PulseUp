package com.example.pulseup

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity(tableName = "badges")
class Badge (
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val userId: String,
    val title: String,
    val description: String,
    val imageUrl: String,
    val dateBadgeEarned: Date
    )