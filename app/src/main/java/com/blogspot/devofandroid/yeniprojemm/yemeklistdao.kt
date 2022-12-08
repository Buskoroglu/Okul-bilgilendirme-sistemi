package com.blogspot.devofandroid.yeniprojemm

class yemeklistdao {

    fun tumyemekler(vt:VeritabaniYardimcisi):ArrayList<yemeklist>{

        val yemekliste = ArrayList<yemeklist>()
        val db = vt.writableDatabase
        val cursor= db.rawQuery("SELECT * FROM yemek", null)
        while (cursor.moveToNext()){
            val yemegim = yemeklist(cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                cursor.getString(cursor.getColumnIndexOrThrow("tarih")),
                cursor.getString(cursor.getColumnIndexOrThrow("corba")),
                cursor.getString(cursor.getColumnIndexOrThrow("anayemek")),
                cursor.getString(cursor.getColumnIndexOrThrow("makarna")),
                cursor.getString(cursor.getColumnIndexOrThrow("yanurun")))
            yemekliste.add(yemegim)
        }
        return yemekliste
    }
}
