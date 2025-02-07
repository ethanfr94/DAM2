package org.example;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "atletas")
public class Maraton {
    @XmlElement(name = "atleta")
    private List<Atleta> atletas;

    public Maraton() {
        atletas = new ArrayList<>();
    }

    public List<Atleta> getAtletas() {
        return atletas;
    }

    public boolean addAtleta(Atleta atleta) {
        return atletas.add(atleta);
    }

}
