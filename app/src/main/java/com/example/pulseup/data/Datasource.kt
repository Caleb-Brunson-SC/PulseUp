package com.example.pulseup.data

import com.example.pulseup.R
import com.example.pulseup.model.Activity
import com.example.pulseup.model.User

/**
 * [Datasource] generates a list of [Activity]
 * https://github.com/google-developer-training/basic-android-kotlin-compose-training-affirmations/
 */
class Datasource {
    fun loadActivities() : List<Activity> {
        return listOf<Activity>(
            Activity(R.drawable.gigachad, "gigachad", "Giga Chad",
                "April 26, 2025", "Jog Through Downtown", "Run",
                "40 minutes", "500", "5 miles at 8:00 min/mi pace",
                "Felt really good! Weather was nice.")
        )
    }

    fun loadOtherUsersActivities() : List<Activity> {
        return listOf<Activity>(
            Activity(R.drawable.david_gandy, "david", "David Gandy",
                "April 28, 2025", "Easy Swim", "Swim",
                "30 minutes", "1000", "100m repetitions",
                "Hard but water felt nice."),
            Activity(R.drawable.gigachad, "gigachad", "Giga Chad",
                "April 26, 2025", "Jog Through Downtown", "Run",
                "40 minutes", "500", "5 miles at 8:00 min/mi pace",
                "Felt really good! Weather was nice."),
            Activity(R.drawable.chico, "chico", "Chico Lachowski",
                "April 24, 2025", "Tempo Run", "Run", "40 minutes",
                "400", "40 minutes at 5-6 RPE out of 10",
                "Comfortably hard. Tough dirt road.")
        )
    }

    fun loadUser() : User {
        return User(
            R.drawable.gigachad, "gigachad", "Giga Chad", "gigachad",
            "giga.chad@gmail.com", "24", "12345", "6'5", "205",
            "10,000", "5,000", "66", "64"
        )
    }
}