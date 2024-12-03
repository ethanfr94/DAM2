package org.example.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
// embeddable hace que la clase se guarde en la misma tabla que la clase que la contiene
@Embeddable
public class Sueldo {
    @Column(nullable = false)
    private double salario;
    private double comision;

    public Sueldo() {
    }


    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }
}
