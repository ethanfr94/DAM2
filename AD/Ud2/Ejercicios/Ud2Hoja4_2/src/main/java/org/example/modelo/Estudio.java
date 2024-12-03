package org.example.modelo;

import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "estudios")
public class Estudio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // @NaturalId indica que el campo codEstudio es un identificador natural
    @NaturalId
    @Column(length = 5)
    private String codEstudio;
    @Column(length = 45, nullable = false)
    private String nombre;
    // @OneToMany indica que la relación es de uno a muchos y mappedBy indica que la relación es bidireccional y que el dueño de la relación es la clase Estudio
    // cascade = CascadeType.ALL indica que si se elimina un estudio se eliminan todos los empleados asociados a él
    // orphanRemoval = true indica que si se elimina un empleado se elimina el estudio asociado a él

    @OneToMany(mappedBy = "estudio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmpleadoEstudio> empleados = new ArrayList<>();


    public Estudio() {
    }

    public Long getId() {
        return id;
    }

    public void setCodEstudio(String codEstudio) {
        this.codEstudio = codEstudio;
    }

    public String getCodEstudio() {
        return codEstudio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<EmpleadoEstudio> getEmpleados() {
        return empleados;
    }
}
