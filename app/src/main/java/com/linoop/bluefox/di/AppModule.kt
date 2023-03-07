package com.linoop.bluefox.di

import android.content.Context
import androidx.room.Room
import com.linoop.bluefox.business.UserRepository
import com.linoop.bluefox.data.repository.UserRepositoryImpl
import com.linoop.bluefox.data.repository.database.UserDao
import com.linoop.bluefox.data.repository.database.UserDatabase
import com.linoop.bluefox.utils.Constants.MY_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMyDao(@ApplicationContext app: Context): UserDao =
        Room.databaseBuilder(app, UserDatabase::class.java, MY_DATABASE_NAME).build().getDao()

    @Singleton
    @Provides
    fun provideUserRepository(userDao: UserDao): UserRepository = UserRepositoryImpl(userDao)


    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

}