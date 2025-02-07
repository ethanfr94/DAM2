package org.example;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;
@XmlRootElement(name = "futbolistas")
public class Futbolistas {
    @XmlElement(name = "futbolista")
    List<Futbolista> futbolistas;

    public Futbolistas() {
    }

    public List<Futbolista> getFutbolistas() {
        return futbolistas;
    }

    public Futbolista getFutbolistaByNum(int num) {
        for (Futbolista futbolista : futbolistas) {
            if (futbolista.getNum() == num) {
                return futbolista;
            }
        }
        return null;
    }

    public boolean addFutbolista(Futbolista futbolista) {
        return futbolistas.add(futbolista);
    }

    public boolean removeFutbolista(Futbolista futbolista) {
        return futbolistas.remove(futbolista);
    }
}
