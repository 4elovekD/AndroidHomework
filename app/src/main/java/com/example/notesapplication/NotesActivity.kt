package com.example.notesapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NotesActivity : AppCompatActivity() {

    private lateinit var buttonAdd: Button
    private lateinit var notesContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_notes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        buttonAdd = findViewById(R.id.buttonAdd)
        notesContainer = findViewById(R.id.notesContainer)

        buttonAdd.setOnClickListener {
            addNewNote()
        }
    }

    private fun addNewNote() {
        val editText = EditText(this).apply {
            hint = "Введите заметку"
        }
        notesContainer.addView(editText)
    }


}