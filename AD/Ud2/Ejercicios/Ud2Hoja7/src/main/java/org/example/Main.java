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
                    System.out.println(a.getNombre()+" -- "+a.getCurso().getId()+" -- "+a.getNotaMedia());
                }
                case 2 -> {
                    System.out.println("Introduce el id del curso");
                    String id = t.nextLine();
                    Curso c = em.find(Curso.class, id);
                    System.out.println(c.getNombre()+" -- "+c.getTutor().getNombre());
                }
                case 3 -> {
                    System.out.println("Listado de cursos");
                    boolean hayCursos = true;
                    int cursos = 1;
                    while (hayCursos) {
                        Curso c = em.find(Curso.class, cursos++);
                        if (c != null) {
                            System.out.println(c.getNombre()+" -- "+c.getTutor().getNombre());
                        } else {
                            hayCursos = false;
                        }
                    }


                }
                case 4 -> {
                    System.out.println("Listado de alumnos del curso");
                    String cursoId = t.nextLine();
                    if(em.find(Curso.class, cursoId) != null){
                        boolean hayAlumnos = true;
                        int alumnos = 1;
                        while (hayAlumnos) {
                            Alumno a = em.find(Alumno.class, alumnos++);
                            if (a != null) {
                                if(a.getCurso().getId().equals(cursoId)){
                                    System.out.println(a.getNombre()+" -- "+a.getNotaMedia());
                                }
                            } else {
                                hayAlumnos = false;
                            }
                        }
                    }else{
                        System.out.println("Curso no encontrado");
                    }
                }
                case 0 -> {
                    System.out.println("Saliendo...");
                }
                default -> {
                    System.out.println("Opcion no valida");
                }
            }
        }while (op != 0);

        em.close();
        emf.close();
    }
}