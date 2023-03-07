package com.linoop.bluefox.business

import com.linoop.bluefox.business.UserRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend fun invoke(): List<UserModel> {
        return userRepository.getUsers()
    }
}