package com.blogspot.devofandroid.yeniprojemm;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
 EditText mailim, sifrem;
 Button btnlogin,btnkayit;
 DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mailim= (EditText) findViewById(R.id.mailgirisak);
        sifrem=(EditText) findViewById(R.id.sifregirisak);
        btnlogin=(Button) findViewById(R.id.ogrgiris);
        btnkayit=(Button) findViewById(R.id.buttonlogin);
        DB = new DBHelper(this);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = mailim.getText().toString();
                String pass = sifrem.getText().toString();
                String[] x = DB.erisim(email.toString());

                if(email.equals("")||pass.equals(""))
                    Toast.makeText(Login.this, "Lütfen alanları giriniz", Toast.LENGTH_LONG).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(email, pass);
                    if(checkuserpass==true){

                        if(email.endsWith("@ogr.ahievran.edu.tr")){
                            Intent intent  = new Intent(Login.this,NavigationDrawer.class);
                            intent.putExtra("isim",email);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(Login.this, "Lütfen okul mailiniz ile giriniz",Toast.LENGTH_LONG).show();
                        }
                    }
                    else{
                        Toast.makeText(Login.this, "Mail veya şifre hatalı.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        btnkayit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Registration.class);
                startActivity(intent);
            }
        });

    }
}