package com.blogspot.devofandroid.yeniprojemm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DBHelperiki extends SQLiteOpenHelper {

    public static final String DBNAME = "akademi.db";
    public DBHelperiki(Context context) {
        super(context, "academy.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table academy(mail TEXT primary key, password TEXT, name TEXT, surname TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists academy");
    }



    public Boolean insertData(String name, String surname,String mail, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("name",name);
        contentValues.put("surname",surname);
        contentValues.put("mail", mail);
        contentValues.put("password", password);
        long result = MyDB.insert("academy", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public void updateData(String mail,String name,String surname,String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("mail",mail);
        contentValues.put("name",name);
        contentValues.put("surname",surname);
        contentValues.put("password",password);
        db.update("academy", contentValues, "mail = ?",new String[] { mail });
    }

    public Boolean checkusername(String mail) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from academy where mail = ?", new String[]{mail});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public String erisim(String mail)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        String  kisi ="";
        Cursor cursor = DB.rawQuery("Select * from academy where mail = ?", new String[]{mail});
        if(cursor.getCount()>0) {
            while (cursor.moveToNext()) {
                kisi = cursor.getString(cursor.getColumnIndexOrThrow("name")) + " "+ cursor.getString(cursor.getColumnIndexOrThrow("surname"));
            }
        }
        return kisi;
    }

    public String erisimisim(String mail)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        String isim ="";
        Cursor cursor = DB.rawQuery("Select * from academy where mail = ?", new String[]{mail});
        if(cursor.getCount()>0) {
            while (cursor.moveToNext()) {
                isim = cursor.getString(cursor.getColumnIndexOrThrow("name")) ;
            }
        }
        return isim;
    }

    public String erisimsisim(String mail)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        String isim ="";
        Cursor cursor = DB.rawQuery("Select * from academy where mail = ?", new String[]{mail});
        if(cursor.getCount()>0) {
            while (cursor.moveToNext()) {
                isim = cursor.getString(cursor.getColumnIndexOrThrow("surname")) ;
            }
        }
        return isim;
    }

    public String erisimpassword(String mail)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        String isim ="";
        Cursor cursor = DB.rawQuery("Select * from academy where mail = ?", new String[]{mail});
        if(cursor.getCount()>0) {
            while (cursor.moveToNext()) {
                isim = cursor.getString(cursor.getColumnIndexOrThrow("password")) ;
            }
        }
        return isim;
    }


    public Boolean checkusernamepassword(String mail, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from academy where mail = ? and password = ?", new String[] {mail,password});
        if(cursor.getCount()>0)
        {
            return true;
        }

        else
            return false;
    }
}
