package com.example.pulseup

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BadgeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBadge(badge: Badge)

    @Query("SELECT * FROM badges WHERE userId = :userId")
    suspend fun getBadgeByUser(userId: String): List<Badge>



}