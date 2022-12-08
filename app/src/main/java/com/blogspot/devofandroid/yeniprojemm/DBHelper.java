package com.blogspot.devofandroid.yeniprojemm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "User.db";
    public DBHelper(Context context) {
        super(context, "User.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table users(mail TEXT primary key, password TEXT, name TEXT, surname TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists users");

    }
    public String[] erisim(String mail)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        String [] kisi = new String[2];
        Cursor cursor = DB.rawQuery("Select * from users where mail = ?", new String[]{mail});
        if(cursor.getCount()>0) {
            while (cursor.moveToNext()) {
                kisi[0] = cursor.getString(cursor.getColumnIndexOrThrow("name")) ;
                kisi[1] =cursor.getString(cursor.getColumnIndexOrThrow("surname"));
            }
        }
        return kisi;
    }

    public String erisimisim(String mail)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        String isim ="";
        Cursor cursor = DB.rawQuery("Select * from users where mail = ?", new String[]{mail});
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
        Cursor cursor = DB.rawQuery("Select * from users where mail = ?", new String[]{mail});
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
        Cursor cursor = DB.rawQuery("Select * from users where mail = ?", new String[]{mail});
        if(cursor.getCount()>0) {
            while (cursor.moveToNext()) {
                isim = cursor.getString(cursor.getColumnIndexOrThrow("password")) ;
            }
        }
        return isim;
    }
    public Boolean insertData(String name,String surname,String mail, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("name",name);
        contentValues.put("surname",surname);
        contentValues.put("mail", mail);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
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
        db.update("users", contentValues, "mail = ?",new String[] { mail });
    }


    public Boolean checkusername(String mail) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where mail = ?", new String[]{mail});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
    public Boolean checkusernamepassword(String mail, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where mail = ? and password = ?", new String[] {mail,password});


        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
