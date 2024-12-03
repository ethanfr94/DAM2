package org.example.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "votos")
public class Voto {
    // @EmbeddedId sirve para indicar que la clase Voto tiene una clave primaria compuesta por dos claves foraneas que apuntan a las tablas usuarios y canciones
    @EmbeddedId
    private VotoId id;

    // @MapsId sirve para indicar que el atributo usuario es una clave foranea que apunta a la tabla usuarios y que forma parte de la clave primaria
    // @ManyToOne indica que la clase Voto tiene una relacion de muchos a uno con la clase Usuario
    // fetch = FetchType.LAZY indica que la relacion se cargara de forma perezosa
    // optional = false indica que la relacion es obligatoria
    // @JoinColumn(name = "usuario", nullable = false) indica que la columna que se creara en la tabla votos se llamara usuario y sera una clave foranea

    @MapsId("usuario")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cancion", nullable = false)
    private Cancione cancion;

    public VotoId getId() {
        return id;
    }

    public void setId(VotoId id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cancione getCancion() {
        return cancion;
    }

    public void setCancion(Cancione cancion) {
        this.cancion = cancion;
    }

}