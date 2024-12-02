package com.example.test

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.test.StudentModel

class AddStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        val editName: EditText = findViewById(R.id.edit_student_name)
        val editId: EditText = findViewById(R.id.edit_student_id)
        val btnSave: Button = findViewById(R.id.button_save)

        btnSave.setOnClickListener {
            val name = editName.text.toString()
            val id = editId.text.toString()
            if (name.isNotEmpty() && id.isNotEmpty()) {
                val resultIntent = Intent()
                resultIntent.putExtra("student_name", name)
                resultIntent.putExtra("student_id", id)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}