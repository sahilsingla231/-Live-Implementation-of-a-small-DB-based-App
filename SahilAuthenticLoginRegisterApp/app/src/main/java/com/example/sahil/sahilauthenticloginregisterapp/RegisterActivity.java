package com.example.sahil.sahilauthenticloginregisterapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.*;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        final Button Login=findViewById(R.id.Login);
        Button Signup=findViewById(R.id.Signup);
        final EditText name=findViewById(R.id.Name);
        final EditText number=findViewById(R.id.Number);
        final EditText email=findViewById(R.id.Email);
        final EditText password=findViewById(R.id.Password);
        final EditText verifyPass=findViewById(R.id.VerifyPass);
        final DataBase db=new DataBase(getApplicationContext());

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((password.getText().toString()).equals(verifyPass.getText().toString()))==false)
                {
                    Toast.makeText(RegisterActivity.this,"Please enter the same password in verifying box",Toast.LENGTH_LONG).show();
                }
                else if(((name.getText().toString()).compareTo("")!=0)&&
                        ((number.getText().toString()).compareTo("")!=0)&&
                        ((email.getText().toString()).compareTo("")!=0)&&
                        ((password.getText().toString()).compareTo("")!=0))
                {
                    String Name=name.getText().toString();
                    String Number=number.getText().toString();
                    String Password=password.getText().toString();
                    db.addUser(Name,Number,Password);
                    Toast.makeText(RegisterActivity.this,"Signed up Scessfully",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                    Toast.makeText(RegisterActivity.this,"Please Fill the All Fields.",Toast.LENGTH_LONG).show();
                 }
        });
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this,LogIn.class);
                startActivity(intent);
            }
        });
    }
}
