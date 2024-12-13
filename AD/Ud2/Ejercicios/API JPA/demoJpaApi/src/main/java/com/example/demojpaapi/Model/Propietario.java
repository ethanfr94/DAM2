package com.example.demojpaapi.Model;

import jakarta.persistence.*;

@Entity
@Table(name="propietarios")
public class Propietario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(length=30,nullable=false)
    private String nombre;
    @Enumerated(EnumType.STRING) //Guarda valores del enum como texto
    private String situacion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }
}
