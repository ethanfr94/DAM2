package org.example.modelo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue("OFICIAL")
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
