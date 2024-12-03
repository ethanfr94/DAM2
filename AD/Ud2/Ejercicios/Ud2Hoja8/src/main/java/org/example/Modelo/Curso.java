package org.example.Modelo;

import jakarta.persistence.*;

@Entity
// @NamedQuery se utiliza para definir consultas con nombre que se pueden utilizar en las consultas de JPQL
// se pueden definir consultas con nombre en la entidad o en un archivo XML
// en este caso se define una consulta con nombre findAll que devolverá todos los cursos de la base de datos
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


}