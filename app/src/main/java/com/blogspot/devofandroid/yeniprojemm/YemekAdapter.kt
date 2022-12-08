package com.blogspot.devofandroid.yeniprojemm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class YemekAdapter(private val mcontext: Context, private var yemekliste:List<yemeklist>) :
    RecyclerView.Adapter<YemekAdapter.CardTasarim>() {

    inner class CardTasarim(tasarim: View):RecyclerView.ViewHolder(tasarim){
        var texttarih: TextView
        var textcorba: TextView
        var textanayemek:TextView
        var textmakarna:TextView
        var textyanurun:TextView
        init{
            texttarih = tasarim.findViewById(R.id.tarih)
            textcorba=tasarim.findViewById(R.id.corba)
            textanayemek=tasarim.findViewById(R.id.anayemek)
            textmakarna=tasarim.findViewById(R.id.makarna)
            textyanurun=tasarim.findViewById(R.id.yanurun)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YemekAdapter.CardTasarim {
        val tasarim= LayoutInflater.from(mcontext).inflate(R.layout.yemek_card_tasarim,parent,false)
        return CardTasarim(tasarim)
    }

    override fun onBindViewHolder(holder:YemekAdapter.CardTasarim, position: Int) {
        val yemek= yemekliste.get(position)
        holder.texttarih.text="${yemek.tarih}"
        holder.textcorba.text="${yemek.corba}"
        holder.textanayemek.text="${yemek.anayemek}"
        holder.textmakarna.text="${yemek.makarna}"
        holder.textyanurun.text="${yemek.yanurun}"
    }

    override fun getItemCount(): Int {
     return  yemekliste.size
    }
}