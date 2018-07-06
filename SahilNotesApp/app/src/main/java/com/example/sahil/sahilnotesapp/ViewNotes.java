package com.example.sahil.sahilnotesapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewNotes extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_view);
        listView=findViewById(R.id.list_view);
        DataBase data=new DataBase(getApplicationContext());
        ArrayList<String> Notes= data.getNotes();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, Notes);
        listView.setAdapter(adapter);

    }

}
