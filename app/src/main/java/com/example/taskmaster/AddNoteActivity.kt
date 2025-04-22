package com.example.taskmaster

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taskmaster.databinding.ActivityAddNoteBinding
import com.example.taskmaster.Note


class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var db: NoteDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NoteDatabaseHelper(this)

        binding.saveButton.setOnClickListener {
            val title = binding.titleEdittext.text.toString()
            val content = binding.contendEditText.text.toString()
            val note = Note(0, title, content)
            db.insertNote(note)
            finish()
        }
    }
}
