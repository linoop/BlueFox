package com.linoop.bluefox.business

import com.linoop.bluefox.business.UserRepository
import javax.inject.Inject

class GetUserByIdUseCase @Inject constructor(private val userRepository: UserRepository) {

    suspend fun execute(userId: Int) = userRepository.getUserById(userId)

}