package com.gara.ejercicio6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public  void watchYoutubeVideo(String id){
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
        Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + id));
        try {
            startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            startActivity(webIntent);
        }
    }

    public ArrayList<Pelicula> rellenaPeliculas(){

        ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();

        Calendar cal = Calendar.getInstance();
        cal.set(1982,12,3);
        Pelicula dune=new Pelicula("Dune","Lynch",180,cal.getTime(),"Gran vía",R.drawable.g,R.drawable.dune );

        dune.setIdYoutube("KwPTIEWTYEI");
        peliculas.add(dune);

        cal.set(1972,3,5);
        Pelicula a2001=new Pelicula("2001","Kubric",130,cal.getTime(),"Plaza elíptica",R.drawable.pg,R.drawable.d2001 );

        a2001.setIdYoutube("XHjIqQBsPjk");
        peliculas.add(a2001);

        cal.set(1984,11,2);
        Pelicula akira=new Pelicula("Akira","Otomo",170,cal.getTime(),"Gran vía",R.drawable.pg13,R.drawable.akira );

        akira.setIdYoutube("T9WTE3Q2G_Y");
        akira.setFavorita(true);
        peliculas.add(akira);

        cal.set(1995,1,2);
        Pelicula ia=new Pelicula("IA","Spielberg",140,cal.getTime(),"Travesia",R.drawable.r,R.drawable.ia );

        ia.setIdYoutube("vN_Hx_It3r0");
        peliculas.add(ia);

        cal.set(1999,6,23);
        Pelicula matrix=new Pelicula("Matrix","Lana Wachowski, Lilly Wachowski",136,cal.getTime(),"Gran vía",R.drawable.pg13,R.drawable.matrix );

        matrix.setIdYoutube("vN_Hx_It3r0");
        peliculas.add(matrix);

        cal.set(1982,8,21);
        Pelicula br=new Pelicula("Blade Runner","Ridley Scott",117,cal.getTime(),"Plaza elíptica",R.drawable.pg,R.drawable.blade );

        br.setIdYoutube("LBbDxYuvdm4");
        peliculas.add(br);

        cal.set(1995,1,2);
        Pelicula inte=new Pelicula("Interstellar","Christopher Nolan ",169,cal.getTime(),"Travesia",R.drawable.g,R.drawable.interstellar );
        inte.setIdYoutube("UoSSbmD9vqc");
        peliculas.add(inte);

        cal.set(1995,1,2);
        Pelicula alien=new Pelicula("Alien","Ridley Scott",117,cal.getTime(),"Plaza elíptica",R.drawable.pg13,R.drawable.alien );
        alien.setIdYoutube("LjLamj-b0I8");
        peliculas.add(alien);

        cal.set(1995,1,2);
        Pelicula st=new Pelicula("Star Trek","J. J. Abrams",128,cal.getTime(),"Travesia",R.drawable.pg,R.drawable.startrek);

        st.setIdYoutube("pKFUZ10Wmbw");
        peliculas.add(st);

        cal.set(2015,9,24);
        Pelicula martian=new Pelicula("The Martian","Ridley Scotts",151,cal.getTime(),"Gran vía",R.drawable.pg13,R.drawable.martian);
        martian.setIdYoutube("OS23SmNlE3Y");
        peliculas.add(martian);
        return peliculas;
    }
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MiAdaptador miAdaptador=new MiAdaptador(rellenaPeliculas());
        rv=findViewById(R.id.mi_recycler_view);

        GridLayoutManager miLayoutManager =new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        rv.setLayoutManager(miLayoutManager);
        rv.setAdapter(miAdaptador);
        rv.setItemAnimator(new DefaultItemAnimator());
    }
}