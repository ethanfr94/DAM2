package org.example.Modelo;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
// @NamedQueries indica que la clase tiene consultas con nombre asociadas
// @NamedQuery en su consulta indica que la consulta obtendra todos los cursos de la tabla curso
@NamedQueries({@NamedQuery(name = "Curso.findAll", query = "select c from Curso c")})
@Table(name = "curso")
public class Curso {
    @Id
    @Column(name = "id", nullable = false, length = 4)
    private String id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tutor_id", nullable = false)
    private Profesor tutor;

    // @OneToMany indica que la relación es de uno a muchos y que la clave foránea está en la tabla de la entidad Alumno
    // mappedBy indica que la relación está mapeada por el atributo curso de la clase Alumno
    // fetch = FetchType.LAZY indica que la relación se cargará de forma diferida
    // esto creara una tabla intermedia para la relación muchos a muchos entre Alumno y Curso
    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
    private Set<Alumno> alumnos = new LinkedHashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Profesor getTutor() {
        return tutor;
    }

    public void setTutor(Profesor tutor) {
        this.tutor = tutor;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

}