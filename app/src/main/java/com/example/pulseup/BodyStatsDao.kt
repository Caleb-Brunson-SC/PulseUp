package com.example.pulseup

import androidx.room.Entity
import androidx.room.Insert
import androidx.room.Query

@Entity
interface BodyStatsDao {
    @Insert
    suspend fun insert(stats: BodyStats)

    @Query("SELECT * FROM body_stats WHERE userId = :userId")
    suspend fun getStatsForUser(userId: String): List<BodyStats>
}
