package com.example.calendarassignment

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var etDate : EditText
    private lateinit var etDob : EditText
    private lateinit var tvWork : TextView
    private lateinit var tvAge: TextView

    val c = Calendar.getInstance()
    val currentyear = c.get(Calendar.YEAR)
    val currentmonth = c.get(Calendar.MONTH)
    val currentday = c.get(Calendar.DAY_OF_MONTH)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etDate = findViewById(R.id.etDate)
        etDob = findViewById(R.id.etDob)
        tvWork = findViewById(R.id.tvWork)
        tvAge = findViewById(R.id.tvAge)


        etDate.setOnClickListener {
            loadCalendar()

        }
        etDob.setOnClickListener {
            anotherCalendar()

        }


    }
    private fun loadCalendar(){


        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener{
                    view, year, monthOfYear, dayOfMonth ->
                etDate.setText("$dayOfMonth-${monthOfYear +1}-$year")
                tvWork.text = ("No. of Years worked :" +"${currentyear-year}  years"+"${currentmonth - monthOfYear} months"  )
            },
            currentyear,
            currentmonth,
            currentday
        )
        datePickerDialog.show()
    }

    private fun anotherCalendar(){
        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener{
                    view, year, monthOfYear, dayOfMonth ->
                etDob.setText("$dayOfMonth-${monthOfYear +1}-$year")
                tvAge.text = ("Your age is :" + "${currentyear-year} ")
            },
            currentyear-20,
            currentmonth,
            currentday
        )
        datePickerDialog.show()

    }
}