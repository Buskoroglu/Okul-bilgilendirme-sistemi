package com.blogspot.devofandroid.yeniprojemm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_duyuru.*
import kotlinx.android.synthetic.main.activity_etkinlik.*

class Duyuru : AppCompatActivity() {
    private lateinit var duyuruliste: ArrayList<duyurular>
    private lateinit var adapter: DuyuruAdapter
    private lateinit var vt:VeritabaniYardimcisi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_duyuru)
        veritabaniKopyala()
        rv.setHasFixedSize(true)
        rv.layoutManager=LinearLayoutManager(this)
        vt= VeritabaniYardimcisi(this)
        duyuruliste= duyurulardao().tumduyurular(vt)
        adapter= DuyuruAdapter(this,duyuruliste)
        rv.adapter=adapter
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