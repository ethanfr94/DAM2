package org.example;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@XmlType(propOrder = {"codigo", "nombre", "telefono", "tipo", "empleados"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "departamento")
public class Departamento {

    @XmlElement
    private String codigo;
    @XmlElement
    private String nombre;
    @XmlAttribute
    private String telefono;
    @XmlAttribute
    private String tipo;
    @XmlElement(name = "empleado")
    private List<Empleado> empleados;

    public Departamento() {
        empleados = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

}
