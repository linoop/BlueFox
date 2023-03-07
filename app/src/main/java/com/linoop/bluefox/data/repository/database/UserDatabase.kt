package com.linoop.bluefox.data.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.linoop.bluefox.data.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = true)
abstract class UserDatabase : RoomDatabase(){
    abstract fun getDao(): UserDao
}