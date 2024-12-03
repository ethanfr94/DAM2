package org.example.modelo;

import java.io.Serializable;
import java.util.Objects;


// Esta clase es necesaria para mapear la relación muchos a muchos entre Empleado y Estudio
// La clase EmpleadoEstudioId es una clase compuesta que contiene las claves primarias de las tablas empleados y estudios
// La clase EmpleadoEstudioId debe implementar la interfaz Serializable
// La clase EmpleadoEstudioId debe tener un constructor sin argumentos
// La clase EmpleadoEstudioId debe tener los métodos equals y hashCode sobreescritos
// La clase EmpleadoEstudioId debe tener los atributos empleado y estudio
// Los atributos empleado y estudio deben ser de tipo long que hacen referencia a las claves primarias de las tablas empleados y estudios
// Los atributos empleado y estudio deben tener los métodos getter y setter
public class EmpleadoEstudioId implements Serializable {
    private long empleado;
    private long estudio;

    public EmpleadoEstudioId() {
    }

    public long getEmpleado() {
        return empleado;
    }

    public void setEmpleado(long empleado) {
        this.empleado = empleado;
    }

    public long getEstudio() {
        return estudio;
    }

    public void setEstudio(long estudio) {
        this.estudio = estudio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpleadoEstudioId that = (EmpleadoEstudioId) o;
        return empleado == that.empleado && estudio == that.estudio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(empleado, estudio);
    }
}
