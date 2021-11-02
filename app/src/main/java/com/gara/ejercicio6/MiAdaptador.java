package com.gara.ejercicio6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.MyViewHolder>{
    ArrayList<Pelicula> peliculas;

    public MiAdaptador(ArrayList<Pelicula> peliculas){
        this.peliculas = peliculas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View elemento = LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_individual,parent,false);
        MyViewHolder mvh = new MyViewHolder(elemento);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Pelicula pelis = this.peliculas.get(position);
        holder.titulo.setText(pelis.titulo);
        holder.year.setText(pelis.getFecha()+"");
        holder.director.setText(pelis.getDirector());
        holder.portada.setImageResource(pelis.getPortada());
    }

    @Override
    public int getItemCount() {
        return this.peliculas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView titulo;
        private TextView director;
        private TextView year;
        ImageView portada;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.titulo = itemView.findViewById(R.id.textViewTitulo);
            this.director = itemView.findViewById(R.id.textViewDirector);
            this.year = itemView.findViewById(R.id.textViewYear);
            this.portada = itemView.findViewById(R.id.imagePortada);
        }
    }
}
