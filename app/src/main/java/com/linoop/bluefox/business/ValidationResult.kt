package com.linoop.bluefox.business

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String? = null
)
