package com.blogspot.devofandroid.yeniprojemm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profilim.*

class Profilim : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profilim)
        val mail=intent.getStringExtra("mail")
        textView25.text=mail
        val database = DBHelper(this)
        val isim=database.erisimisim(mail)
        val soyisim=database.erisimsisim(mail)
        val sifre=database.erisimpassword(mail)
        isimiguncelle.text=isim
        soyisimiguncelle.text=soyisim
        mailimiguncelle.text=mail
        sifremiguncelle.text=sifre

        guncelle.setOnClickListener {
            val intent= Intent(this@Profilim,GuncelOgr::class.java)
            intent.putExtra("isim",isim)
            intent.putExtra("soyisim",soyisim)
            intent.putExtra("mail",mail)
            intent.putExtra("sifre",sifre)
            startActivity(intent)
        }

    }
}