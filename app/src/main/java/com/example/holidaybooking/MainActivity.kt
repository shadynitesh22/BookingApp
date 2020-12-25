package com.example.holidaybooking

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var book: Button
    private lateinit var text1: TextView
    private lateinit var text2: TextView
    private lateinit var checkin: Button
    private lateinit var chekout: Button
    private lateinit var spinner: Spinner
    private var selectedI =""
    private var days=""
    private var dayDifference=""
    private var date1=""
    private var date2=""
    private val category = arrayListOf("Bali(3000)", "Malaysia(5000)", "Singapore(3000)")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text1 = findViewById(R.id.adults)
        text2 = findViewById(R.id.children)
        spinner = findViewById(R.id.spinner)
        checkin = findViewById(R.id.checkin)
        chekout = findViewById(R.id.checkout)
        book = findViewById(R.id.book)


        checkin.setOnClickListener {
            LoadCalander1()
        }
        chekout.setOnClickListener {
            LoadCalander2()
        }


        val adapter
                = ArrayAdapter(this, android.R.layout.simple_list_item_1, category)
        spinner.adapter=adapter
        spinner.onItemSelectedListener =object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                selectedI = parent?.getItemAtPosition(position).toString()
                Toast.makeText(this@MainActivity,"$selectedI",Toast.LENGTH_SHORT).show()


            }


            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }

    fun book(View: View) {
        CalcDate()
        when (View?.id) {
            R.id.book -> {
                var adult = text1.text.toString().toIntOrNull()

                var child = text2.text.toString().toIntOrNull()


                text1.setText("")
                text2.setText("")



                Toast.makeText(this, "You have selcted $$adult :Adults and $child :Children", Toast.LENGTH_SHORT).show()

                val date=dayDifference

                val intent = Intent(
                        this@MainActivity,BookActivity::class.java

                )
                intent.putExtra("date",dayDifference)
                intent.putExtra("spinner",selectedI)
                intent.putExtra("children",child)
                intent.putExtra("adult",adult)


                startActivity(intent)

            }

        }


    }



    private fun LoadCalander1() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val Day = c.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(
                this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            val date="$dayOfMonth/${month+1}/$year"
            date1=date
            Toast.makeText(
                    this,
                    "Selected Date is:$date",
                    Toast.LENGTH_LONG
            ).show()
        }, year, month, Day)

        datePickerDialog.show()

    }

    private fun LoadCalander2() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val Day = c.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(
                this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            val date="$dayOfMonth/${month+1}/$year"
            date2=date
            Toast.makeText(
                    this,
                    "Selected Date is:$date",
                    Toast.LENGTH_LONG
            ).show()
        }, year, month, Day)

        datePickerDialog.show()

    }
    private fun CalcDate(){
        val currentdate=date1.toString()
        val finaldate=date2.toString()
        val date1: Date
        val date2: Date
        val dates = SimpleDateFormat("dd/MM/yyyy")
        date1 = dates.parse(currentdate)
        date2 = dates.parse(finaldate)
        val difference: Long = Math.abs(date1.time - date2.time)
        val differenceDates = difference / (24 * 60 * 60 * 1000)
        dayDifference = differenceDates.toString()
    }

}






