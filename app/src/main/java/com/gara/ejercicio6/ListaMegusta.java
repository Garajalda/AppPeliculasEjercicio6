package com.gara.ejercicio6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ListaMegusta extends AppCompatActivity {

    Datos datos = Datos.getInstance();

    ArrayList<Pelicula> peliculas = datos.getPelis("peliculas");
    ArrayList<Pelicula> peliculasFav = new ArrayList<>();
    ArrayAdapter<Pelicula> adapter;


    ListView lv;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intentFav = new Intent();

                intentFav.putExtra("PELICULAS",peliculasFav);
                setResult(RESULT_OK,intentFav);
                finish();
                //onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_megusta);
        getSupportActionBar().setTitle("Peliculas favoritas");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //listview
        lv= findViewById(R.id.peliculasMG);

        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);



        adapter = new ArrayAdapter<Pelicula>(this, android.R.layout.simple_list_item_checked,peliculas);
        lv.setAdapter(adapter);



        for(int i = 0; i < peliculas.size(); i++){

            if(peliculas.get(i).getFavorita()){
                lv.setItemChecked(i,true);

            }

        }

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(!lv.isItemChecked(i)){
                    peliculas.get(i).setFavorita(false);
                }else{

                    peliculas.get(i).setFavorita(true);
                }

                Toast.makeText(getApplicationContext(), i+"", Toast.LENGTH_SHORT).show();
                peliculasFav.add(peliculas.get(i));



            }
        });

    }


    /*public void clickEliminar(MenuItem item){
        @SuppressWarnings ("unchecked")
        ArrayAdapter<String> adapter =(ArrayAdapter<String>)lv.getAdapter();
        for (int i = lv.getCount()-1; i >=0; i--){
            if(lv.isItemChecked(i)){
                //String titulo, String director, int duracion, Date fecha, String sala, int clasi, int portada

                peliculas.remove(i);

            }


        }

        lv.getCheckedItemPositions().clear();
        adapter.notifyDataSetChanged();
    }*/




}