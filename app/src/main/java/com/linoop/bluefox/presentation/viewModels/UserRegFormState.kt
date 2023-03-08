package com.linoop.bluefox.presentation.viewModels

data class UserRegFormState(
    val name: String = "",
    var nameError: String? = null,
    val email: String = "",
    var emailError: String? = null,
    val address: String = "",
    var addressError: String? = null,
    val password: String = "",
    var passwordError: String? = null,
    val confirmPassword: String = "",
    var confirmPasswordError: String? = null,
)
