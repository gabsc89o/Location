package com.example.usuari.location;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by usuari on 26/03/2018.
 */

public class DBLocation {
    private SQLiteDatabase db=null;
    private SQLite dbhelper=null;
    Context context;
    public DBLocation(Context ctx){
        this.context = ctx;
        dbhelper = new SQLite(context);
        db = dbhelper.getWritableDatabase();
    }
    public void close(){
        dbhelper.close();
    }
    public  long altaCoordenada(String altitud, String longitud, String latitud){
        ContentValues initialValues = new ContentValues();
        initialValues.put("altitud",altitud);
        initialValues.put("longitud",longitud);
        initialValues.put("latitud",latitud);
        return db.insert("coordenadas",null,initialValues);
    }
    public Cursor recuperarCoordenadas(){
        return db.query("coordenadas", new String[]{"_id","altitud","longitud","latitud"},null,null,null,null,null);
    }
}
