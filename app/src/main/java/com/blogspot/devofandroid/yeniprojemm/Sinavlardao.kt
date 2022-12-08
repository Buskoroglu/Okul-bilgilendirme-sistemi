package com.blogspot.devofandroid.yeniprojemm

class Sinavlardao {

    fun tumsinavlar(vt:VeritabaniYardimcisi):ArrayList<Sinavlar>{

        val sinavliste = ArrayList<Sinavlar>()
        val db = vt.writableDatabase
        val cursor= db.rawQuery("SELECT * FROM sinavlar", null)
        while (cursor.moveToNext()){
            val sinav = Sinavlar(cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                cursor.getString(cursor.getColumnIndexOrThrow("tarih")),
                cursor.getString(cursor.getColumnIndexOrThrow("sinavisimleri")))
            sinavliste.add(sinav)
        }
        return sinavliste
    }
}