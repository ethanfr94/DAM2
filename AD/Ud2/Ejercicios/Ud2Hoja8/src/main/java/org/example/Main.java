package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jdk.swing.interop.SwingInterOpUtils;
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
                    
                    1.MODIFICAR NOMBRE DEL CURSO
                    2.AÑADIR CURSO
                    3.AÑADIR O MODIFICAR CURSO
                    4.MODIFICAR TUTOR DE CURSO
                    5.ELIMINAR ALUMNO
                    0.SALIR
                    """);
            op = Integer.parseInt(t.nextLine());
            switch (op) {
                case 1 -> {
                    System.out.println("Introduce el id del curso");
                    String id = t.nextLine();
                    Curso curso = em.find(Curso.class, id);
                    if (curso != null) {
                        System.out.println("Curso: " + curso.getNombre());
                        System.out.println("Introduce el nuevo nombre del curso");
                        String nombre = t.nextLine();
                        em.getTransaction().begin();
                        curso.setNombre(nombre);
                        em.getTransaction().commit();
                    } else {
                        System.out.println("Curso no encontrado");
                        em.getTransaction().rollback();
                    }
                }
                case 2 -> {
                    System.out.println("Introduce el id del curso");
                    String id = t.nextLine();
                    System.out.println("Introduce el nombre del curso");
                    String nombre = t.nextLine();
                    Curso c = new Curso();
                    c.setId(id);
                    c.setNombre(nombre);
                    System.out.println("Introduce el id del tutor");
                    Profesor tutor = em.find(Profesor.class, Integer.parseInt(t.nextLine()));
                    do {
                        if (tutor != null) {
                            c.setTutor(tutor);
                        } else {
                            System.out.println("Tutor no encontrado");
                        }
                    }while (tutor == null);

                    try{
                        em.getTransaction().begin();
                        em.persist(c);
                        em.getTransaction().commit();
                    }catch (Exception e){
                        System.out.println("Error al añadir el curso");
                        System.out.println(e.getMessage());
                        em.getTransaction().rollback();
                    }
                }
                case 3 -> {
                    System.out.println("Introduce el id del curso");
                    String id = t.nextLine();
                    System.out.println("Introduce el nombre del curso");
                    String nombre = t.nextLine();
                    Curso c = em.find(Curso.class, id);
                    if (c != null) {
                        em.getTransaction().begin();
                        c.setNombre(nombre);
                        em.getTransaction().commit();
                    } else {
                        em.getTransaction().begin();
                        Curso curso = new Curso();
                        curso.setId(id);
                        curso.setNombre(nombre);
                        System.out.println("Introduce el id del tutor");
                        Profesor tutor = em.find(Profesor.class, Integer.parseInt(t.nextLine()));
                        do {
                            if (tutor != null) {
                                curso.setTutor(tutor);
                            } else {
                                System.out.println("Tutor no encontrado");
                            }
                        }while (tutor == null);
                        em.persist(curso);
                        em.getTransaction().commit();
                    }

                }
                case 4 -> {
                    System.out.println("Introduce el id del curso para cambiar el tutor");
                    String id = t.nextLine();
                    Curso curso = em.find(Curso.class, id);
                    if (curso != null) {
                        System.out.println("Curso: " + curso.getNombre()+ " Tutor: " + curso.getTutor().getNombre());
                        System.out.println("Introduce el id del profesor para asignar como tutor");
                        int idProfesor = Integer.parseInt(t.nextLine());
                        Profesor tutor = em.find(Profesor.class, idProfesor);
                        if (tutor != null) {
                            em.getTransaction().begin();
                            curso.setTutor(tutor);
                            em.getTransaction().commit();
                        } else {
                            System.out.println("Profesor no encontrado");
                            em.getTransaction().rollback();
                        }
                    } else {
                        System.out.println("Curso no encontrado");
                    }
                }
                case 5 -> {
                    System.out.println("Introduce el id del alumno");
                    int id = Integer.parseInt(t.nextLine());
                    Alumno a = em.find(Alumno.class, id);
                    if (a != null) {
                        em.getTransaction().begin();
                        em.remove(a);
                        em.getTransaction().commit();
                    } else {
                        System.out.println("Alumno no encontrado");
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