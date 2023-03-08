package com.linoop.bluefox.utils

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

object Constants {
    const val MY_DATABASE_NAME = "my_database"
    const val USER_TABLE = "user"

    val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE $USER_TABLE ADD COLUMN password TEXT")
        }
    }

}