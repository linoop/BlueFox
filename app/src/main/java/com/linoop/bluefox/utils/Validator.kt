package com.linoop.bluefox.utils

object Validator {

    fun validateField(value: String): Boolean {
        return value.isNotBlank() && value.isNotEmpty()
    }

    fun confirmPassword(p1:String, p2:String) = p1 == p2

    fun validateItemCode(code: String): Boolean {
        return code.isNotBlank() && code.isNotEmpty()
    }

    fun validateItemName(name: String): Boolean {
        return name.isNotBlank() && name.isNotEmpty()
    }

    fun validateItemPrice(price: Double): Boolean {
        return price > 0.0
    }

    fun validateDropdownPosition(position: Int): Boolean {
        return position > -1
    }
}