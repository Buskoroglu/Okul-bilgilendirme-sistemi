package com.blogspot.devofandroid.yeniprojemm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_guncel_ogr.*

class GuncelOgr : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guncel_ogr)
        val mail=intent.getStringExtra("mail")
        val isim=intent.getStringExtra("isim")
        val soyisim=intent.getStringExtra("soyisim")
        val sifre=intent.getStringExtra("sifre")
        editTextisim.setText("$isim")
        editTextsoyisim.setText("$soyisim")
        editTextmail.setText("$mail")
        editTextsifre.setText("$sifre")
       val db=DBHelper(this)
        guncelleogr.setOnClickListener {
                val isim1=editTextisim.text
                val soyisim1=editTextsoyisim.text
                val mail1= editTextmail.text
                val sifre1=editTextsifre.text
                val x=db.updateData(mail1.toString(),isim1.toString(),soyisim1.toString(),sifre1.toString())
                Toast.makeText(applicationContext,"Güncellendi, yeniden giriş yapın", Toast.LENGTH_SHORT).show()
                val intent=Intent(this@GuncelOgr,NavigationDrawer::class.java)
                startActivity(intent)
        }
    }
}