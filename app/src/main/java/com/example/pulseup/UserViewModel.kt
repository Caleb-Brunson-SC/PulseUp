package com.example.pulseup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    fun getUserById(id: String) {
        viewModelScope.launch {
            _user.value = userRepository.getUserById(id)

        }
    }

    fun updateUser(user: User) {
        viewModelScope.launch {
            userRepository.updateUser(user)
        }
    }

    fun login(username: String, password: String) {
        viewModelScope.launch {
            val user = userRepository.getUserByEmail(username)
            if (user != null && user.password == password) {
                _user.value = user
            } else {
                _user.value = null
            }
            }
        }
}



