package com.example.pulseup

class WorkoutRepository(
    private val workoutDao: WorkoutDao
) {
    suspend fun saveWorkout(workout: Workout) = workoutDao.insertWorkout(workout)
    suspend fun getWorkouts(): List<Workout> = workoutDao.getAllWorkouts()
}