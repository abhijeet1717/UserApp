package com.example.userapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    EditText e1, e2;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        e1 = findViewById(R.id.editTextTextEmailAddress2);
        e2 = findViewById(R.id.editTextTextPassword2);
        b2 = findViewById(R.id.button2);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString() ;
                String s2=e2.getText().toString();
                if(s1.equals("") || s2.equals("")){
                    Toast.makeText(SignUp.this, "Pls mark all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    SQLiteDatabase data =openOrCreateDatabase("databasename",MODE_PRIVATE,null);
                    data.execSQL("create table if not exists syndicate (email varchar,password varchar) ");
                    String s3="select * from syndicate where email='"+s1+"' and password='"+s2+"'";
                    Cursor c1=data.rawQuery(s3,null);
                    if(c1.getCount()>0){
                        Toast.makeText(SignUp.this, "User already exists", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        data.execSQL("insert into syndicate values ('"+s1+"' , '"+s2+"')");
                        Toast.makeText(SignUp.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                        Intent j = new Intent(SignUp.this,MainActivity.class);
                        startActivity(j);
                        finish();
                    }
                }
            }
        });
    }
}