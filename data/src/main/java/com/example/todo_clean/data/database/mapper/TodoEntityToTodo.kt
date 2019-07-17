package com.example.todo_clean.data.database.mapper

import com.example.todo_clean.data.database.TodoEntity
import com.example.todo_clean.domain.entity.Todo


/**
 * Created by kietnlt on 17 Jul 2019.
 */
class TodoEntityToTodo {

    fun map(entity: TodoEntity): Todo {
        return Todo(
            identity = entity.toString(),
            title = entity.title,
            isDone = entity.isDone
        )
    }
}