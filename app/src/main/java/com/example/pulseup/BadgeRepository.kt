package com.example.pulseup

import javax.inject.Inject

class BadgeRepository @Inject constructor(
    private val badgeDao: BadgeDao
) {
    suspend fun insertBadge(badge: Badge) = badgeDao.insertBadge(badge)
    suspend fun getBadgesForUser(userId: String) = badgeDao.getBadgeByUser(userId)

}