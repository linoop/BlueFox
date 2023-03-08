package com.linoop.bluefox.data.repository

import com.linoop.bluefox.business.UserModel
import com.linoop.bluefox.business.UserRepository
import com.linoop.bluefox.data.UserEntity
import com.linoop.bluefox.data.repository.database.UserDao
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val userDao: UserDao): UserRepository {
    override suspend fun createUser(userModel: UserModel) {
        val userEntity = UserEntity(
            userModel.name,
            userModel.email,
            userModel.address,
            userModel.password
        )
        userDao.createUser(userEntity)
    }

    override suspend fun getUserById(userId: Int): UserModel {
       val user = userDao.getUserById(userId)
        return UserModel(user.userId!!, user.name, user.email, user.address, user.password)
    }

    override suspend fun getUsers(): List<UserModel> {
        return userDao.getUsers().map {
            UserModel(it.userId!!, it.name, it.email, it.address, it.password)
        }

        /*try {
            val data = service.getProductList().map {
                Product(
                    it.title,
                    it.description,
                    it.price,
                    it.imageUrl,
                    it.id
                )
            }
            if (data.isNotEmpty()) {
                Success(data)
            } else {
                Error(IllegalStateException("Empty product list"))
            }
        } catch (exception: Exception) {
            Log.e("NetworkLayer", exception.message, exception)
            Error(exception)
        }*/
    }
}