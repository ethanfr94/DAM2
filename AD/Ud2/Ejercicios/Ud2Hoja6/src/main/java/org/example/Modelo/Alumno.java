package org.example.Modelo;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Entity
@Table(name = "alumno")
public class Alumno {
    // @GeneratedValue(strategy = GenerationType.IDENTITY) hace que el valor de la clave primaria se genere automáticamente
    // @ColumnDefault hace que el valor de la clave primaria se genere automáticamente siguiente al último valor generado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('alumno2_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "nota_media", precision = 4, scale = 2)
    private BigDecimal notaMedia;

    // @ManyToOne indica que la relación entre Alumno y Curso es de muchos a uno
    // @JoinColumn indica que la columna que hace referencia a la clave primaria de Curso es curso_id
    // @ManyToOne(fetch = FetchType.LAZY) indica que la relación se cargará de forma diferida
    // @ManyToOne(optional = false) indica que la relación es obligatoria
    // @join column(nullable = false) indica que la columna curso_id no puede tener valores nulos
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(BigDecimal notaMedia) {
        this.notaMedia = notaMedia;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}