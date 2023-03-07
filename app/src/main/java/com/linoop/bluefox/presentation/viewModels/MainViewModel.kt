package com.linoop.bluefox.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.linoop.bluefox.business.UserModel
import com.linoop.bluefox.business.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {
    fun createUser(userModel: UserModel) = viewModelScope.launch(dispatcher) {
        userRepository.createUser(userModel)
    }
}