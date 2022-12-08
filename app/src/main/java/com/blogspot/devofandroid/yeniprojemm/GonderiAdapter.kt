package com.blogspot.devofandroid.yeniprojemm

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_adding_gonderi.view.*
import kotlinx.android.synthetic.main.row_list_item.view.*

class GonderiAdapter(var context: Context, var gList: ArrayList<Gonderi>): BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View
        if (convertView == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.row_list_item, parent, false)
        } else {
            view = convertView
        }

        val mygonderi = gList[position]
        view.textViewGonderi.text = mygonderi.gonderi
        view.textViewisim.text=mygonderi.isim
        view.textsaat.text=mygonderi.saat
        view.texttarih.text=mygonderi.tarih
        val isim=view.textViewisim.text
        view.imageViewUpdate.setOnClickListener {
            goToUpdate(mygonderi)
            notifyDataSetChanged()
        }

        view.imageViewDelete.setOnClickListener {
            val database = DBHelperg(context)
            database.delete(mygonderi.id)
            gList = database.getAllkisi(isim as String)
            notifyDataSetChanged()
        }
        return view
    }

    override fun getItem(position: Int): Any {
        return gList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return gList.size
    }

    fun goToUpdate(gonderi: Gonderi) {
        val intent = Intent(context, Adding_gonderi::class.java)

        intent.putExtra("id", gonderi.id)
        intent.putExtra("gonderi", gonderi.gonderi)
        intent.putExtra("isim",gonderi.isim)
        intent.putExtra("saat",gonderi.saat)
        intent.putExtra("tarih",gonderi.tarih)
        startActivity(context, intent, null)
    }
}