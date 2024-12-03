package org.example.Modelo;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "grupos")
// NamedQueries para las consultas de la clase GBD

@NamedQueries(
        {@NamedQuery(name = "Grupo.antesDe", query = "SELECT g FROM Grupo g WHERE g.localidad = :localidad AND g.fechaEstreno < :year"),
        @NamedQuery(name = "Grupo.masCanciones", query = "SELECT g FROM Grupo g WHERE SIZE(g.canciones) > :n")}
)
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

    // Relación uno a muchos con Componente y Cancion con la propiedad mappedBy para indicar el atributo de la clase Componente y Cancion que mapea la relación
    // Se ha añadido orphanRemoval = true para que al eliminar un grupo se eliminen también sus componentes y canciones
    // FetchType.LAZY para que no se carguen los componentes y canciones al cargar un grupo

    @OneToMany(mappedBy = "grupo", fetch =  FetchType.LAZY, orphanRemoval = true)
    private List<Componente> componentes = new ArrayList<>();

    // Relación uno a muchos con Cancion con la propiedad mappedBy para indicar el atributo de la clase Cancion que mapea la relación
    // Se ha añadido orphanRemoval = true para que al eliminar un grupo se eliminen también sus canciones
    // FetchType.LAZY para que no se carguen las canciones al cargar un grupo
    @OneToMany(mappedBy = "grupo", orphanRemoval = true)
    private List<Cancion> canciones = new ArrayList<>();

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    public List<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<Componente> componentes) {
        this.componentes = componentes;
    }

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