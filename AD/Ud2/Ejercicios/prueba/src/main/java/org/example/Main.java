package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.example.modelo.Heroe;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Heroe emp1 = new Heroe();
        emp1.setId(1L);
        emp1.setNombre("Spiderman");
        emp1.setRango(8);
        em.persist(emp1);

        Heroe emp2 = new Heroe();
        emp2.setId(2L);
        emp2.setNombre("Thor");
        emp2.setRango(7);
        em.persist(emp2);



        em.getTransaction().commit();

        TypedQuery<Heroe> query = em.createQuery("SELECT h FROM Heroe h", Heroe.class);
        List<Heroe> heroes = query.getResultList();

        var heroes2= em.createQuery("SELECT h FROM Heroe h"/*"from Heroe" es lo mismo*/, Heroe.class).getResultList();
        heroes2.forEach(heroe -> System.out.println(heroe.getNombre()));

        em.close();
        emf.close();
    }
}