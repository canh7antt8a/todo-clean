package com.example.todo_clean

import com.example.todo_clean.domain.entity.Todo
import com.example.todo_clean.domain.interactor.CreateTodo
import com.example.todo_clean.domain.repository.Repository
import org.junit.Assert
import org.junit.Test


/**
 * Created by kietnlt on 17 Jul 2019.
 */
class CreateTodoTest {

    @Test
    fun `should throw exception when title is empty`() {
        val usecase = CreateTodo(
            repository = object : Repository {
                override fun getAllTodo(): List<Todo> {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun create(todo: Todo): String {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            }
        )
        var throwed = false
        try {
            usecase.execute("")
        } catch (e: Throwable) {
            throwed = true
            Assert.assertEquals("todo title must not be blank", e.message)
        }

        Assert.assertTrue(throwed == true)

    }

    @Test
    fun `should throw exception when title is '   ' `() {
        val usecase = CreateTodo(
            repository = object : Repository {
                override fun getAllTodo(): List<Todo> {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun create(todo: Todo): String {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            }
        )
        var throwed = false
        try {
            usecase.execute("   ")
        } catch (e: Throwable) {
            throwed = true
            Assert.assertEquals("todo title must not be blank", e.message)
        }

        Assert.assertTrue(throwed == true)
    }

    @Test
    fun `call to repository when data is valid`() {
        var calledToCreateWith: Todo? = null

        val usecase = CreateTodo(
            repository = object : Repository {
                override fun getAllTodo(): List<Todo> {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun create(todo: Todo): String {
                    calledToCreateWith = todo
                    return ""
                }

            }
        )

        val input = "123"

        val expected = Todo(
            identity = "",
            title = input,
            isDone = false
        )

        usecase.execute(title = input)

        Assert.assertEquals(expected, calledToCreateWith)
    }
}