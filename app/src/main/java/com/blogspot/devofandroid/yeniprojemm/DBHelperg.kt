package com.blogspot.devofandroid.yeniprojemm

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

val database_name="Gonderiler.db"
val table_name="gonderiler"
val col_id="id"
val col_gonderi="gonderi"
val col_isim="isim"
val col_tarih="date"
val col_saat="saat"
class DBHelperg (var context: Context): SQLiteOpenHelper(context,database_name,null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE \"gonderiler\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL,\n" +
                "\t\"gonderi\"\tTEXT NOT NULL,\n" +
                "\t\"isim\"\tTEXT NOT NULL,\n" +
                "\t\"date\"\tTEXT NOT NULL,\n" +
                "\t\"saat\"\tTEXT NOT NULL,\n" +
                "\tPRIMARY KEY(\"id\")\n" +
                ");"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + table_name)
        onCreate(db)
    }

    fun insert(gonderi : Gonderi) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(col_gonderi, gonderi.gonderi)
        values.put(col_isim,gonderi.isim)
        values.put(col_tarih,gonderi.tarih)
        values.put(col_saat,gonderi.saat)
        db.insert(table_name, null, values)
        db.close()
    }

    fun getAllkisi(isim:String): ArrayList<Gonderi> {
        val list = ArrayList<Gonderi>()
        val db = this.readableDatabase
        val cursor = db.rawQuery("Select * from gonderiler where isim = ?", arrayOf(isim),null)
        while (cursor.moveToNext()) {
            val gonderi = Gonderi()
            gonderi.id = cursor.getInt(cursor.getColumnIndexOrThrow(col_id))
            gonderi.gonderi = cursor.getString(cursor.getColumnIndexOrThrow(col_gonderi))
            gonderi.isim=cursor.getString(cursor.getColumnIndexOrThrow(col_isim))
            gonderi.tarih=cursor.getString(cursor.getColumnIndexOrThrow(col_tarih))
            gonderi.saat= cursor.getString(cursor.getColumnIndexOrThrow(col_saat))
            list.add(gonderi)
        }
        db.close()
        return list
    }



    fun getAll(): ArrayList<Gonderi> {
        val list = ArrayList<Gonderi>()
        val db = this.readableDatabase
        val query = "SELECT * FROM " + table_name
        val cursor = db.rawQuery(query, null)

        while (cursor.moveToNext()) {
            val gonderi = Gonderi()
            gonderi.id = cursor.getInt(cursor.getColumnIndexOrThrow(col_id))
            gonderi.gonderi = cursor.getString(cursor.getColumnIndexOrThrow(col_gonderi))
            gonderi.isim=cursor.getString(cursor.getColumnIndexOrThrow(col_isim))
            gonderi.tarih=cursor.getString(cursor.getColumnIndexOrThrow(col_tarih))
            gonderi.saat= cursor.getString(cursor.getColumnIndexOrThrow(col_saat))
            list.add(gonderi)
        }
        db.close()
        return list
    }


     fun update(gonderi: Gonderi) {
        val db = this.writableDatabase
        val values = ContentValues()
         values.put(col_gonderi,gonderi.gonderi)
         values.put(col_isim,gonderi.isim)
         values.put(col_tarih,gonderi.tarih)
         values.put(col_saat,gonderi.saat)
        db.update(table_name, values, "id=?", arrayOf(gonderi.id.toString()))
        db.close()
    }

    fun delete(id: Int) {
        val db = this.writableDatabase
        db.delete(table_name, "id=?", arrayOf(id.toString()))
        db.close()
    }

}