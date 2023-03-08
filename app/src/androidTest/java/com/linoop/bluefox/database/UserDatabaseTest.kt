package com.example.mycicdapp.data.repository.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.linoop.bluefox.data.UserEntity
import com.google.common.truth.Truth.assertThat
import com.linoop.bluefox.data.repository.database.UserDao
import com.linoop.bluefox.data.repository.database.UserDatabase
import kotlinx.coroutines.runBlocking

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class UserDatabaseTest {

    private lateinit var userDao: UserDao
    private lateinit var db: UserDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, UserDatabase::class.java).build()
        userDao = db.getDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun createUser() = runBlocking{
        val userEntity = UserEntity("Linoop", "linoop@gmail.com", "Kochi","1234")
        userDao.createUser(userEntity)
        val users = userDao.getUsers()
        assertThat(users).contains(userEntity)
    }

    @Test
    fun getUserById() = runBlocking{
        val user1 = UserEntity("Linoop", "linoop@gmail.com", "Kochi", "1234")
        val user2 = UserEntity("abc", "abc@gmail.com", "xyz", "1234")
        val userId1 = userDao.createUser(user1)
        val userId2 = userDao.createUser(user2)
        val user = userDao.getUserById(userId1.toInt())
        assertThat(user.name).isEqualTo("Linoop")
    }

    /*@Test
    @Throws(Exception::class)
    fun writeUserAndReadInList() {
        val user: User = TestUtil.createUser(3).apply {
            setName("george")
        }
        userDao.insert(user)
        val byName = userDao.findUsersByName("george")
        assertThat(byName.get(0), equalTo(user))
    }*/
}