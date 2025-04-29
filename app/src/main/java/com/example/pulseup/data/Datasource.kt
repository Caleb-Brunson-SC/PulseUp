package com.example.pulseup.data

import com.example.pulseup.R
import com.example.pulseup.model.Activity

/**
 * [Datasource] generates a list of [Activity]
 * https://github.com/google-developer-training/basic-android-kotlin-compose-training-affirmations/
 */
class Datasource {
    fun loadActivities() : List<Activity> {
        return listOf<Activity>(
            Activity(R.drawable.gigachad, "gigachad", "Giga Chad",
                "April 28, 2025", "Jog Through Downtown", "Run",
                "1:04 hrs", "500", "5 miles at 8:00 min/mi pace",
                "Felt really good! Weather was nice.")
        )
    }
}