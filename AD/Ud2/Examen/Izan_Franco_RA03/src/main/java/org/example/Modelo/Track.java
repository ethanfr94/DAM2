package org.example.Modelo;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = "Track.findAll", query = "SELECT t FROM Track t")
@Table(name = "tracks")
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_track", nullable = false)
    private Integer id;

    @Column(name = "titulo", length = 70)
    private String titulo;

    @Column(name = "interprete", length = 50)
    private String interprete;

    @ColumnDefault("0")
    @Column(name = "dur_seg")
    private Integer durSeg;

    @Column(name = "anno")
    private Short anno;

    @ColumnDefault("0")
    @Column(name = "num_descargas")
    private Short numDescargas;

    @ColumnDefault("0")
    @Column(name = "disponible")
    private Byte disponible;

    @OneToMany(mappedBy = "audio", cascade = CascadeType.ALL, orphanRemoval = true)
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInterprete() {
        return interprete;
    }

    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }

    public Integer getDurSeg() {
        return durSeg;
    }

    public void setDurSeg(Integer durSeg) {
        this.durSeg = durSeg;
    }

    public Short getAnno() {
        return anno;
    }

    public void setAnno(Short anno) {
        this.anno = anno;
    }

    public Short getNumDescargas() {
        return numDescargas;
    }

    public void setNumDescargas(Short numDescargas) {
        this.numDescargas = numDescargas;
    }

    public Byte getDisponible() {
        return disponible;
    }

    public void setDisponible(Byte disponible) {
        this.disponible = disponible;
    }

}