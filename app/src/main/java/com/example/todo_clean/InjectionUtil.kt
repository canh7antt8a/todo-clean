package com.example.todo_clean

import android.content.Context
import com.example.todo_clean.data.TodoRepositoryImpl
import com.example.todo_clean.data.database.MyDatabase
import com.example.todo_clean.domain.interactor.CreateTodo
import com.example.todo_clean.domain.interactor.GetAllTodo
import com.example.todo_clean.domain.repository.Repository
import androidx.room.Room
import com.example.todo_clean.data.database.TodoDao
import com.example.todo_clean.data.database.mapper.TodoEntityToTodo
import com.example.todo_clean.data.database.mapper.TodoToTodoEntity


/**
 * Created by kietnlt on 17 Jul 2019.
 */
object InjectionUtil {
    private lateinit var context: Context

    val getAllTodo: GetAllTodo by lazy {
        GetAllTodo(repository = repoImpl)
    }

    val createTodo: CreateTodo by lazy {
        CreateTodo(repository = repoImpl)
    }

    fun inject(activity: MainActivity) {
        context = activity.applicationContext
        activity.createTodo = createTodo
        activity.getAllTodo = getAllTodo
        activity.viewModel = MainViewModel(
            getAllTodo = getAllTodo,
            createTodo = createTodo
        )
    }

    val database: MyDatabase by lazy {
        Room.databaseBuilder(
            context,
            MyDatabase::class.java, "Sample.db"
        )
            .allowMainThreadQueries()
            .build()
    }

    private val dao: TodoDao by lazy {
        database.dao()
    }

    val repoImpl: Repository by lazy {
        TodoRepositoryImpl(
            dao = dao,
            todoEntityToTodo = TodoEntityToTodo(),
            todoToTodoEntity = TodoToTodoEntity()
        )
    }
}