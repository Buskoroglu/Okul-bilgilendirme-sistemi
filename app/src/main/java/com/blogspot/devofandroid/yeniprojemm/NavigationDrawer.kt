package com.blogspot.devofandroid.yeniprojemm

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_akademisyennavigation.*
import kotlinx.android.synthetic.main.activity_navigation_drawer.*
import kotlinx.android.synthetic.main.activity_navigation_drawer.drawera
import kotlinx.android.synthetic.main.navigation_title.view.*

class NavigationDrawer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)
        textView20.text= intent.getStringExtra("isim")
        imageButton.setOnClickListener {
            val intenta= Intent(this@NavigationDrawer,Akademisyengonderi::class.java)
            startActivity(intenta)
        }

        imageButton2.setOnClickListener {
            val intentb= Intent(this@NavigationDrawer,Yemek::class.java)
            startActivity(intentb)
        }

        imageButton3.setOnClickListener {
            val intentc= Intent(this@NavigationDrawer,Duyuru::class.java)
            startActivity(intentc)
        }

        imageButton4.setOnClickListener {
            val intentd= Intent(this@NavigationDrawer,Etkinlik::class.java)
            startActivity(intentd)
        }

        imageButton5.setOnClickListener {
            val intente= Intent(this@NavigationDrawer,Sinav::class.java)
            startActivity(intente)
        }

        imageButton6.setOnClickListener {
            val intentf= Intent(this@NavigationDrawer,Websitesi::class.java)
            startActivity(intentf)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.profilim -> {
                val intent = Intent(this@NavigationDrawer,Profilim::class.java)
                intent.putExtra("mail",textView20.text)
                startActivity(intent)
            }
            R.id.iletisim -> {
                val intent = Intent(this@NavigationDrawer,iletisim::class.java)
                startActivity(intent)
            }
            R.id.cikis -> {
                val intent = Intent(this@NavigationDrawer,MainActivity::class.java)
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