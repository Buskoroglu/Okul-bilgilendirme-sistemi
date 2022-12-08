package com.blogspot.devofandroid.yeniprojemm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_yemek.*

class Yemek : AppCompatActivity() {
    private lateinit var yemekliste: ArrayList<yemeklist>
    private lateinit var adapter: YemekAdapter
    private lateinit var vt:VeritabaniYardimcisi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yemek)
        veritabaniKopyala()
        rvy.setHasFixedSize(true)
        rvy.layoutManager= LinearLayoutManager(this)
        vt= VeritabaniYardimcisi(this)
        yemekliste= yemeklistdao().tumyemekler(vt)
        adapter= YemekAdapter(this,yemekliste)
        rvy.adapter=adapter
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