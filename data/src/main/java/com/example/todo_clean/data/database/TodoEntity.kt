package com.example.todo_clean.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by kietnlt on 17 Jul 2019.
 */
@Entity(tableName = "todo")
data class TodoEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "is_done")
    val isDone: Boolean

)