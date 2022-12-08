package com.blogspot.devofandroid.yeniprojemm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EtkinlikAdapter(private val context: Context, private var etkinlikliste:List<etkinlikler>) :
    RecyclerView.Adapter<EtkinlikAdapter.CardTasarime>() {

    inner class CardTasarime(tasarim: View):RecyclerView.ViewHolder(tasarim){
        var baslik: TextView
        var icerik: TextView
        init{
            baslik = tasarim.findViewById(R.id.basliketkinlik)
            icerik=tasarim.findViewById(R.id.iceriketkinlik)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EtkinlikAdapter.CardTasarime {
        val tasarim= LayoutInflater.from(context).inflate(R.layout.etkinlik_card_tasarim,parent,false)
        return CardTasarime(tasarim)
    }

    override fun getItemCount(): Int {
        return etkinlikliste.size
    }

    override fun onBindViewHolder(holder: EtkinlikAdapter.CardTasarime, position: Int) {
        val etkinlik= etkinlikliste.get(position)
        holder.baslik.text = "${etkinlik.baslik}"
        holder.icerik.text="${etkinlik.icerik}"
    }



}