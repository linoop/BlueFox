package com.linoop.bluefox.business

interface UserRepository {
    suspend fun createUser(userModel: UserModel):Long
    suspend fun getUserById(userId: Int): UserModel
    suspend fun getUsers(): List<UserModel>
}