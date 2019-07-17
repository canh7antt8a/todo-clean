package com.example.todo_clean.data.database

import androidx.room.Database
import androidx.room.RoomDatabase


/**
 * Created by kietnlt on 17 Jul 2019.
 */

@Database(entities = [TodoEntity::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun dao(): TodoDao
}