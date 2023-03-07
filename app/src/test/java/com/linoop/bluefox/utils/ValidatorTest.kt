package com.linoop.bluefox.utils


import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ValidatorTest {

    @Test
    fun validateField() {
        assertThat(Validator.validateField("123")).isEqualTo(true)
        assertThat(Validator.validateField("")).isEqualTo(false)
    }

    @Test
    fun confirmPassword() {
        assertThat(Validator.confirmPassword("123","123")).isEqualTo(true)
        assertThat(Validator.confirmPassword("123","456")).isEqualTo(false)
    }

    @Test
    fun validateItemCode() {
        assertThat(Validator.validateItemCode("123")).isEqualTo(true)
        assertThat(Validator.validateItemCode("")).isEqualTo(false)
    }

    @Test
    fun validateItemName() {
        assertThat(Validator.validateItemName("Name")).isEqualTo(true)
        assertThat(Validator.validateItemName("")).isEqualTo(false)
    }

    @Test
    fun validateItemPrice() {
        assertThat(Validator.validateItemPrice(10.0)).isEqualTo(true)
        assertThat(Validator.validateItemPrice(-10.0)).isEqualTo(false)
        assertThat(Validator.validateItemPrice(0.0)).isEqualTo(false)
    }

    @Test
    fun validateDropdownPosition() {
        assertThat(Validator.validateDropdownPosition(2)).isEqualTo(true)
        assertThat(Validator.validateDropdownPosition(-2)).isEqualTo(false)
    }
}