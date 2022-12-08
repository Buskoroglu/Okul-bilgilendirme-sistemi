package com.blogspot.devofandroid.yeniprojemm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SinavAdapter(private val mcontext: Context, private var sinavliste:List<Sinavlar>) : RecyclerView.Adapter<SinavAdapter.CardTasarim>()  {

    inner class CardTasarim(tasarim: View): RecyclerView.ViewHolder(tasarim){
        var sinavtarih: TextView
        var sinavisimleri: TextView
        init{
            sinavtarih = tasarim.findViewById(R.id.sinavtarih)
            sinavisimleri=tasarim.findViewById(R.id.sinavisimleri)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarim {
        val tasarim= LayoutInflater.from(mcontext).inflate(R.layout.sinav_card_tasarim,parent,false)
        return CardTasarim(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarim, position: Int) {
        val sinav= sinavliste.get(position)
        holder.sinavtarih.text = "${sinav.tarih}"
        holder.sinavisimleri.text="${sinav.sinavisimleri}"
    }

    override fun getItemCount(): Int {
       return sinavliste.size
    }
}