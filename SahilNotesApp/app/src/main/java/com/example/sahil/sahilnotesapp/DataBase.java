package com.example.sahil.sahilnotesapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class DataBase  {

    Context context;
    SQLiteDatabase data;

    public DataBase(Context context) {
        this.context = context;
        data = context.openOrCreateDatabase("noteDB",Context.MODE_PRIVATE,null);
    }

    void AddNote(String notes){

        try {

            data.execSQL("create table if not exists noteList (text VARCHAR)");


            data.execSQL("insert into noteList values('" + notes + "')");

            Toast.makeText(context, "Notes added successfully :-)", Toast.LENGTH_SHORT).show();


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    ArrayList<String> getNotes() {

        ArrayList<String> notes = new ArrayList<>();
        try{

            Cursor c = data.rawQuery("SELECT * FROM noteList",null);
            if(c.moveToFirst()) {
                do {
                    int index = c.getColumnIndex("text");

                    String note = c.getString(index);
                    notes.add(note);
                } while (c.moveToNext());
                Toast.makeText(context, "Notes got successfully :-)", Toast.LENGTH_LONG).show();
            }
        }catch(Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "No notes Available :-)", Toast.LENGTH_LONG).show();
        }

        return  notes;
    }
}
