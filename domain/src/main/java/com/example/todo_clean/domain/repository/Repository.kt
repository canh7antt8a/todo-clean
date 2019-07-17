package com.example.todo_clean.domain.repository

import com.example.todo_clean.domain.entity.Todo


/**
 * Created by kietnlt on 17 Jul 2019.
 */
interface Repository {
    fun getAllTodo(): List<Todo>
    // create new todo, return todo identity
    fun create(todo: Todo): String
}