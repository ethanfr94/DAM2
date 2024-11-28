package com.proyectos.proyectosapi.model;

public class Realiza {
    private int id;
    private int calificacion;
    private Alumno alumno;
    private Proyecto proyecto;
    private String comentario;

    public Realiza() {
    }

    public Realiza(int id, int calificacion, Alumno alumno, Proyecto proyecto, String comentario) {
        this.id = id;
        this.calificacion = calificacion;
        this.alumno = alumno;
        this.proyecto = proyecto;
        this.comentario = comentario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
