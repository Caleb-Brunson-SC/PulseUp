package com.example.pulseup

class UserRepository (
    private val userDao: UserDao,
    private val bodyStatsDao: BodyStatsDao

) {
    suspend fun getUserById(id: String): User? = userDao.getUser(id)
    suspend fun updateUser(user: User) = userDao.updateUser(user)
    suspend fun getUserByEmail(email: String): User? = userDao.getUserByEmail(email)
    suspend fun insertUser(user: User) = userDao.insertUser(user)

    suspend fun insertBodyStats(stats: BodyStats) = bodyStatsDao.insert(stats)
    suspend fun getBodyStatsForUser(userId: String) = bodyStatsDao.getStatsForUser(userId)


}