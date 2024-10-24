package org.example.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Heroe {
    @Id
    private long id;
    private String nombre;
    private long rango;

    public Heroe() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getRango() {
        return rango;
    }

    public void setRango(long rango) {
        this.rango = rango;
    }
}
