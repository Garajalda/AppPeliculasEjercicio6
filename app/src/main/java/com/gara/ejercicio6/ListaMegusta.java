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
import java.util.ArrayList;
import java.util.List;

public class ListaMegusta extends AppCompatActivity {

    Datos datos = Datos.getInstance();

    ArrayList<Pelicula> peliculas = datos.getPelis("peliculas");
    ArrayAdapter<Pelicula> adapter;
    ArrayList<Pelicula> peliculasFav;
    ArrayList<Pelicula> peliculasDesmarcadas;


    public void pelisFav(){
        peliculasFav = new ArrayList<Pelicula>();
        peliculasDesmarcadas = new ArrayList<>();
        for(Pelicula peliculas2 : peliculas){
            if(peliculas2.getFavorita()){
                peliculasFav.add(peliculas2);
                peliculasDesmarcadas.add(peliculas2);

            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_mg,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intentDesFav = new Intent();
                intentDesFav.putExtra("DESMARCADO",peliculasDesmarcadas);
                setResult(RESULT_OK,intentDesFav);
                //onBackPressed();
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_megusta);
        getSupportActionBar().setTitle("Peliculas favoritas");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pelisFav();
        //listview
        lv= findViewById(R.id.peliculasMG);
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        adapter = new ArrayAdapter<Pelicula>(this, android.R.layout.simple_list_item_checked,peliculasFav);
        lv.setAdapter(adapter);

    }

    public void clickEliminar(MenuItem item){
        @SuppressWarnings ("unchecked")
        ArrayAdapter<String> adapter =(ArrayAdapter<String>)lv.getAdapter();
        for (int i = lv.getCount()-1; i >=0; i--){
            if(lv.isItemChecked(i)){
                //String titulo, String director, int duracion, Date fecha, String sala, int clasi, int portada

                peliculasFav.remove(i);
                peliculasDesmarcadas.get(i).setFavorita(false);
            }
        }

        lv.getCheckedItemPositions().clear();
        adapter.notifyDataSetChanged();
    }




}