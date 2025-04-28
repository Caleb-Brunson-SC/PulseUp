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
                "April 28, 2025", "Columbia, South Carolina")
        )
    }
}