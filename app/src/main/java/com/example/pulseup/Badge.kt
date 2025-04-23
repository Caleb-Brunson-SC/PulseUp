package com.example.pulseup

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "badges")
class Badge (
    @PrimaryKey val id: String,
    val title: String,
    val description: String,
    val imageUrl: String,
    )