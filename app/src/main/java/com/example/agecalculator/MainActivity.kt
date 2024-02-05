package com.example.agecalculator

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar
import java.util.Date

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstname = findViewById<EditText>(R.id.editfirstname)
        val lastname = findViewById<EditText>(R.id.editTlastname)
        val month = findViewById<EditText>(R.id.editmonth)
        val day = findViewById<EditText>(R.id.editday)
        val year = findViewById<EditText>(R.id.edityear)
        val birthday = findViewById<TextView>(R.id.bdText)

        val time = Calendar.getInstance()

        val currentTime = time.weekYear
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        val btnCalAgeVar = findViewById<Button>(R.id.btnCalAge)
        btnCalAgeVar.setOnClickListener(View.OnClickListener {

            if (firstname.editableText.toString().isEmpty() &&
                lastname.editableText.toString().isEmpty()
            ) {
                Toast.makeText(
                    this, "Hi! We can't really tell you your age without your name!",
                    Toast.LENGTH_SHORT
                ).show();
            } else {
                if (year.editableText.toString().isEmpty() ||
                    day.editableText.toString().isEmpty() ||
                    month.editableText.toString().isEmpty()
                ) {
                    Toast.makeText(
                        this, "Hi! " + firstname.editableText.toString() + " " +
                                "" + lastname.editableText.toString() + " Please enter your birthday so we can calculate your age!",
                        Toast.LENGTH_SHORT
                    ).show();
                } else if (year.editableText.toString().toInt() > 0 &&
                    year.editableText.toString().toInt() <= currentTime &&
                    day.editableText.toString().toInt() > 0 &&
                    day.editableText.toString().toInt() <= 31 &&
                    month.editableText.toString().toInt() > 0 &&
                    month.editableText.toString().toInt() <= 12
                ) {
                    val birthTime = time.set(
                        year.editableText.toString().toInt(),
                        month.editableText.toString().toInt(),
                        day.editableText.toString().toInt()

                    )
                    val birthDateString =
                        year.editableText.toString() + "-" + month.editableText.toString() + "-" + day.editableText.toString()
                            .toInt();

                    val dateOfBirth: Date = dateFormat.parse(birthDateString)

                            birthday.setText("Your birthday is "+ dateOfBirth.toString().replace("EST", "").replace("00", "").replace(":", ""))
                            Toast.makeText(
                        this, "Hi " + firstname.editableText.toString() + "! " +
                                "" + lastname.editableText.toString() + ",\nYour age is " + (currentTime - time.weekYear) + " years old!",
                        Toast.LENGTH_LONG
                    ).show();


                } else {
                    Toast.makeText(
                        this, "Hi! we can't really use this date to calculate your age!",
                        Toast.LENGTH_SHORT
                    ).show();
                }
            }
        })
    }


}
