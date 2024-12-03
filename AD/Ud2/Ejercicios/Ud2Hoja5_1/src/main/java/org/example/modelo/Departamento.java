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
    // @OneToMany(mappedBy = "departamento") indica que la relación es bidireccional y que el propietario de la relación es la clase Empleado
    // mappedBy = "departamento" indica que la relación es bidireccional y que el propietario de la relación es la clase Empleado
    // @JoinColumn(name = "departamento_id") indica que la relación es unidireccional y que el propietario de la relación es la clase Departamento

    @OneToMany
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
