package org.example.modelo;

import java.io.Serializable;
import java.util.Objects;

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
