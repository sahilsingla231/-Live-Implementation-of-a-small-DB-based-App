package com.example.sahil.sahilauthenticloginregisterapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;

public class DataBase extends AppCompatActivity {
    Context context;
    SQLiteDatabase db;

    public DataBase(Context context) {
        this.context = context;
        db = context.openOrCreateDatabase("userauth",MODE_PRIVATE,null);
        db.execSQL("create table if not exists users(name char,number number, password varchar)");
    }

    void addUser(String username,String number,String pass) {

        db.execSQL("insert into users values('"+username+"','"+number+"', '"+pass+"')");
    }

    boolean checkAuth(String Name,String number, String pass) {

        Cursor c = db.rawQuery("select password from  users where number='"+number+"' and name='"+Name+"'", null);
        String orig_pswd="";

        if(c.moveToFirst()) {
            int index = c.getColumnIndex("password");

            orig_pswd = c.getString(index);
        }

        if(pass.compareTo(orig_pswd) == 0)
            return true;
        return false;

    }
}
