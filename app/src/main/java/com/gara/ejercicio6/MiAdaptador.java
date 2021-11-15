package com.gara.ejercicio6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.MyViewHolder> implements View.OnClickListener{
    ArrayList<Pelicula> peliculas;
    int selectedPos = RecyclerView.NO_POSITION;

    public MiAdaptador(ArrayList<Pelicula> peliculas){
        this.peliculas = peliculas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View elemento = LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_individual,parent,false);
        ImageButton btnLike = elemento.findViewById(R.id.btnLike1);
        MyViewHolder mvh = new MyViewHolder(elemento);
        elemento.setOnClickListener(this);

        return mvh;
    }




    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Pelicula pelis = this.peliculas.get(position);
        holder.titulo.setText(pelis.titulo);
        holder.clasificacion.setImageResource(pelis.getClasi());
        holder.director.setText(pelis.getDirector());
        holder.portada.setImageResource(pelis.getPortada());
        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        if(peliculas.get(position).getFavorita()){
            holder.btnLike.setImageResource(R.drawable.likered);
        }

    }





    @Override
    public int getItemCount() {
        return this.peliculas.size();
    }

    private View.OnClickListener listener;
    public void  setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }



    @Override
    public void onClick(View view) {
        if(listener!=null) listener.onClick(view);

    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView titulo;
        private TextView director;
        ImageView clasificacion;
        ImageView portada;
        ImageButton btnLike;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.titulo = itemView.findViewById(R.id.textViewTitulo);
            this.director = itemView.findViewById(R.id.textViewDirector);
            this.clasificacion = itemView.findViewById(R.id.imageView);
            this.portada = itemView.findViewById(R.id.imagePortada);
            this.btnLike = itemView.findViewById(R.id.btnLike1);


        }
    }

    public int getSelectedPos(){
        return selectedPos;
    }

    public void setSelectedPos(int nuevaPos){
        if(nuevaPos == this.selectedPos){
            notifyItemChanged(this.selectedPos);
            this.selectedPos=RecyclerView.NO_POSITION;
        }else{
            if(this.selectedPos >= 0) notifyItemChanged(this.selectedPos);
            this.selectedPos = nuevaPos;
            notifyItemChanged(this.selectedPos);
        }
    }
}
