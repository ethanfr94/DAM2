package org.example.Modelo;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@NamedQuery(name = "DescargasTotale.elimina", query = "select dt from DescargaTotale dt where dt.numAudio.disponible = 0")
@Table(name = "descarga_totales")
public class DescargaTotale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "num_usuario", nullable = false)
    private Usuario numUsuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "num_audio", nullable = false)
    private Track numAudio;

    @ColumnDefault("0")
    @Column(name = "total", nullable = false)
    private Integer total;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getNumUsuario() {
        return numUsuario;
    }

    public void setNumUsuario(Usuario numUsuario) {
        this.numUsuario = numUsuario;
    }

    public Track getNumAudio() {
        return numAudio;
    }

    public void setNumAudio(Track numAudio) {
        this.numAudio = numAudio;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}