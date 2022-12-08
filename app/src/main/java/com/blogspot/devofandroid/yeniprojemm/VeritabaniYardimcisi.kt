package com.blogspot.devofandroid.yeniprojemm

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class VeritabaniYardimcisi(context: Context) : SQLiteOpenHelper(context, "Okulumuz.sqlite", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE IF NOT EXISTS \"duyurular\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL,\n" +
                "\t\"baslik\"\tTEXT NOT NULL,\n" +
                "\t\"icerik\"\tTEXT NOT NULL,\n" +
                "\tPRIMARY KEY(\"id\")\n" +
                ");")

        db?.execSQL("CREATE TABLE IF NOT EXISTS \"etkinlikler\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL,\n" +
                "\t\"baslik_etkinlik\"\tTEXT NOT NULL,\n" +
                "\t\"icerik_etkinlik\"\tTEXT NOT NULL,\n" +
                "\tPRIMARY KEY(\"id\")\n" +
                ");")

        db?.execSQL("CREATE TABLE IF NOT EXISTS \"sinavlar\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL,\n" +
                "\t\"tarih\"\tTEXT NOT NULL,\n" +
                "\t\"sinavisimleri\"\tTEXT NOT NULL,\n" +
                "\tPRIMARY KEY(\"id\")\n" +
                ");")

        db?.execSQL("CREATE TABLE IF NOT EXISTS \"yemek\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL,\n" +
                "\t\"tarih\"\tTEXT NOT NULL,\n" +
                "\t\"corba\"\tTEXT NOT NULL,\n" +
                "\t\"anayemek\"\tTEXT NOT NULL,\n" +
                "\t\"makarna\"\tTEXT NOT NULL,\n" +
                "\t\"yanurun\"\tTEXT NOT NULL,\n" +
                "\tPRIMARY KEY(\"id\")\n" +
                ");")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        db?.execSQL("DROP TABLE IF EXISTS duyurular")
        db?.execSQL("DROP TABLE IF EXISTS etkinlikler")
        db?.execSQL("DROP TABLE IF EXISTS sinavlar")
        db?.execSQL("DROP TABLE IF EXISTS yemek")
        onCreate(db)

    }


}