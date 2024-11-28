package com.proyectos.proyectosapi.model;


public class Ciclo {
    private String codCiclo;
    private String nombre;
    private Etapa etapa;
    private String titulo;
    private String curriculo;
    private Familia familia;

    public Ciclo() {

    }

    public Ciclo(String codCiclo, String nombre, Etapa etapa, String curriculo, String titulo, Familia familia) {
        this.codCiclo = codCiclo;
        this.nombre = nombre;
        this.etapa = etapa;
        this.curriculo = curriculo;
        this.titulo = titulo;
        this.familia = familia;
    }

    public Etapa getEtapa() {
        return etapa;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public String getCodCiclo() {
        return codCiclo;
    }

    public void setCodCiclo(String codCiclo) {
        this.codCiclo = codCiclo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(String curriculo) {
        this.curriculo = curriculo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
