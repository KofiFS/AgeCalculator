package com.example.agecalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstname = findViewById<EditText>(R.id.editfirstname)
        val lastname = findViewById<EditText>(R.id.editTlastname)
        val month = findViewById<EditText>(R.id.editmonth)
        val day = findViewById<EditText>(R.id.editday)
        val year = findViewById<EditText>(R.id.edityear)

    val btnCalAgeVar = findViewById<Button>(R.id.btnCalAge)
        btnCalAgeVar.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Hi! Kofi Shang your age is 25 years old which is pretty cool.", Toast.LENGTH_SHORT).show();

        })
    }


}
