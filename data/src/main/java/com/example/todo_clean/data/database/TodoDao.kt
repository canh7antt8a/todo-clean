package com.example.todo_clean.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


/**
 * Created by kietnlt on 17 Jul 2019.
 */

@Dao
abstract class TodoDao {

    @Query("SELECT * FROM todo")
    abstract fun getAll(): List<TodoEntity>

    @Insert
    abstract fun insert(todoEntity: TodoEntity)
}