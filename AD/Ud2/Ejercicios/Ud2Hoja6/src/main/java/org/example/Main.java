package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.Modelo.Alumno;
import org.example.Modelo.Profesor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");
        EntityManager em = emf.createEntityManager();

        List<Alumno> alumnos = new ArrayList<Alumno>();

        for (int i = 1; i <= 10; i++) {
            Alumno a = em.find(Alumno.class, i);
            alumnos.add(a);
        }

        for (Alumno a : alumnos) {
            System.out.println(a.getNombre()+" -- "+a.getCurso().getNombre()+" -- "+a.getNotaMedia());
        }

        em.close();
        emf.close();
    }
}