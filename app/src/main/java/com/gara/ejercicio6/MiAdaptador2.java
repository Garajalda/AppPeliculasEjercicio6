package com.gara.ejercicio6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MiAdaptador2 extends RecyclerView.Adapter<MiAdaptador2.MyViewHolder> implements View.OnClickListener{


    ArrayList<Pelicula> peliculas;

    public MiAdaptador2(ArrayList<Pelicula> peliculas){
        this.peliculas = peliculas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View elemento = LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_individual_2,parent,false);
        elemento.setOnClickListener(this);

        MyViewHolder mvh = new MyViewHolder(elemento);
        return mvh;
    }

    public void setSelectedPos(int selectedPos) {
        if(selectedPos==this.selectedPos){
            notifyItemChanged(this.selectedPos);
            this.selectedPos= RecyclerView.NO_POSITION;
        }else{
            if(this.selectedPos>=0)notifyItemChanged(this.selectedPos);
            this.selectedPos = selectedPos;
            notifyItemChanged(this.selectedPos);
        }
        this.selectedPos = selectedPos;
    }

    public int getSelectedPos() {
        return selectedPos;
    }

    int selectedPos = RecyclerView.NO_POSITION;
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Pelicula pelicula = this.peliculas.get(position);
        holder.portada.setImageResource(pelicula.getPortada());
        holder.director.setText("Director: "+pelicula.getDirector());
        holder.titulo.setText("Título: "+pelicula.titulo);
        holder.sala.setText("Sala: "+pelicula.sala);
        holder.duracion.setText("Duración: "+pelicula.duracion);
        holder.year.setText("Fecha: "+pelicula.getFecha());
    }


    @Override
    public int getItemCount() {
        return this.peliculas.size();
    }

    private View.OnClickListener listener;
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener!=null) listener.onClick(view);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView titulo;
        private TextView year;
        private TextView director;
        private TextView duracion;
        private TextView sala;
        ImageView portada;
        public MyViewHolder(View viewElemento){
            super(viewElemento);
            this.titulo = viewElemento.findViewById(R.id.titulo_2);
            this.year = viewElemento.findViewById(R.id.fecha_2);
            this.director = viewElemento.findViewById(R.id.director_2);
            this.duracion = viewElemento.findViewById(R.id.duracion_2);
            this.sala = viewElemento.findViewById(R.id.sala_2);
            this.portada = viewElemento.findViewById(R.id.portada_2);

        }
    }
}
