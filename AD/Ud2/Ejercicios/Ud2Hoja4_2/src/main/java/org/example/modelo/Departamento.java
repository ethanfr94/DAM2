package org.example.modelo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "departamentos")
public class Departamento {
    @Id
    private long id;
    @Column(length = 50, nullable = false)
    private String nombre;
    @Column(length = 50)
    private String localidad;
    // Relación uno a muchos
    @OneToMany
    // Nombre de la columna que hace referencia a la clave foránea
    @JoinColumn(name = "departamento_id")
    private List<Empleado> empleados = new ArrayList<>();

    public Departamento() {
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

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
}
