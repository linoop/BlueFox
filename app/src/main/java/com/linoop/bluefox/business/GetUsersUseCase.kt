package com.linoop.bluefox.business

import com.linoop.bluefox.business.UserRepository
import com.linoop.bluefox.presentation.UserListCardViewModel
import com.linoop.bluefox.utils.DatabaseResult
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend fun invoke(): DatabaseResult<List<UserListCardViewModel>> {
        val users = userRepository.getUsers()
            .map { UserListCardViewModel(it.userId, it.name, it.email, it.address) }
        return if (users.isEmpty()) DatabaseResult.Error(IllegalStateException("Empty user list"))
        else DatabaseResult.Success(users)
    }
}