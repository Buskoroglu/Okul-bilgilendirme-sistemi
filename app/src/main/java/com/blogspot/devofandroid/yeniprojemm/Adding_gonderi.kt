package com.blogspot.devofandroid.yeniprojemm


import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_adding_gonderi.*
import java.util.*


class Adding_gonderi : AppCompatActivity() {
    var id = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adding_gonderi)
        try {
            val bundle: Bundle? = intent.extras
            id = bundle!!.getInt("id", 0)
            if (id != 0) {
                TextGonderi.setText(bundle.getString("gonderi"))
                TextDate.setText(bundle.getString("date"))
                TextTime.setText(bundle.getString("saat"))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        val y= intent.getStringExtra("isim")
        textView16.text=y

        TextTime.setOnClickListener {

            val calendar = Calendar.getInstance()

            val saat = calendar.get(Calendar.HOUR_OF_DAY)
            val dakika = calendar.get(Calendar.MINUTE)

            val timePicker = TimePickerDialog(this@Adding_gonderi,
                TimePickerDialog.OnTimeSetListener { timePicker, s, dk ->


                    TextTime.setText("$s : $dk")


                },saat,dakika,true)

            timePicker.setTitle("Saat Seçiniz")
            timePicker.setButton(DialogInterface.BUTTON_POSITIVE,"AYARLA",timePicker)
            timePicker.setButton(DialogInterface.BUTTON_NEGATIVE,"İPTAL",timePicker)

            timePicker.show()


        }


        TextDate.setOnClickListener {

            val calendar = Calendar.getInstance()

            val yil = calendar.get(Calendar.YEAR)
            val ay = calendar.get(Calendar.MONTH)
            val gun = calendar.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(this@Adding_gonderi,
                DatePickerDialog.OnDateSetListener { datePicker, y, a, g ->

                    TextDate.setText("$g/${a+1}/$y")

                },yil,ay,gun)

            datePicker.setTitle("Saat Seçiniz")
            datePicker.setButton(DialogInterface.BUTTON_POSITIVE,"AYARLA",datePicker)
            datePicker.setButton(DialogInterface.BUTTON_NEGATIVE,"İPTAL",datePicker)

            datePicker.show()

        }
    }


    fun addGonderi(view: View) {
        val db = DBHelperg(this)
        val gonderi = TextGonderi.text.toString()
        val isim=textView16.text.toString()
        val date=TextDate.text.toString()
        val saat=TextTime.text.toString()

        if (id == 0) {
            if (gonderi.isNotEmpty()) {
                val gonderim = Gonderi(gonderi,isim,date,saat)
                db.insert(gonderim)
                finish()
            } else {
                Toast.makeText(this, "Please fill in the blank fields.", Toast.LENGTH_SHORT).show()
            }
        } else {
            if (gonderi.isNotEmpty()) {
                val gonderim = Gonderi(id,gonderi,isim,date,saat)
                db.update(gonderim)
                finish()
            } else {
                Toast.makeText(this, "Please fill in the blank fields", Toast.LENGTH_SHORT).show()
            }
        }


    }
}