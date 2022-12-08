package com.blogspot.devofandroid.yeniprojemm

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat

import kotlinx.android.synthetic.main.activity_akademisyennavigation.*


class Akademisyennavigation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_akademisyennavigation)
        val x=intent.getStringExtra("mail")
        val DB = DBHelperiki(this)
        val isim=DB.erisim(x)
        textView15.text=isim
        textView19.text=x
        program.setOnClickListener {
            val intent= Intent(this@Akademisyennavigation,Listeleme::class.java)
            intent.putExtra("mail",x)
            intent.putExtra("isim",isim)
            startActivity(intent)
        }

        yemek.setOnClickListener {
            val intent2= Intent(this@Akademisyennavigation,Yemek::class.java)
            startActivity(intent2)
        }

        duyuru.setOnClickListener {
            val intent3= Intent(this@Akademisyennavigation,Duyuru::class.java)
            startActivity(intent3)
        }

        etkinlik.setOnClickListener {
            val intent4= Intent(this@Akademisyennavigation,Etkinlik::class.java)
            startActivity(intent4)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.profilim -> {
                val intent = Intent(this@Akademisyennavigation,Profilimiki::class.java)
                intent.putExtra("mail",textView19.text)
                startActivity(intent)
            }
            R.id.iletisim -> {
                val intent = Intent(this@Akademisyennavigation,iletisim::class.java)
                startActivity(intent)
            }
            R.id.cikis -> {
                val intent = Intent(this@Akademisyennavigation,MainActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onBackPressed() {
        if(drawera.isDrawerOpen(GravityCompat.START))

            drawera.closeDrawer(GravityCompat.START)
        else
            super.onBackPressed()

    }

}
