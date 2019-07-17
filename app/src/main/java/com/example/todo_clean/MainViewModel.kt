package com.example.todo_clean

import com.example.todo_clean.domain.interactor.CreateTodo
import com.example.todo_clean.domain.interactor.GetAllTodo


/**
 * Created by kietnlt on 17 Jul 2019.
 */
class MainViewModel(
    private val getAllTodo: GetAllTodo,
    private val createTodo: CreateTodo
) {
    var title: String = ""
    var contentText: String = ""


    private var currentText = ""

    fun start() {
        refreshData()
    }

    private fun refreshData() {
        val newData = getAllTodo()
        contentText = newData.map { todo ->
            "- ${todo.title} isDone: ${todo.isDone}"
        }.joinToString("\n")
        title = "you have ${newData.size} todo!"
    }

    fun onButtonClick() {
        createTodo.execute(currentText)
        refreshData()
    }

    fun onTextChange(newValue: String) {
        currentText = newValue
    }


}