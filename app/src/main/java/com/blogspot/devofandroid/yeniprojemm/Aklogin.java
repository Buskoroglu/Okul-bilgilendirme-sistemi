package com.blogspot.devofandroid.yeniprojemm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Aklogin extends AppCompatActivity {
    EditText mailim, sifrem;
    Button btnlogin, btnkayit;
    DBHelperiki DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aklogin);
        mailim = (EditText) findViewById(R.id.mailgirisak);
        sifrem = (EditText) findViewById(R.id.sifregirisak);
        btnlogin = (Button) findViewById(R.id.girisyapak);
        btnkayit = (Button) findViewById(R.id.buttonaklogin);
        DB = new DBHelperiki(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mailim.getText().toString();
                String pass = sifrem.getText().toString();
                if (email.equals("") || pass.equals(""))
                    Toast.makeText(Aklogin.this, "Lütfen alanları giriniz", Toast.LENGTH_LONG).show();
                else {
                    Boolean checkuserpass = DB.checkusernamepassword(email, pass);
                    if (checkuserpass == true) {
                        if (email.endsWith("@ahievran.edu.tr")) {
                            Intent intent = new Intent(Aklogin.this, Akademisyennavigation.class);
                            intent.putExtra("mail",email);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(Aklogin.this, "Lütfen okul mailiniz ile giriniz", Toast.LENGTH_LONG).show();
                        }
                    }
                    else {
                        Toast.makeText(Aklogin.this, "Mail veya şifre hatalı.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

       btnkayit.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Aklogin.this, Registerak.class);
            startActivity(intent);
        }
       });
    }
}