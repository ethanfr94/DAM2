package com.proyectos.proyectosapi.model;

import java.time.LocalDate;

public class Alumno {
    private String idAlumno;
    private String nombre;
    private String apellidos;
    private String dni;
    private String email;
    private String password;
    private String telefono;
    private Genero genero;
    private LocalDate fechaNac;
    private boolean activo;
    private Ciclo cicloActual;
    public Alumno() {

    }

    public Alumno(String idAlumno, String nombre, String dni, String apellidos, String password, String email, String telefono, Genero genero, LocalDate fechaNac, Ciclo cicloActual, boolean activo) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.dni = dni;
        this.apellidos = apellidos;
        this.password = password;
        this.email = email;
        this.telefono = telefono;
        this.genero = genero;
        this.fechaNac = fechaNac;
        this.cicloActual = cicloActual;
        this.activo = activo;
    }

    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Ciclo getCicloActual() {
        return cicloActual;
    }

    public void setCicloActual(Ciclo cicloActual) {
        this.cicloActual = cicloActual;
    }
}
