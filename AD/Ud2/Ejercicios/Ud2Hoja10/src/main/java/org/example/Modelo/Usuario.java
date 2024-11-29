package org.example.Modelo;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @Column(name = "user", nullable = false, length = 15)
    private String user;

    @Column(name = "`contraseña`", nullable = false, length = 32)
    private String contraseña;

    @Column(name = "nombre", nullable = false, length = 15)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 30)
    private String apellidos;

    @Column(name = "fechanac")
    private LocalDate fechanac;

    @Column(name = "numvotos")
    private Integer numvotos;

    @OneToMany(mappedBy = "usuario", orphanRemoval = true)
    private List<Voto> votos = new ArrayList<>();

    public List<Voto> getVotos() {
        return votos;
    }

    public void setVotos(List<Voto> votos) {
        this.votos = votos;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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

    public LocalDate getFechanac() {
        return fechanac;
    }

    public void setFechanac(LocalDate fechanac) {
        this.fechanac = fechanac;
    }

    public Integer getNumvotos() {
        return numvotos;
    }

    public void setNumvotos(Integer numvotos) {
        this.numvotos = numvotos;
    }

}