package com.example.gnanesh.hotelmgmt;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDb extends SQLiteOpenHelper {

    public static final String DBname="myDb";
    public static final int DBversion=1;
    public MyDb(Context context) {
        super(context, DBname, null, DBversion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String customerTable="CREATE TABLE Customer(name VARCHAR, username VARCHAR,pass VARCHAR,gender VARCHAR);";
        String rooms="CREATE TABLE rooms(room_no VARCHAR,name VARCHAR,startDate VARCHAR,no_of_days VARCHAR);";
        db.execSQL(customerTable);
        db.execSQL(rooms);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
