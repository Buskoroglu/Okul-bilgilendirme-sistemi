package com.blogspot.devofandroid.yeniprojemm;

import static com.blogspot.devofandroid.yeniprojemm.R.id.mailak;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registerak extends AppCompatActivity {
    EditText mail, sifre , isim, soyisim, yenidensifre ;
    Button giris;
    DBHelperiki db;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerak);
        mail =(EditText) findViewById(R.id.mailak);
        sifre = (EditText) findViewById(R.id.sifreak);
        yenidensifre =(EditText) findViewById(R.id.yenidensifreak);
        isim= (EditText) findViewById(R.id.isimak);
        soyisim = (EditText) findViewById(R.id.soyisimak);
        giris = (Button) findViewById(R.id.buttonak);
        db = new DBHelperiki(this);

        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name= isim.getText().toString();
                String surname= soyisim.getText().toString();
                String user = mail.getText().toString();
                String pass = sifre.getText().toString();
                String repass = yenidensifre.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(Registerak.this, "LÜTFEN ALANLARI DOLDURUN", Toast.LENGTH_SHORT).show();
                else{
                       if(user.endsWith("@ahievran.edu.tr"))
                       {
                           if(pass.equals(repass)){
                               Boolean checkuser = db.checkusername(user);
                               if(checkuser==false){
                                   Boolean insert = db.insertData(name,surname,user,pass);
                                   if(insert==true){
                                       Toast.makeText(Registerak.this, "KAYIT BAŞARILI", Toast.LENGTH_SHORT).show();
                                       Intent intent = new Intent(getApplicationContext(),Akademisyennavigation.class);
                                       startActivity(intent);
                                   }else{
                                       Toast.makeText(Registerak.this, "KAYIT BAŞARISIZ", Toast.LENGTH_SHORT).show();
                                   }
                               }
                               else{
                                   Toast.makeText(Registerak.this, "BU MAİL ZATEN KAYITLI", Toast.LENGTH_SHORT).show();
                               }
                           }else{
                               Toast.makeText(Registerak.this, "PAROLALAR EŞLEŞMİYOR", Toast.LENGTH_SHORT).show();
                           }
                       }
                       else
                       {
                           Toast.makeText(Registerak.this,"OKUL MAİLİNİZLE KAYIT OLUN", Toast.LENGTH_SHORT).show();
                       }
                } }
        });
    }
}