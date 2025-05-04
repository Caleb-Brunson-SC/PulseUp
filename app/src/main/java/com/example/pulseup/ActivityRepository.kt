package com.example.pulseup

import com.example.pulseup.model.Activity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ActivityRepository @Inject constructor (
    private val activityDao: ActivityDao,
    private val userDao: UserDao

) {
    suspend fun insertActivity(activity: Activity) {
        activityDao.insertActivity(activity)
    }
    fun getAllActivities(): Flow<List<Activity>> = activityDao.getAllActivities()

    suspend fun getActivitiesByUser(userId: String): List<Activity> {
        return activityDao.getActivitiesByUser(userId)
    }

    suspend fun getActivityById(activityId: String): Activity? {
        return activityDao.getActivityById(activityId)
    }

    suspend fun deleteActivity(activityId: String) {
        activityDao.deleteActivity(activityId)

    }
}