package org.example.GestorBaseDatos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.example.Modelo.Cancion;
import org.example.Modelo.Grupo;
import org.example.Modelo.Usuario;

import java.util.List;

public class GBD {
    private EntityManager em;

    public GBD() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UDP");
        em = emf.createEntityManager();
    }

    public List<Usuario> nacidosDespues(int year){
        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.fechanac > :year", Usuario.class);
        query.setParameter("year", year);
        return query.getResultList();
    }

    public List<Grupo> gruposConMasCanciones(int n){
        TypedQuery<Grupo> query = em.createQuery("SELECT g FROM Grupo g WHERE SIZE(g.canciones) > :n", Grupo.class);
        query.setParameter("n", n);
        return query.getResultList();
    }

    public List<Cancion> getCancionesGrupos(List<String> grupos){
        TypedQuery<Cancion> query = em.createQuery("SELECT c FROM Cancion c WHERE c.grupo.nombre IN :grupos", Cancion.class);
        query.setParameter("grupos", grupos);
        return query.getResultList();
    }

    public List<Grupo> gruposLocalidadYear(String localidad, int year){
        TypedQuery<Grupo> query = em.createNamedQuery("Grupo.antesDe", Grupo.class);
        query.setParameter("localidad", localidad);
        query.setParameter("year", year);
        return query.getResultList();
    }

    /*Se escribe un listado con los nombres de localidades que tienen grupos musicales en la
tabla grupos y cuantos grupos tiene cada una de ellas.*/
    public List<Grupo> gruposLocalidad(){
        
    }



}
