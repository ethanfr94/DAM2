package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.modelo.Empleado;
import org.example.modelo.Sueldo;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner t = new Scanner(System.in);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        /*Empleado emp1 = new Empleado();
        emp1.setNombre("Manolo");
        emp1.setOficio("palista");
        emp1.setFechaAlta(java.time.LocalDate.now());
        emp1.setSalario(1000.0);
        em.persist(emp1);

        Empleado emp2 = new Empleado();
        emp2.setNombre("Paco");
        emp2.setOficio("Escayolista");
        emp2.setFechaAlta(java.time.LocalDate.now());
        emp2.setSalario(995.50);
        em.persist(emp2);*/

        em.persist(nuevoEmpleado(t));


        em.getTransaction().commit();



        em.close();
        emf.close();
    }

    private static Empleado nuevoEmpleado(Scanner t) {
        Empleado emp = new Empleado();
        /*System.out.println("Introduce el id del empleado");
        emp.setId(Long.parseLong(t.nextLine()));*/
        System.out.println("Introduce el nombre del empleado");
        emp.setNombre(t.nextLine());
        System.out.println("Introduce el oficio del empleado");
        emp.setOficio(t.nextLine());
        System.out.println("Introduce la fecha de alta del empleado");
        System.out.println("Introduce el dia");
        int dia = Integer.parseInt(t.nextLine());
        System.out.println("Introduce el mes");
        int mes = Integer.parseInt(t.nextLine());
        System.out.println("Introduce el año");
        int anio = Integer.parseInt(t.nextLine());
        emp.setFechaAlta(java.time.LocalDate.of(anio, mes, dia));
        System.out.println("Introduce el salario del empleado");
        Sueldo s = new Sueldo();
        s.setSalario(Double.parseDouble(t.nextLine()));
        emp.setSalario(s);
        return emp;
    }
}