package com.example.pulseup

import androidx.lifecycle.LiveData
import com.example.pulseup.model.Activity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao,
    private val activityDao: ActivityDao,
    private val bodyStatsDao: BodyStatsDao
) {
    suspend fun registerUser(user: User): Boolean {
        val existingUser = userDao.getUserByEmail(user.email).firstOrNull()
        if (existingUser != null) return false

        userDao.insertUser(user)
        return true
    }

    suspend fun login(username: String, password: String): User? {
        return userDao.login(username, password)
    }

    fun getActivities(): Flow<List<Activity>> = activityDao.getAllActivities()

    suspend fun insertActivity(activity: Activity) = activityDao.insertActivity(activity)

    suspend fun getUserById(id: String): User? = userDao.getUser(id)

    suspend fun updateUser(user: User) = userDao.updateUser(user)

    suspend fun getUserByEmail(email: String): Flow<User?> = userDao.getUserByEmail(email)

    fun getUserByUsernameFlow(username: String): Flow<User?> {
        return userDao.getUserByUsernameFlow(username)
    }

    // FIXED: Using direct suspend query instead of Flow.firstOrNull()
    suspend fun getUserByUsername(username: String): User? {
        return userDao.getUserByUsername(username)
    }

    suspend fun getUserByEmailSuspend(email: String): User? {
        return userDao.getUserByEmailSuspend(email)
    }

    // For observing as Flow
    fun getUserByEmailFlow(email: String): Flow<User?> {
        return userDao.getUserByEmail(email)
    }

    suspend fun insertBodyStats(stats: BodyStats) = bodyStatsDao.insert(stats)
    suspend fun getBodyStatsForUser(userId: String) = bodyStatsDao.getStatsForUser(userId)
}
