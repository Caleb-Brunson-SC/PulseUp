package com.example.pulseup

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
//import com.example.pulseup.data.Activity
import com.example.pulseup.ActivityDao
import com.example.pulseup.Badge
import com.example.pulseup.BadgeDao
import com.example.pulseup.model.Activity


@Database(
    entities = [User::class, Workout::class, BodyStats::class, Badge::class, Activity::class],
    version = 2,
)

abstract class PulseUpDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun workoutDao(): WorkoutDao
    abstract fun activityDao(): ActivityDao
    abstract fun badgeDao(): BadgeDao
    abstract fun bodyStatsDao(): BodyStatsDao


}