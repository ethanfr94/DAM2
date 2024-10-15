package Modelo;

import java.sql.Time;

public class Video {
    private int num_video;
    private String titulo;
    private String interprete;
    private Time duracion;
    private int year;
    private int num_emisiones;
    private boolean disponible;

    public Video() {
    }

    public int getNum_video() {
        return num_video;
    }

    public void setNum_video(int num_video) {
        this.num_video = num_video;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInterprete() {
        return interprete;
    }

    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }

    public Time getDuracion() {
        return duracion;
    }

    public void setDuracion(Time duracion) {
        this.duracion = duracion;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNum_emisiones() {
        return num_emisiones;
    }

    public void setNum_emisiones(int num_emisiones) {
        this.num_emisiones = num_emisiones;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Video{" +
                "num_video=" + num_video +
                ", titulo='" + titulo + '\'' +
                ", interprete='" + interprete + '\'' +
                ", duracion=" + duracion +
                ", year=" + year +
                ", num_emisiones=" + num_emisiones +
                ", disponible=" + disponible +
                '}';
    }
}
