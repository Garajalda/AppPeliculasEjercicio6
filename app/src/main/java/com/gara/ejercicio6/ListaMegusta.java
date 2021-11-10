package com.gara.ejercicio6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaMegusta extends AppCompatActivity {

    Datos datos = Datos.getInstance();

    ArrayList<Pelicula> peliculas = datos.getPelis("peliculas");
    ArrayAdapter<Pelicula> adapter;
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_lista_megusta);
        ListView lv = findViewById(R.id.peliculasMG);
        getSupportActionBar().setTitle("Peliculas favoritas");
        adapter = new ArrayAdapter<Pelicula>(this, android.R.layout.simple_list_item_1,peliculas);
//        for(Pelicula peliculas : peliculas){
//
//            adapter.addAll(peliculas.titulo);
//        }
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long id) {
                // Se obtiene los datos de la fila del ListView seleccionada de dos formas diferentes
                Toast.makeText(getApplicationContext(), adapter.getItem(posicion)+"\n", Toast.LENGTH_SHORT).show();
            }
        });


    }



}