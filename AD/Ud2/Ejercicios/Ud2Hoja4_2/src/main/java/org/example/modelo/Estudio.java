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
    @NaturalId
    @Column(length = 5)
    private String codEstudio;
    @Column(length = 45, nullable = false)
    private String nombre;
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
