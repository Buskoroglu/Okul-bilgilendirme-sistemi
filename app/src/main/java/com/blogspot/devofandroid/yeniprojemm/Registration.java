package com.blogspot.devofandroid.yeniprojemm;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    EditText mail, sifre , isim, soyisim, yenidensifre ;
    Button giris;
    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mail =(EditText) findViewById(R.id.editmail);
        sifre = (EditText) findViewById(R.id.editsifre);
        yenidensifre =(EditText) findViewById(R.id.edityenidensifre);
        isim= (EditText) findViewById(R.id.editisim);
        soyisim = (EditText) findViewById(R.id.editsoyisim);
        giris = (Button) findViewById(R.id.button3);
        db = new DBHelper(this);

        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name= isim.getText().toString();
                String surname= soyisim.getText().toString();
                String user = mail.getText().toString();
                String pass = sifre.getText().toString();
                String repass = yenidensifre.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(Registration.this, "LÜTFEN ALANLARI DOLDURUN", Toast.LENGTH_SHORT).show();
                else{
                    if(user.endsWith("@ogr.ahievran.edu.tr"))
                    {
                        if(pass.equals(repass)){
                            Boolean checkuser = db.checkusername(user);
                            if(checkuser==false){
                                Boolean insert = db.insertData(name,surname,user,pass);
                                if(insert==true){
                                    Toast.makeText(Registration.this, "KAYIT BAŞARILI", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(Registration.this, "KAYIT BAŞARISIZ", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(Registration.this, "BU MAİL ZATEN KAYITLI", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(Registration.this, "PAROLALAR EŞLEŞMİYOR", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(Registration.this,"OKUL MAİLİNİZLE KAYIT OLUN", Toast.LENGTH_SHORT).show();
                    }
                }
              }
        });
    }
}