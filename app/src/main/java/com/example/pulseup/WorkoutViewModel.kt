package com.example.pulseup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkoutViewModel @Inject constructor(
    private val workoutRepository: WorkoutRepository

): ViewModel() {
    private val _workouts = MutableLiveData<List<Workout>>()
    val workouts: LiveData<List<Workout>> = _workouts

    fun loadWorkouts() {
        viewModelScope.launch {
            _workouts.value = workoutRepository.getWorkouts()
        }

    }

    fun saveWorkout(workout: Workout) {
        viewModelScope.launch {
            workoutRepository.saveWorkout(workout)
        }
    }


}