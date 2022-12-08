package com.blogspot.devofandroid.yeniprojemm

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.row_list_item.view.*

class GonderiAdapteriki(var context: Context, var gList: ArrayList<Gonderi>): BaseAdapter()  {

    override fun getCount(): Int {
        return gList.size
    }

    override fun getItem(position: Int): Any {
        return gList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View
        if (convertView == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.row_list_item_iki, parent, false)
        } else {
            view = convertView
        }

        val mygonderi = gList[position]
        view.textViewGonderi.text = mygonderi.gonderi
        view.textViewisim.text=mygonderi.isim
        view.textsaat.text=mygonderi.saat
        view.texttarih.text=mygonderi.tarih



        return view
    }

    fun goToUpdate(gonderi: Gonderi) {
        val intent = Intent(context, Akademisyengonderi::class.java)
        intent.putExtra("id", gonderi.id)
        intent.putExtra("gonderi", gonderi.gonderi)
        intent.putExtra("isim",gonderi.isim)
        intent.putExtra("saat",gonderi.saat)
        intent.putExtra("tarih",gonderi.tarih)
        ContextCompat.startActivity(context, intent, null)
    }
}