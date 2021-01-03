package com.example.datapicker

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnDataPicker.setOnClickListener{view->
            clickDatePicker(view)
        }

    }
    fun clickDatePicker(view: View){
        val myCalendar = Calendar.getInstance()

        val year= myCalendar.get(Calendar.YEAR)
        val month= myCalendar.get(Calendar.MONTH)
        val day= myCalendar.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDayOfMonth ->
            Toast.makeText(
                this,
                "Year $selectedYear, " +
                        "Month ${selectedMonth+1}, " +
                        "day $selectedDayOfMonth", Toast.LENGTH_LONG).show()
            val selectedDate = "$selectedDayOfMonth/$selectedMonth/$selectedYear"
            tvSelectedData.setText(selectedDate)
        },year,month,day)

        dpd.datePicker.setMaxDate(Date().time - 86400000)
        dpd.show()
    }
}
