package com.linoop.bluefox.business

data class UserModel(
    val userId: Long,
    val name: String,
    val email: String,
    val address: String,
    var password: String
)