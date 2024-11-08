package org.example.modelo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "estudios_oficiales")
public class EstudioOficial extends Estudio {
    private String centro;
    private String realDecreto;

    public EstudioOficial() {
        super();
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getRealDecreto() {
        return realDecreto;
    }

    public void setRealDecreto(String realDecreto) {
        this.realDecreto = realDecreto;
    }
}
