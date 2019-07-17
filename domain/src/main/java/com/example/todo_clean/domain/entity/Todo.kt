package com.example.todo_clean.domain.entity


/**
 * Created by kietnlt on 17 Jul 2019.
 */
data class Todo(
    val identity: String,
    val title: String,
    val isDone: Boolean
)