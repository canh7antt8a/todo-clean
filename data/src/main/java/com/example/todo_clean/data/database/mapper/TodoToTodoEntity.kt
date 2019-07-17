package com.example.todo_clean.data.database.mapper

import com.example.todo_clean.data.database.TodoEntity
import com.example.todo_clean.domain.entity.Todo


/**
 * Created by kietnlt on 17 Jul 2019.
 */
class TodoToTodoEntity {

    fun map(todo: Todo): TodoEntity {
        return TodoEntity(
            id = 0,
            title = todo.title,
            isDone = todo.isDone
        )
    }
}