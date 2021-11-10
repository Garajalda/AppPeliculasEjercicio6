package com.gara.ejercicio6;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Pelicula implements Serializable {

    String titulo;
    String director;
    String sinopsis;
    String sala;
    String idYoutube;
        int clasi, portada, duracion;
        Date fecha;
        boolean favorita;

        private SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");

        public Pelicula(String titulo, String director, int duracion, Date fecha, String sala, int clasi, int portada) {
            this.clasi=clasi;
            this.director=director;
            this.fecha=fecha;
            this.portada=portada;
            this.sala=sala;
            this.titulo=titulo;
            this.duracion=duracion;
            this.favorita=false;
        }

        public String getIdYoutube() {
            return idYoutube;
        }
        public void setIdYoutube(String idYoutube) {
            this.idYoutube=idYoutube;
        }
        public int getClasi() {
            return clasi;
        }
        public void setClasi(int clasi) {
            this.clasi=clasi;
        }
        public String getDirector() {
            return director;
        }
        public void setDirector(String director) {
            this.director=director;
        }
        public boolean getFavorita() {
            return favorita;
        }
        public void setFavorita(Boolean favorita) {
            this.favorita=favorita;
        }
        public void setFavorita(boolean favorita){ this.favorita = favorita; }
        public Date getFecha() {
            return fecha;
        }
        public void setFecha(Date fecha) {
            this.fecha=fecha;
        }
        public int getPortada() {
            return portada;
        }

        public void setSinopsis(String sinopsis){
            this.sinopsis = sinopsis;
        }
        public String getSinopsis(){
            return sinopsis;
        }

    @Override
    public String toString() {
        return titulo;
    }
}
