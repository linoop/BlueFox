package com.linoop.bluefox.business
import com.linoop.bluefox.business.UserRepository
import javax.inject.Inject

class CreateUserUseCase @Inject constructor(private val userRepository: UserRepository) {

    suspend fun invoke(userModel: UserModel) = userRepository.createUser(userModel)
}