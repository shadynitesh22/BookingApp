package com.example.holidaybooking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TextView

class BookActivity : AppCompatActivity() {
    private lateinit var totals: TextView
    private lateinit var adult: TextView
    private lateinit var child: TextView
    private lateinit var tax: TextView
    private lateinit var grandtotal: TextView
    private lateinit var total1:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)


        totals = findViewById(R.id.total)
        adult = findViewById(R.id.adultresult)
        child = findViewById(R.id.childhint)
        tax = findViewById(R.id.Tax)
        grandtotal = findViewById(R.id.grndtotal)
        total1=findViewById(R.id.Total)
        val intent = intent
        if (intent.extras != null) {
            val d=intent.getStringExtra("date")
            val destination = intent.getStringExtra("spinner")
            val adults = intent.getIntExtra("adult",0)
            val childs = intent.getIntExtra("children",0)
            val date= d?.toInt()


            if (destination == "Bali(3000)") {

                val total = (adults?.times(3000)?.times(date!!))
                val childtotal = (childs?.times(3000)?.times(date!!)?.div(2))
                child.text = childtotal.toString()
                adult.text = total.toString()


                val totalamount = total+ childtotal
                totals.text=totalamount.toString()
                total1.text=totalamount.toString()

                val taxamount = 0.13 * totalamount
                tax.text=taxamount.toString()


                val grandtotalamount = taxamount + totalamount
                 grandtotal.text=grandtotalamount.toString()

            } else if (destination == "Malaysia(5000)") {

                val total = (adults?.times(5000)?.times(date!!))
                val childtotal = (childs?.times(5000)?.times(date!!)?.div(2))
                child.text = childtotal.toString()
                adult.text = total.toString()


                val totalamount = total+ childtotal
                totals.text=totalamount.toString()
                total1.text=totalamount.toString()

                val taxamount = 0.13 * totalamount
                tax.text=taxamount.toString()


                val grandtotalamount = taxamount + totalamount
                grandtotal.text=grandtotalamount.toString()



            } else if (destination == "Singapore(3000)") {

                val total = (adults?.times(3000)?.times(date!!))
                val childtotal = (childs?.times(3000)?.times(date!!)?.div(2))
                child.text = childtotal.toString()
                adult.text = total.toString()



                val totalamount = total+ childtotal
                totals.text=totalamount.toString()
                total1.text=totalamount.toString()

                val taxamount = 0.13 * totalamount
                tax.text=taxamount.toString()


                val grandtotalamount = taxamount + totalamount
                grandtotal.text=grandtotalamount.toString()



            }
        }
    }
}