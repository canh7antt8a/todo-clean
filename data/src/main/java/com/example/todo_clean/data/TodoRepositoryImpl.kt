package com.example.todo_clean.data

import com.example.todo_clean.data.database.TodoDao
import com.example.todo_clean.data.database.TodoEntity
import com.example.todo_clean.data.database.mapper.TodoEntityToTodo
import com.example.todo_clean.data.database.mapper.TodoToTodoEntity
import com.example.todo_clean.domain.entity.Todo
import com.example.todo_clean.domain.repository.Repository


/**
 * Created by kietnlt on 17 Jul 2019.
 */
class TodoRepositoryImpl constructor(
    private val dao: TodoDao,
    private val todoToTodoEntity: TodoToTodoEntity,
    private val todoEntityToTodo: TodoEntityToTodo
) : Repository {


    override fun getAllTodo(): List<Todo> {
        val entityList: List<TodoEntity> = dao.getAll()
        return entityList.map { entity ->
            todoEntityToTodo.map(entity)
        }
    }

    override fun create(todo: Todo): String {
        val entity: TodoEntity = todoToTodoEntity.map(todo)
        dao.insert(entity)
        return ""
    }
}