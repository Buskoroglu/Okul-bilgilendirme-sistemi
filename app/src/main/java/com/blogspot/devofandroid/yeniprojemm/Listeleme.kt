package com.blogspot.devofandroid.yeniprojemm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_adding_gonderi.*
import kotlinx.android.synthetic.main.activity_listeleme.*
import kotlinx.android.synthetic.main.row_list_item.*
import kotlinx.android.synthetic.main.row_list_item.view.*

class Listeleme : AppCompatActivity() {
    var gList = ArrayList<Gonderi>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listeleme)
        val x=intent.getStringExtra("mail")
        val y=intent.getStringExtra("isim")
        textView11.text=y
        textView24.text=x
    }

    fun goToAdd(view: View) {
        val intent = Intent(this, Adding_gonderi::class.java)
        intent.putExtra("isim",textView11.text)
        startActivity(intent)
    }
    fun loadData() {
        val database = DBHelperg(this)
        gList = database.getAllkisi(textView11.text as String)
        val gAdapter = GonderiAdapter(this, gList)
        listView.adapter = gAdapter
    }
    override fun onResume() {
        super.onResume()
        loadData()
    }
}