package com.linoop.bluefox.utils

sealed class DatabaseResult<out T> {
    data class Error(val exception: Exception) : DatabaseResult<Nothing>()
    data class Success<T>(val data: T) : DatabaseResult<T>()
}