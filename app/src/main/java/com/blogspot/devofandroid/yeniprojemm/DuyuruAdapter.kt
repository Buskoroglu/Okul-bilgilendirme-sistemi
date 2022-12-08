package com.blogspot.devofandroid.yeniprojemm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DuyuruAdapter(private val mcontext:Context, private var duyuruliste:List<duyurular>) :
    RecyclerView.Adapter<DuyuruAdapter.CardTasarim>() {

    inner class CardTasarim(tasarim:View):RecyclerView.ViewHolder(tasarim){
     var textbaslik:TextView
     var texticerik:TextView
     init{
         textbaslik = tasarim.findViewById(R.id.baslik)
         texticerik=tasarim.findViewById(R.id.icerik)
     }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarim {
       val tasarim=LayoutInflater.from(mcontext).inflate(R.layout.duyuru_card_tasarim,parent,false)
        return CardTasarim(tasarim)
    }

    override fun getItemCount(): Int {
        return duyuruliste.size
    }

    override fun onBindViewHolder(holder: CardTasarim, position: Int) {
       val duyuru= duyuruliste.get(position)
        holder.textbaslik.text = "${duyuru.baslik}"
        holder.texticerik.text="${duyuru.icerik}"
    }


}