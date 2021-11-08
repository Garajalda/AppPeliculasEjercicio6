package com.gara.ejercicio6;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoPeliculas extends AppCompatActivity {



    //funcion q permite hacer la pulsacion hacia atrás actionbar <-
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void watchYoutubeVideo(String id){
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
        Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + id));
        try {
            startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            startActivity(webIntent);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_peliculas);

        //activar pulsacion atrás actionbar <-
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        //recibo datos de la principal
        final Intent intentRecibidoDePrincipal = getIntent();

        //titulo
        final TextView titulo = findViewById(R.id.titulo);
        titulo.setText(intentRecibidoDePrincipal.getStringExtra("TITULO"));

        //portada
        final ImageView portada = findViewById(R.id.portada);
        portada.setImageResource(intentRecibidoDePrincipal.getIntExtra("PORTADA",0));
        //clasificacion
        final ImageView clasi = findViewById(R.id.clasificacion);
        clasi.setImageResource(intentRecibidoDePrincipal.getIntExtra("CLASIFICACION",0));

        //DIRECTOR
        final TextView director = findViewById(R.id.director);
        director.setText(intentRecibidoDePrincipal.getStringExtra("DIRECTOR"));

        //sinopsis
        final TextView sinopsis = findViewById(R.id.sinopsis);
        sinopsis.setText(intentRecibidoDePrincipal.getStringExtra("SINOPSIS"));

        //FECHA
        final TextView fecha = findViewById(R.id.fecha);
        fecha.setText(intentRecibidoDePrincipal.getStringExtra("FECHA"));

        //duracion
        final TextView duracion = findViewById(R.id.duracion);
        duracion.setText("Tiempo: "+intentRecibidoDePrincipal.getIntExtra("DURACION",0)+" min");


        portada.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                watchYoutubeVideo(intentRecibidoDePrincipal.getStringExtra("IDYOUTUBE"));

            }
        });

    }
}