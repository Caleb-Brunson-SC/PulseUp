package com.example.pulseup

class BadgeRepository (
    private val badgeDao: BadgeDao
) {
    suspend fun insertBadge(badge: Badge) = badgeDao.insertBadge(badge)
    suspend fun getBadgesForUser(userId: String) = badgeDao.getBadgeByUser(userId)

}