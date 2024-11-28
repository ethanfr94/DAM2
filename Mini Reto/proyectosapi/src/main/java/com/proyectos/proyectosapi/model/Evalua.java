package com.proyectos.proyectosapi.model;

public class Evalua {
    private int id;
    private Float calificacion;
    private String comentario;
    private Proyecto proyecto;
    private Profesor profesor;

    public Evalua() {

    }

    public Evalua(int id, Float calificacion, String comentario, Proyecto proyecto, Profesor profesor) {
        this.id = id;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.proyecto = proyecto;
        this.profesor = profesor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Float calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}
