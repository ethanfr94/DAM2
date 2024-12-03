package org.example.modelo;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Table(name = "empleados")
public class Empleado {
    @Id // solo con ID hay que asignarle valor al id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// la id se genera autoincrementada para cada tabla
    private long id;
    @Column(length = 45, nullable = false)
    private String nombre;
    @Column(length = 30)
    private String oficio;
    @Column(name = "fecha_alta")
    private LocalDate fechaAlta;
    // @Embedded indica que la clase Sueldo es una clase embebida
    @Embedded
    private Sueldo salario;
    // @OneToMany indica que la relación es de uno a muchos y mappedBy indica que la relación es bidireccional y que el dueño de la relación es la clase Empleado
    // cascade = CascadeType.ALL indica que si se elimina un empleado se eliminan todos los estudios asociados a él
    // orphanRemoval = true indica que si se elimina un estudio se elimina el empleado asociado a él
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmpleadoEstudio> estudios = new ArrayList<>();

    public Empleado() {
    }

    public Empleado(String nombre, String oficio, LocalDate fechaAlta, double salario) {
        this.nombre = nombre;
        this.oficio = oficio;
        this.fechaAlta = fechaAlta;
        Sueldo s = new Sueldo();
        s.setSalario(salario);
        this.salario = s;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Sueldo getSalario() {
        return salario;
    }

    public void setSalario(Sueldo salario) {
        this.salario = salario;
    }

    public List<EmpleadoEstudio> getEstudios() {
        return estudios;
    }

    public void addEstudio(Estudio estudio, LocalDate fechaFin) {
        EmpleadoEstudio ee = new EmpleadoEstudio();
        ee.setEmpleado(this);
        ee.setEstudio(estudio);
        ee.setFechaFin(fechaFin);
        estudios.add(ee);
        estudio.getEmpleados().add(ee);
    }

    public void removeEstudio(Estudio estudio, EntityManager em) {
        Iterator<EmpleadoEstudio> it = estudios.iterator();
        while (it.hasNext()) {
            EmpleadoEstudio ee = it.next();
            if (ee.getEstudio().getEmpleados().equals(this) && ee.getEstudio().equals(estudio)) {
                it.remove();
                ee.getEstudio().getEmpleados().remove(ee);
                ee.setEstudio(null);
                ee.setEmpleado(null);
                em.remove(ee);
            }
        }
    }

}
