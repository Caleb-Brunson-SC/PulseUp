package com.example.pulseup

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [User::class, Workout::class, BodyStats::class, Badge::class],
    version = 2,
)

abstract class PulseUpDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun workoutDao(): WorkoutDao
    abstract fun badgeDao(): BadgeDao
    abstract fun bodyStatsDao(): BodyStatsDao


}