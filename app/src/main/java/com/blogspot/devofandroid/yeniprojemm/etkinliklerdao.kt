package com.blogspot.devofandroid.yeniprojemm

class etkinliklerdao {

    fun tumetkinlikler(vt:VeritabaniYardimcisi):ArrayList<etkinlikler>{

        val etkinlikliste = ArrayList<etkinlikler>()
        val db = vt.writableDatabase
        val cursor= db.rawQuery("SELECT * FROM etkinlikler", null)
        while (cursor.moveToNext()){
            val etkin = etkinlikler(cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                cursor.getString(cursor.getColumnIndexOrThrow("baslik_etkinlik")),
                cursor.getString(cursor.getColumnIndexOrThrow("icerik_etkinlik")))
            etkinlikliste.add(etkin)
        }
        return etkinlikliste
    }
}