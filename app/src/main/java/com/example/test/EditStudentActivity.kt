package com.example.test

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.test.StudentModel

class EditStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student) // Sử dụng chung layout với AddStudentActivity

        val editName: EditText = findViewById(R.id.edit_student_name)
        val editId: EditText = findViewById(R.id.edit_student_id)
        val btnSave: Button = findViewById(R.id.button_save)

        // Nhận dữ liệu từ MainActivity
        val student = intent.getSerializableExtra("student") as? StudentModel
        val position = intent.getIntExtra("position", -1)

        // Hiển thị thông tin hiện tại của sinh viên
        if (student != null) {
            editName.setText(student.name)
            editId.setText(student.id)
        }

        btnSave.setOnClickListener {
            val updatedName = editName.text.toString()
            val updatedId = editId.text.toString()

            if (updatedName.isNotEmpty() && updatedId.isNotEmpty()) {
                val updatedStudent = StudentModel(updatedName, updatedId)
                val resultIntent = intent
                resultIntent.putExtra("student", updatedStudent)
                resultIntent.putExtra("position", position)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}