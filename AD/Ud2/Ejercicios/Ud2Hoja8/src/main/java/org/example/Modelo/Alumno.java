package org.example.Modelo;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Entity
@Table(name = "alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('alumno2_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "nota_media", precision = 4, scale = 2)
    private BigDecimal notaMedia;

    // @ManyToOne indica que la relación es muchos a uno
    // fetch = FetchType.LAZY indica que la relación se cargará de forma diferida
    // optional = false indica que la relación es obligatoria
    // @JoinColumn indica la columna que se utilizará para la relación
    // esta etiqueta se coloca en la entidad que tiene la clave foránea
    // en este caso se creara una columna curso_id en la tabla alumno que se relacionará con la columna id de la tabla curso

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