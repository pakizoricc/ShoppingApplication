package com.example.myshoppingapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseCart extends SQLiteOpenHelper {

    public static final String dbName = "Proizvodi.db";

    public DatabaseCart(@Nullable Context context){super(context, "Proizvodi.db", null, 1);}
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Products(email TEXT primary key, " +
                "firstname TEXT, " +
                "lastname TEXT, " +
                "size_of_cloth TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Products");
    }

    public Boolean insertProduct(String email, String firstname, String lastname, String size_of_cloth){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("firstname", firstname);
        contentValues.put("lastname", lastname);
        contentValues.put("size_of_cloth", size_of_cloth);
        long result = sqLiteDatabase.insert("Products", null, contentValues);

        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
}
