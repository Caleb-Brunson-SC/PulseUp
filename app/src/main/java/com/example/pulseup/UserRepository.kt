package com.example.pulseup

import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao,
    private val bodyStatsDao: BodyStatsDao

) {
    suspend fun registerUser(user: User): Boolean {
        val existingUser = userDao.getUserByEmail(user.email)
        return if (existingUser == null) {
            userDao.insertUser(user)
            true
        } else {
            false
        }
    }

    suspend fun login(username: String, password: String): User? {
        return userDao.login(username, password)
    }

    suspend fun getUserById(id: String): User? = userDao.getUser(id)
    suspend fun updateUser(user: User) = userDao.updateUser(user)
    suspend fun getUserByEmail(email: String): User? = userDao.getUserByEmail(email)
    suspend fun getUserByUsername(username: String): User? = userDao.getUserByUsername(username)


    suspend fun insertBodyStats(stats: BodyStats) = bodyStatsDao.insert(stats)
    suspend fun getBodyStatsForUser(userId: String) = bodyStatsDao.getStatsForUser(userId)



}