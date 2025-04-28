package com.example.pulseup.data

import com.example.pulseup.model.Activity

/**
 * [Datasource] generates a list of [Activity]
 * https://github.com/google-developer-training/basic-android-kotlin-compose-training-affirmations/
 */
class Datasource {
    fun loadActivities() : List<Activity> {
        return listOf<Activity>(
            Activity()
        )
    }
}