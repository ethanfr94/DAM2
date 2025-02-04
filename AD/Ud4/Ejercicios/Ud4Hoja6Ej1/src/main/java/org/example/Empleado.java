package org.example;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "empleado")
public class Empleado {
    @XmlElement
    private String nombre;
    @XmlElement
    private String puesto;
    @XmlAttribute
    private int salario;

    public Empleado() {
    }

    public String getNombre() {
        return nombre;
    }


    public String getPuesto() {
        return puesto;
    }


    public int getSalario() {
        return salario;
    }

}
