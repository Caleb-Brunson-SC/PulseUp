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
    private val _user = MutableLiveData<User?>()
    val user: LiveData<User?> = _user

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

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
            val user = userRepository.getUserByUsername(username)
            if (user != null && user.password == password)  {
                _user.value = user
            } else {
                _user.value = null
                _errorMessage.value = "Invalid username or password"
            }


        }

    }


    fun register(
        firstName: String,
        lastName: String,
        username: String,
        email: String,
        password: String,
        age: Int,
        height: Float,
        weight: Float,
        dailyStepGoal: Int,
        dailyCalorieGoal: Int
    ) {
        viewModelScope.launch {
            val existingEmailUser = userRepository.getUserByEmail(email)
            if (existingEmailUser != null) {
                _errorMessage.value = "Email already exists!"
                return@launch
            }
            val existingUsernameUser = userRepository.getUserByUsername(username)
            if (existingUsernameUser != null) {
                _errorMessage.value = "Username already exists!"
                return@launch
            }
            val newUser = User(
                firstName = firstName,
                lastName = lastName,
                username = username,
                email = email,
                password = password,
                age = age,
                weight = weight,
                height = height,
                dailyStepGoal = dailyStepGoal,
                dailyCalorieGoal = dailyCalorieGoal

            )


            val success = userRepository.registerUser(newUser)
            _errorMessage.value = if (success) null else "User already exists!"
        }
    }
}



