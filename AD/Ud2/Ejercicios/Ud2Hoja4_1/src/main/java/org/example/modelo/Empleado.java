package org.example.modelo;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
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
    @Embedded
    private Sueldo salario;
    // @ManyToMany indica que la relación es de muchos a muchos
    // @JoinTable indica la tabla intermedia que se va a crear para almacenar la relación
    @ManyToMany
    @JoinTable(
            name = "empleados_estudios", // nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "empleado_id"), // nombre de la columna de la tabla intermedia que hace referencia a la tabla actual
            inverseJoinColumns = @JoinColumn(name = "estudio_id") // nombre de la columna de la tabla intermedia que hace referencia a la tabla con la que se relaciona
    )
    private List<Estudio> estudios = new ArrayList<>();

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

    public List<Estudio> getEstudios() {
        return estudios;
    }

    public void addEstudio(Estudio estudio) {
        estudios.add(estudio);
        estudio.getEmpleados().add(this);
    }

    public void removeEstudio(Estudio estudio) {
        estudios.remove(estudio);
        estudio.getEmpleados().remove(this);
    }

}
