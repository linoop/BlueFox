package com.linoop.bluefox.business

import com.linoop.bluefox.utils.PasswordUtils
import javax.inject.Inject

class CreateUserUseCase @Inject constructor(private val userRepository: UserRepository) {

    suspend fun invoke(userModel: UserModel) {
        userModel.password = PasswordUtils.encryptPassword(userModel.password)
        userRepository.createUser(userModel)
    }
}