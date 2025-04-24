package com.example.pulseup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BadgeViewModel @Inject constructor(
    private val badgeRepository: BadgeRepository
) : ViewModel() {
    private val _badges = MutableLiveData<List<Badge>>()
    val badges: LiveData<List<Badge>> = _badges

    fun loadBadgesForUser(userId: String) {
        viewModelScope.launch {
            _badges.value = badgeRepository.getBadgesForUser(userId)
        }
    }

    fun insertBadge(badge: Badge) {
        viewModelScope.launch {
            badgeRepository.insertBadge(badge)
        }
    }
}
