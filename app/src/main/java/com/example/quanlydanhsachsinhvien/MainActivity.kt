package com.example.quanlydanhsachsinhvien

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val input_name = findViewById<EditText>(R.id.input_name)
        val input_mssv = findViewById<EditText>(R.id.input_mssv)
        val button_add = findViewById<Button>(R.id.button_add)



        val students = mutableListOf<StudentModel>()

        repeat(5) {
            students.add(StudentModel(
                "Student $it",
                "SV$it"
            ))
        }

        val adapter = StudentAdapter(students)

        val listStudents = findViewById<ListView>(R.id.list_students)
        listStudents.adapter = adapter


        button_add.setOnClickListener{
            var name: String = input_name.text.toString()
            var mssv: String = input_mssv.text.toString()


            if (name.isNotEmpty() && mssv.isNotEmpty()) {
                students.add(StudentModel(name, mssv))
                adapter.notifyDataSetChanged()

                input_name.text.clear()
                input_mssv.text.clear()
            }
        }



    }
}