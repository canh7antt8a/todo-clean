package com.example.todo_clean.domain.interactor

import com.example.todo_clean.domain.entity.Todo
import com.example.todo_clean.domain.repository.Repository


/**
 * Created by kietnlt on 17 Jul 2019.
 */
class CreateTodo constructor(
    private val repository: Repository
) {
    /**
     * - khi tao moi to do, mac dinh de chua hoan thanh
     * - noi dung cua to do khong duoc rong
     */
    fun execute(title: String) {
        if (title.isBlank()) {
            throw IllegalArgumentException("todo title must not be blank")
        }

        val todo = Todo(
            identity = "",
            title = title,
            isDone = false
        )
        repository.create(todo)
    }
}