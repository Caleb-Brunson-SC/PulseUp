package com.example.pulseup

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
        @Provides
        @Singleton
        fun provideDatabase(@ApplicationContext context: Context): PulseUpDatabase {
            return Room.databaseBuilder(
                context,
                PulseUpDatabase::class.java,
                "pulseUp_database"
            ).build()
        }


    @Provides
    fun provideUserDao(db: PulseUpDatabase): UserDao = db.userDao()

    @Provides
    fun provideWorkoutDao(db: PulseUpDatabase): WorkoutDao = db.workoutDao()

    @Provides
    fun provideBadgeDao(db: PulseUpDatabase): BadgeDao = db.badgeDao()

    @Provides
    fun provideBodyStatsDao(db: PulseUpDatabase): BodyStatsDao = db.bodyStatsDao()


}