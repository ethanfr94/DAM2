package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.modelo.*;

import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        EstudioOficial e = new EstudioOficial();
        e.setCodEstudio("Logis");
        e.setNombre("Logistica");
        e.setCentro("IES Besaya");
        e.setRealDecreto("RD 123/2020");
        em.persist(e);

        EstudioNoOficial e2 = new EstudioNoOficial();
        e2.setCodEstudio("Prog");
        e2.setNombre("Programacion");
        e2.setAcademia("IES Miguel Herrero");
        e2.setHoras(100);
        em.persist(e2);


        Departamento d = new Departamento();
        d.setId(1L);
        d.setNombre("TIC");
        d.setLocalidad("Torrelavega");
        em.persist(d);

        Empleado emp1 = new Empleado("Manolo", "Desarrollador", java.time.LocalDate.now(),1000.0);
        emp1.addEstudio(e, LocalDate.of(2022, 11, 30));
        d.getEmpleados().add(emp1);
        em.persist(emp1);



        Empleado emp2 = new Empleado("Ramon", "Analista", java.time.LocalDate.now(),2000.0);
        emp2.addEstudio(e, LocalDate.of(2020, 12, 31));
        d.getEmpleados().add(emp2);
        em.persist(emp2);



        Empleado emp3 = new Empleado("Pedro", "Tester", java.time.LocalDate.now(),1500.0);
        emp3.addEstudio(e2, LocalDate.of(2020, 10, 21));
        d.getEmpleados().add(emp3);
        em.persist(emp3);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }


}