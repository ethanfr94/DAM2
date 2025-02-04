package org.example;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "universidad")
public class Universidad {
    @XmlElement(name = "departamento")
    private List<Departamento> departamentos;

    public Universidad() {
        departamentos = new ArrayList<>();
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

}
