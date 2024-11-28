package com.proyectos.proyectosapi.model;

import java.time.LocalDate;

public class Proyecto {
    private int idProyecto;
    private String nombre;
    private String tipo;
    private String resumen;
    private int annoAcad;
    private LocalDate fechaPres;
    private String logo;
    private String memoria;
    private String archivos;
    private String comentarios;
    private Ciclo ciclo;
    private Profesor tutor;

    public Proyecto() {
    }

    public Proyecto(int idProyecto, String nombre, String tipo, String resumen, int annoAcad, LocalDate fechaPres, String logo, String memoria, String archivos, String comentarios, Ciclo ciclo, Profesor tutor) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.tipo = tipo;
        this.resumen = resumen;
        this.annoAcad = annoAcad;
        this.fechaPres = fechaPres;
        this.logo = logo;
        this.memoria = memoria;
        this.archivos = archivos;
        this.comentarios = comentarios;
        this.ciclo = ciclo;
        this.tutor = tutor;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public int getAnnoAcad() {
        return annoAcad;
    }

    public void setAnnoAcad(int annoAcad) {
        this.annoAcad = annoAcad;
    }

    public LocalDate getFechaPres() {
        return fechaPres;
    }

    public void setFechaPres(LocalDate fechaPres) {
        this.fechaPres = fechaPres;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getArchivos() {
        return archivos;
    }

    public void setArchivos(String archivos) {
        this.archivos = archivos;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public Profesor getTutor() {
        return tutor;
    }

    public void setTutor(Profesor tutor) {
        this.tutor = tutor;
    }
}
