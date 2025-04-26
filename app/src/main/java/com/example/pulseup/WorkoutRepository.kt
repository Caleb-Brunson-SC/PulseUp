package com.example.pulseup

import javax.inject.Inject

class WorkoutRepository @Inject constructor(
    private val workoutDao: WorkoutDao
) {
    suspend fun saveWorkout(workout: Workout) = workoutDao.insertWorkout(workout)
    suspend fun getWorkouts(): List<Workout> = workoutDao.getAllWorkouts()
}