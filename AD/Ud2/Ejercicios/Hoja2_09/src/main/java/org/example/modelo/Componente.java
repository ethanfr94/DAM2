package org.example.modelo;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "componentes")
public class Componente {
    @Id
    @Column(name = "idComp", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 40)
    private String apellido;

    @Column(name = "alias", length = 20)
    private String alias;

    @Column(name = "funcion", length = 30)
    private String funcion;

    // @ManyToOne sirve para indicar que la clase Componente tiene una relacion de muchos a uno con la clase Grupo
    // creara una columna en la tabla componentes llamada grupo que sera una clave foranea que apuntara a la tabla grupos
    // fetch = FetchType.LAZY indica que la relacion se cargara de forma perezosa
    // optional = false indica que la relacion es obligatoria
    // @OnDelete(action = OnDeleteAction.CASCADE) indica que si se borra un grupo se borraran todos los componentes que pertenezcan a ese grupo
    // @JoinColumn(name = "grupo", nullable = false) indica que la columna que se creara en la tabla componentes se llamara grupo y sera una clave foranea

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "grupo", nullable = false)
    private Grupo grupo;

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

}