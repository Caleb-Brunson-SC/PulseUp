package com.example.pulseup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pulseup.model.Activity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.stateIn
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

    private val _loginSuccessful = MutableLiveData(false)
    val loginSuccessful: LiveData<Boolean> = _loginSuccessful

    val activities: StateFlow<List<Activity>> = userRepository.getActivities()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun getUserById(id: String) {
        viewModelScope.launch {
            _user.value = userRepository.getUserById(id)

        }
    }

    fun getUser(email: String): Flow<User?> {
        return userRepository.getUserByEmailFlow(email)
    }

    fun getUserByUsername(username: String) {
        viewModelScope.launch {
            _user.value = userRepository.getUserByUsername(username)
        }
    }

    fun loadUserByUsername(username: String) {
        viewModelScope.launch {
            val user = userRepository.getUserByUsername(username.trim())
            _user.value = user
        }
    }


    fun loadUserByEmail(email: String) {
        viewModelScope.launch {
            val user = userRepository.getUserByEmailSuspend(email.trim())
            _user.value = user
        }
    }

    fun updateUser(user: User) {
        viewModelScope.launch {
            userRepository.updateUser(user)

        }
    }

    fun login(username: String, password: String) {

        viewModelScope.launch {
            val user = userRepository.login(username, password)

            if (user != null) {
                _user.value = user
                _errorMessage.value = null
                _loginSuccessful.value = true
            } else {
                _user.value = null
                _errorMessage.value = "Invalid username or password"
                _loginSuccessful.value = false
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
//            if (existingEmailUser != null) {
//                _errorMessage.value = "Email already exists!"
//                return@launch

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


