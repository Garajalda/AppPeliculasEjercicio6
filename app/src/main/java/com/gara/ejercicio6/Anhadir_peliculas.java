package com.gara.ejercicio6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class Anhadir_peliculas extends AppCompatActivity {

    Datos datos = Datos.getInstance();
    ArrayList<Pelicula> peliculas = datos.getPelis("peliculas");
    ArrayList<Pelicula> peliculasAnhadidas = new ArrayList<>();


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_annhadir,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:

            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    boolean muestra = false;



    Calendar cal = Calendar.getInstance();

    String salaCine = "";
    int clasificacionImagen = 0;



    public void anhadirPelicula(MenuItem item){
        //titulo
        TextView titulo = findViewById(R.id.editTextTitulo);
        String tituloS = titulo.getText()+"";
        //director
        TextView director = findViewById(R.id.editTextDirector);
        String directorS = director.getText()+"";
        //duracion
        TextView duracion = findViewById(R.id.editTextDuracion);
        int duracionI = Integer.parseInt(duracion.getText()+"");
        Intent intentPeli = new Intent();
        peliculasAnhadidas.add(new Pelicula(tituloS,directorS,duracionI,cal.getTime(),salaCine,clasificacionImagen,R.drawable.sincara));
        intentPeli.putExtra("PELICULASMAS",peliculasAnhadidas);
        setResult(RESULT_OK,intentPeli);
        finish();


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anhadir_peliculas);
        getSupportActionBar().setTitle("Añadir pelicula");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //spinner
        final ArrayList<String> salas = new ArrayList<>();
        for(Pelicula sala : peliculas){
            if(!salas.contains(sala.sala)){
                salas.add(sala.sala);
            }


        }
        Spinner spinnerSalas = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,salas);
        spinnerSalas.setAdapter(adapter);


        spinnerSalas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(!muestra) muestra = true;
                else{
                   salaCine = salas.get(i)+"";
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //calendarView

        CalendarView fechaEstreno = findViewById(R.id.calendarView);
       fechaEstreno.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
           @Override
           public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {

               cal.set(i,i1,i2);
               getSupportActionBar().setTitle(cal.getTime()+"");
           }
       });






        //radioGroup
        RadioGroup rg = findViewById(R.id.radioGroup);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton g = findViewById(R.id.g);
                RadioButton pg = findViewById(R.id.pg);
                RadioButton r = findViewById(R.id.r);
                RadioButton pg13 = findViewById(R.id.pg13);
                RadioButton nc17 = findViewById(R.id.nc17);

                if(g.isChecked()){
                    clasificacionImagen = R.drawable.g;
                }else if(pg.isChecked()){
                    clasificacionImagen = R.drawable.pg;
                }else if(r.isChecked()){
                    clasificacionImagen = R.drawable.r;
                }else if(pg13.isChecked()){
                    clasificacionImagen = R.drawable.pg13;
                }else if(nc17.isChecked()){
                    clasificacionImagen = R.drawable.nc17;
                }
            }
        });







    }
}