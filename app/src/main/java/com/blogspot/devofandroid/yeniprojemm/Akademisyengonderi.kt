package com.blogspot.devofandroid.yeniprojemm


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_listeleme.*

class Akademisyengonderi : AppCompatActivity() {
    var gList = ArrayList<Gonderi>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_akademisyengonderi)

    }

    fun loadData() {
        val database = DBHelperg(this)
        gList = database.getAll()
        val gAdapter = GonderiAdapteriki(this, gList)
        listView.adapter = gAdapter
    }
    override fun onResume() {
        super.onResume()
        loadData()
    }
    }