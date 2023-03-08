package com.linoop.bluefox.business

class ValidateNameUseCase {
    fun execute(name: String): ValidationResult {
        if (name.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "Name can't be blank"
            )
        }
        return ValidationResult(successful = true)
    }
}