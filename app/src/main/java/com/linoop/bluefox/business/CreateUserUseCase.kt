package com.linoop.bluefox.business

import com.linoop.bluefox.utils.DatabaseResult
import com.linoop.bluefox.utils.PasswordUtils
import java.sql.SQLException
import javax.inject.Inject

class CreateUserUseCase @Inject constructor(private val userRepository: UserRepository) {

    suspend fun invoke(userModel: UserModel): DatabaseResult<Long> {
        userModel.password = PasswordUtils.encryptPassword(userModel.password)
        val userId = userRepository.createUser(userModel)
        return if (userId > 0) DatabaseResult.Success(userId)
        else DatabaseResult.Error(SQLException("Failed insert user!!!"))
    }
}