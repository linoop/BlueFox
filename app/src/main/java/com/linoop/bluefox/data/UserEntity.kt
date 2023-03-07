package com.linoop.bluefox.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.linoop.bluefox.utils.Constants.USER_TABLE

@Entity(tableName = USER_TABLE)
data class UserEntity(val name: String, val email: String, val address: String) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    var userId: Int? = null
}
