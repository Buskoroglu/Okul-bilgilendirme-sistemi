package com.blogspot.devofandroid.yeniprojemm


class duyurulardao {

    fun tumduyurular(vt:VeritabaniYardimcisi):ArrayList<duyurular>{

        val duyuruliste = ArrayList<duyurular>()
        val db = vt.writableDatabase
        val cursor= db.rawQuery("SELECT * FROM duyurular", null)
        while (cursor.moveToNext()){
            val duyuru = duyurular(cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                cursor.getString(cursor.getColumnIndexOrThrow("baslik")),
                cursor.getString(cursor.getColumnIndexOrThrow("icerik")))
            duyuruliste.add(duyuru)
        }
        return duyuruliste
    }
}