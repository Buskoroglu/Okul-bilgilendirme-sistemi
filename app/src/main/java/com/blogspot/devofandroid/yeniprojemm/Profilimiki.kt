package com.blogspot.devofandroid.yeniprojemm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profilim.isimiguncelle
import kotlinx.android.synthetic.main.activity_profilim.mailimiguncelle
import kotlinx.android.synthetic.main.activity_profilim.sifremiguncelle
import kotlinx.android.synthetic.main.activity_profilim.soyisimiguncelle
import kotlinx.android.synthetic.main.activity_profilim.textView25
import kotlinx.android.synthetic.main.activity_profilimiki.*

class Profilimiki : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profilimiki)
        val mail=intent.getStringExtra("mail")
        textView25.text=mail
        val database = DBHelperiki(this)
        val isim=database.erisimisim(mail)
        val soyisim=database.erisimsisim(mail)
        val sifre=database.erisimpassword(mail)
        isimiguncelle.text=isim
        soyisimiguncelle.text=soyisim
        mailimiguncelle.text=mail
        sifremiguncelle.text=sifre

     guncelleiki.setOnClickListener {
         val intent= Intent(this@Profilimiki,GuncelAk::class.java)
         intent.putExtra("isim",isim)
         intent.putExtra("soyisim",soyisim)
         intent.putExtra("mail",mail)
         intent.putExtra("sifre",sifre)
         startActivity(intent)
     }

    }
}