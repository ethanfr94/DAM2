package org.example;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "atleta")
public class Atleta {
    @XmlElement
    private int dorsal;
    @XmlElement
    private String nombre;
    @XmlElement
    private String apellidos;
    @XmlElement
    private String fechaNacimiento;
    @XmlElement
    private String nacionalidad;
    @XmlElement
    private double marca;

    public Atleta(int dorsal, String nombre, String apellidos, String fechaNacimiento, String nacionalidad, double marca) {
        this.dorsal = dorsal;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.marca = marca;
    }

    public Atleta() {
    }

    public int getDorsal() {
        return dorsal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public double getMarca() {
        return marca;
    }

}
