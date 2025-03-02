package org.example.Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "curso")
public class Curso {
    @Id
    @Column(name = "id", nullable = false, length = 4)
    private String id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    // @OneToOne indica que la relación entre Curso y Profesor es de uno a uno
    // @JoinColumn indica que la columna que hace referencia a la clave primaria de Profesor es tutor_id
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