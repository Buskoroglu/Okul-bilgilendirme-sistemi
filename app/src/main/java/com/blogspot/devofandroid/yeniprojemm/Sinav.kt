package com.blogspot.devofandroid.yeniprojemm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_duyuru.*
import kotlinx.android.synthetic.main.activity_sinav.*

class Sinav : AppCompatActivity() {
    private lateinit var sinavliste: ArrayList<Sinavlar>
    private lateinit var adapter: SinavAdapter
    private lateinit var vt:VeritabaniYardimcisi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sinav)
        veritabaniKopyala()
        rvs.setHasFixedSize(true)
        rvs.layoutManager= LinearLayoutManager(this)
        vt= VeritabaniYardimcisi(this)
        sinavliste= Sinavlardao().tumsinavlar(vt)
        adapter= SinavAdapter(this,sinavliste)
        rvs.adapter=adapter
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