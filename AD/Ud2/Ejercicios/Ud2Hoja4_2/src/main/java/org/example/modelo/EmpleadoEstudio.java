package org.example.modelo;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@IdClass(EmpleadoEstudioId.class)
@Table(name = "empleados_estudios")
public class EmpleadoEstudio {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empleado_id",insertable = false,updatable = false)
    private Empleado empleado;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estudio_id",insertable = false,updatable = false)
    private Estudio estudio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    public EmpleadoEstudio() {
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpleadoEstudio that = (EmpleadoEstudio) o;
        return Objects.equals(empleado, that.empleado) && Objects.equals(estudio, that.estudio) && Objects.equals(fechaFin, that.fechaFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empleado, estudio, fechaFin);
    }
}
