package com.example.todo_clean.domain.interactor

import com.example.todo_clean.domain.entity.Todo
import com.example.todo_clean.domain.repository.Repository


/**
 * Created by kietnlt on 17 Jul 2019.
 */
class GetAllTodo constructor(
    private val repository: Repository
) {
    operator fun invoke(): List<Todo> {
        return repository.getAllTodo()
    }
}