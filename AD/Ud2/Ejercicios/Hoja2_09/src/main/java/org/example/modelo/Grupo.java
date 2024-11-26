package org.example.modelo;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Entity
@Table(name = "grupos")
@NamedQueries({
        @NamedQuery(name = "Grupo.findAll", query = "select g from Grupo g"),
        @NamedQuery(name = "Grupo.sinComponentes", query = "select g from Grupo g where g.esgrupo = true and g.id not in (select c.grupo.id from Componente c)"),
        @NamedQuery(name = "Grupo.sinCompañia", query = "select g from Grupo g where g.compania is null"),
        @NamedQuery(name = "Grupo.Barcelona2010", query = "select g from Grupo g where g.localidad = 'Barcelona' and g.annoGrab < 2010"),
        @NamedQuery(name = "Grupo.gruposDeMadrid", query = "select count(*) from Grupo g where g.localidad = 'Madrid'"),
})

public class Grupo {
    @Id
    @Column(name = "codgrupo", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @Column(name = "localidad", nullable = false, length = 20)
    private String localidad;

    @Column(name = "estilo", nullable = false, length = 20)
    private String estilo;

    @ColumnDefault("1")
    @Column(name = "esgrupo", nullable = false)
    private Boolean esgrupo = false;

    @Column(name = "annoGrab")
    private Integer annoGrab;

    @Column(name = "fechaEstreno")
    private LocalDate fechaEstreno;

    @Column(name = "compania", length = 35)
    private String compania;

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

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public Boolean getEsgrupo() {
        return esgrupo;
    }

    public void setEsgrupo(Boolean esgrupo) {
        this.esgrupo = esgrupo;
    }

    public Integer getAnnoGrab() {
        return annoGrab;
    }

    public void setAnnoGrab(Integer annoGrab) {
        this.annoGrab = annoGrab;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

}