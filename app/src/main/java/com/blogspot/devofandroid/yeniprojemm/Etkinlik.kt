package com.blogspot.devofandroid.yeniprojemm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_duyuru.*
import kotlinx.android.synthetic.main.activity_etkinlik.*

class Etkinlik : AppCompatActivity() {
    private lateinit var etkinlikliste: ArrayList<etkinlikler>
    private lateinit var adapter1: EtkinlikAdapter
    private lateinit var vt:VeritabaniYardimcisi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_etkinlik)
        veritabaniKopyala()
        rve.setHasFixedSize(true)
        rve.layoutManager= LinearLayoutManager(this)
        vt=VeritabaniYardimcisi(this)
        etkinlikliste= etkinliklerdao().tumetkinlikler(vt)
        adapter1= EtkinlikAdapter(this,etkinlikliste)
        rve.adapter=adapter1
    }
    fun veritabaniKopyala(){
        val copyHelper = DatabaseCopyHelper(this)
        try{
            copyHelper.createDataBase()
            copyHelper.openDataBase()
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}