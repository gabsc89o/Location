package com.example.usuari.location;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by usuari on 26/03/2018.
 */

public class SQLite extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Libreria";
    private static final int DATABASE_VERSION=1;
    public SQLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        createTables(sqLiteDatabase);
    }

    private void createTables(SQLiteDatabase db) {
        db.execSQL("create table coordenadas (_id integer primary key autoincrement,altitud text not null, longitud text not null, latitud text not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        deleteTables(sqLiteDatabase);
        createTables(sqLiteDatabase);
    }

    private void deleteTables(SQLiteDatabase db) {
        db.execSQL("drop table if exists coordenadas");
    }
}