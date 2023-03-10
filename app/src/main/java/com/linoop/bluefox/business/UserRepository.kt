package com.linoop.bluefox.business

interface UserRepository {
    suspend fun createUser(userModel: UserModel):Long
    suspend fun getUserById(userId: Long): UserModel
    suspend fun getUsers(): List<UserModel>
}