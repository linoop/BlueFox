package com.linoop.bluefox.business

import com.linoop.bluefox.business.UserRepository
import com.linoop.bluefox.utils.DatabaseResult
import javax.inject.Inject

class GetUserByIdUseCase @Inject constructor(private val userRepository: UserRepository) {

    suspend fun execute(userId: Long): DatabaseResult<UserModel> {
        return DatabaseResult.Success(userRepository.getUserById(userId))
    }

}