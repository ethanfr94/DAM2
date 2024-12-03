package org.example.modelo;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalTime;

@Entity
@Table(name = "canciones")
public class Cancione {
    @Id
    @Column(name = "numCancion", nullable = false)
    private Integer id;

    // @ManyToOne sirve para indicar que la clase Cancione tiene una relacion de muchos a uno con la clase Grupo
    // creara una columna en la tabla canciones llamada grupo que sera una clave foranea que apuntara a la tabla grupos
    // fetch = FetchType.LAZY indica que la relacion se cargara de forma perezosa
    // optional = false indica que la relacion es obligatoria
    // @OnDelete(action = OnDeleteAction.CASCADE) indica que si se borra un grupo se borraran todas las canciones que pertenezcan a ese grupo
    // @JoinColumn(name = "grupo", nullable = false) indica que la columna que se creara en la tabla canciones se llamara grupo y sera una clave foranea
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "grupo", nullable = false)
    private Grupo grupo;

    @Column(name = "duracion", nullable = false)
    private LocalTime duracion;

    @Column(name = "titulo", nullable = false, length = 40)
    private String titulo;

    // @ColumnDefault("0") indica que el valor por defecto de la columna sera 0
    @ColumnDefault("0")
    @Column(name = "total_votos")
    private Integer totalVotos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public LocalTime getDuracion() {
        return duracion;
    }

    public void setDuracion(LocalTime duracion) {
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTotalVotos() {
        return totalVotos;
    }

    public void setTotalVotos(Integer totalVotos) {
        this.totalVotos = totalVotos;
    }

}