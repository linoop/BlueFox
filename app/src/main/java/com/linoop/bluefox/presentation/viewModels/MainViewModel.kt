package com.linoop.bluefox.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.linoop.bluefox.business.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val validateNameUseCase: ValidateNameUseCase,
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val validateAddress: ValidateAddressUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
    private val validateConfirmPswUseCase: ValidateConfirmPswUseCase
) : ViewModel() {

    private val _userDataValidation = MutableLiveData<UserRegFormState>()
    val userDataValidation: LiveData<UserRegFormState> get() = _userDataValidation

    fun createUser(userRegFormState: UserRegFormState) {
        val nameResult = validateNameUseCase.execute(userRegFormState.name)
        val emailResult = validateEmailUseCase.execute(userRegFormState.email)
        val addressResult = validateAddress.execute(userRegFormState.address)
        val passwordResult = validatePasswordUseCase.execute(userRegFormState.password)
        val confirmPswResult =
            validateConfirmPswUseCase.execute(userRegFormState.password, userRegFormState.confirmPassword)
        val hasError = listOf(
            nameResult,
            emailResult,
            addressResult,
            passwordResult,
            confirmPswResult
        ).any { !it.successful }
        if(hasError){
            userRegFormState.nameError = nameResult.errorMessage
            userRegFormState.emailError = emailResult.errorMessage
            userRegFormState.addressError = addressResult.errorMessage
            userRegFormState.passwordError = passwordResult.errorMessage
            userRegFormState.confirmPasswordError = confirmPswResult.errorMessage
        }
        _userDataValidation.value = userRegFormState
        viewModelScope.launch {
            //userRepository.createUser()
        }
    }
}