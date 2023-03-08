package com.linoop.bluefox.di

import android.content.Context
import androidx.room.Room
import com.linoop.bluefox.business.*
import com.linoop.bluefox.data.repository.UserRepositoryImpl
import com.linoop.bluefox.data.repository.database.UserDao
import com.linoop.bluefox.data.repository.database.UserDatabase
import com.linoop.bluefox.utils.Constants.MIGRATION_1_2
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
        Room.databaseBuilder(app, UserDatabase::class.java, MY_DATABASE_NAME)
            .addMigrations(MIGRATION_1_2)
            .build()
            .getDao()

    @Singleton
    @Provides
    fun provideUserRepository(userDao: UserDao): UserRepository = UserRepositoryImpl(userDao)

    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    fun provideValidateName() = ValidateNameUseCase()

    @Provides
    fun provideValidateEmail() = ValidateEmailUseCase()

    @Provides
    fun provideValidateAddress() = ValidateAddressUseCase()

    @Provides
    fun provideValidatePassword() = ValidatePasswordUseCase()

    @Provides
    fun provideValidateConfirmPsw() = ValidateConfirmPswUseCase()

}