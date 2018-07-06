package com.example.sahil.sahilauthenticloginregisterapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.*;

public class LogIn extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        final Button Login=findViewById(R.id.Login);
        Button Signup=findViewById(R.id.Signup);
        final EditText name=findViewById(R.id.name);
        final EditText number=findViewById(R.id.Number);
        final  EditText password=findViewById(R.id.Password);
        final DataBase db=new DataBase(getApplicationContext());
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(db.checkAuth(name.getText().toString(),number.getText().toString(),password.getText().toString() ))
                {
                    Intent i = new Intent(LogIn.this, Last.class);
                    i.putExtra("UserName",name.getText().toString());
                    startActivity(i);
                    finish();
                }
                  else
                    Toast.makeText(LogIn.this,"Enter Valid Details",Toast.LENGTH_LONG).show();

            }
        });

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LogIn.this,RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }


}
