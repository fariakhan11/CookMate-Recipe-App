package com.example.cookmate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry1 = "create table users(username text, email text, password text, contact text)";
        db.execSQL(qry1);

        String qry2 = "create table favorite(username text, recn text)";
        db.execSQL(qry2);

        String qry3 = "create table addrecipe(recn text, detail text)";
        db.execSQL(qry3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void register(String username, String email, String password, String contact) {
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("email", email);
        cv.put("password", password);
        cv.put("contact", contact);
        SQLiteDatabase db2 = getWritableDatabase();
        db2.insert("users", null, cv);
        db2.close();
    }

    public int login(String username, String password) {
        int result = 0;
        String[] str = new String[2];
        str[0] = username;
        str[1] = password;

        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from users where username=? and password=?", str);

        if (c.moveToNext()) {
            result = 1;
        }

        return result;
    }
    public void addFav(String username, String recipename){
        ContentValues cv = new ContentValues();
        cv.put("username",username);
        cv.put("recn", recipename);

        SQLiteDatabase db = getWritableDatabase();
        db.insert("favorite",null, cv);
        db.close();
    }
    public int checkFav(String username, String recipename){
        int result = 0;
        String str[] = new String[2];
        str[0] = username;
        str[1] = recipename;

        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from favorite where username=? and recn=?", str);
        if (c.moveToNext()){
            result = 1;
        }
        db.close();
        return  result;
    }
    public String getFavoriteRecipe(String username){
        String arr=null;
        SQLiteDatabase db = getReadableDatabase();
        String str[] = new String[1];
        str[0] = username;

        Cursor c = db.rawQuery("select * from favorite where username = ?", str);
        if (c.moveToFirst()){
            do {
                //String usernamee = c.getString(0);
                String recipename = c.getString(1);
                arr=recipename;
            }
            while (c.moveToNext());
        }
        db.close();
        return arr;
    }
    public void addrecipe(String recipename, String details) {
        ContentValues cv = new ContentValues();
        cv.put("recn", recipename);
        cv.put("detail", details);
        SQLiteDatabase db2 = getWritableDatabase();
        db2.insert("addrecipe", null, cv);
        db2.close();
    }
    public ArrayList showrecipe(){
        ArrayList<String> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from addrecipe;", null);
        if (c.moveToFirst()){
            do {
                arr.add(c.getString(1) + "$" + c.getString(2));
            }while (c.moveToNext());
        }
        db.close();
        return arr;
    }
}