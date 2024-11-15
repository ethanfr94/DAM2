package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.Modelo.Alumno;
import org.example.Modelo.Curso;
import org.example.Modelo.Profesor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UDP");
        EntityManager em = emf.createEntityManager();

        int op;

        do {
            System.out.println("""
                    
                    1.DATOS DEL ALUMNO
                    2.DATOS DEL CURSO
                    3.LISTADO DE CURSOS
                    4.LISTADO DE ALUMNOS DEL CURSO
                    0.SALIR                    
                    """);
            op = Integer.parseInt(t.nextLine());
            switch (op) {
                case 1 -> {
                    System.out.println("Introduce el id del alumno");
                    int id = Integer.parseInt(t.nextLine());
                    Alumno a = em.find(Alumno.class, id);
                    System.out.println(a.getNombre() + " -- " + a.getCurso().getId() + " -- " + a.getNotaMedia());
                }
                case 2 -> {
                    System.out.println("Introduce el id del curso");
                    String id = t.nextLine();
                    Curso c = em.find(Curso.class, id);
                    System.out.println(c.getNombre() + " -- " + c.getTutor().getNombre());
                }
                case 3 -> {
                    System.out.println("Listado de cursos");
                    List<Curso> cursos = em.createNamedQuery("Curso.findAll", Curso.class).getResultList();
                    for (Curso c : cursos) {
                        System.out.println(c.getId() + " -- " + c.getNombre() + " -- " + c.getTutor().getNombre());
                    }
                }
                case 4 -> {
                    System.out.println("Listado de alumnos del curso");
                    String cursoId = t.nextLine();
                    Curso c = em.find(Curso.class, cursoId);
                    if (c != null) {
                        Set<Alumno> alumnos = c.getAlumnos();
                        for (Alumno a : alumnos) {
                            System.out.println(a.getId() + " -- " + a.getNombre() + " -- " + a.getNotaMedia());
                        }
                    }
                }
                case 0 -> {
                    System.out.println("Saliendo...");
                }
                default -> {
                    System.out.println("Opcion no valida");
                }
            }
        } while (op != 0) ;

        em.close();
        emf.close();
    }
}