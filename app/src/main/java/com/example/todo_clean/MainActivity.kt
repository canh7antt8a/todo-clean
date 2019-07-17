package com.example.todo_clean

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.todo_clean.domain.interactor.CreateTodo
import com.example.todo_clean.domain.interactor.GetAllTodo

class MainActivity : AppCompatActivity() {

    lateinit var getAllTodo: GetAllTodo
    lateinit var createTodo: CreateTodo

    lateinit var editText: EditText
    lateinit var button: Button
    lateinit var contentTextView: TextView

    lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        InjectionUtil.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.start()

        editText = findViewById<EditText>(R.id.editText)
        editText.addTextChangedListener( object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.onTextChange(p0?.toString() ?: "")
            }

        })
        button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            viewModel.onButtonClick()
            bind()
        }

        contentTextView = findViewById(R.id.todo_list_text_view)
        bind()

    }

    fun bind() {
        contentTextView.text = viewModel.contentText
        setTitle(viewModel.title)
    }
}
