package com.example.sahil.sahilnotesapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNotes extends AppCompatActivity {

    Button addText;
    EditText Text;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Text=findViewById(R.id.typeText);
        addText=findViewById(R.id.addNotes);

        addText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBase data=new DataBase(getApplicationContext());
                data.AddNote(Text.getText().toString());
                Text.setText("");

            }
        });



    }
}
