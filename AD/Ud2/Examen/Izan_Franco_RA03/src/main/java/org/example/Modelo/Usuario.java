package org.example.Modelo;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_usu", nullable = false)
    private Integer id;

    @Column(name = "usuario", nullable = false, length = 15)
    private String usuario;

    @Column(name = "contra", nullable = false, length = 18)
    private String contra;

    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 40)
    private String apellidos;

    @Column(name = "fechanac")
    private LocalDate fechanac;

    @ColumnDefault("0")
    @Column(name = "num_descargas", nullable = false)
    private Integer numDescargas;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id_num_usu")
    private Usuario usuarioId;

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @OneToMany(mappedBy = "usuario", orphanRemoval = true)
    private List<Solicitude> solicitudes = new ArrayList<>();

    public List<Solicitude> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitude> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechanac() {
        return fechanac;
    }

    public void setFechanac(LocalDate fechanac) {
        this.fechanac = fechanac;
    }

    public Integer getNumDescargas() {
        return numDescargas;
    }

    public void setNumDescargas(Integer numDescargas) {
        this.numDescargas = numDescargas;
    }

}