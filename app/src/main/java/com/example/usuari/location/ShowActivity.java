package com.example.usuari.location;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        DBLocation adp = new DBLocation(this);
        Cursor c = adp.recuperarCoordenadas();
        String[] columnas = new String[]{"altitud","longitud","latitud"};
        int[] vistas = new int[]{R.id.tvAltitud,R.id.tvLongitud,R.id.tvLatitud};
        SimpleCursorAdapter sc = new SimpleCursorAdapter(
                this,
                R.layout.lists_controls,
                c,
                columnas,
                vistas,
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        );
        ListView listas=(ListView) findViewById(R.id.lvLista);
        //System.out.println("999999999999999999999999"+columnas.toString());
        listas.setAdapter(sc);
        adp.close();
    }
    public void salir(View v){
        this.finish();
    }
}
