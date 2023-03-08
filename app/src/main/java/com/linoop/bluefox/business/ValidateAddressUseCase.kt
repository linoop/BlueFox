package com.linoop.bluefox.business

class ValidateAddressUseCase {
    fun execute(address: String): ValidationResult {
        if (address.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "The Address can't be blank"
            )
        }
        return ValidationResult(successful = true)
    }
}