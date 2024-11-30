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

    /*Se pide por teclado un año y se obtiene un listado con el nombre y apellidos de los usuarios nacidos a partir de ese año. */
    public List<Usuario> nacidosDespues(int year){
        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.fechanac > :year", Usuario.class);
        query.setParameter("year", year);
        return query.getResultList();
    }
    /*Se pide un número por teclado y se obtienen los nombres de grupos que tienen más canciones que ese número
    recogido por teclado. Usa una NamedQuery para ello */
    public List<Grupo> gruposConMasCanciones(int n){
        TypedQuery<Grupo> query = em.createNamedQuery("Grupo.masCanciones", Grupo.class);
        query.setParameter("n", n);
        return query.getResultList();
    }
    /*Se piden por teclado los nombres de varios grupos y se realiza un listado con todas las canciones de esos grupos
    y el nombre del grupo al que pertenece cada canción. */
    public List<Cancion> getCancionesGrupos(List<String> grupos){
        TypedQuery<Cancion> query = em.createQuery("SELECT c FROM Cancion c WHERE c.grupo.nombre IN :grupos", Cancion.class);
        query.setParameter("grupos", grupos);
        return query.getResultList();
    }

    /*Se pide el nombre de una localidad y un año por teclado y se muestra un listado de todos los grupos de la localidad
    que han grabado su primer disco antes del año recogido. Usa una NamedQuery para ello */
    public List<Grupo> gruposLocalidadYear(String localidad, int year){
        TypedQuery<Grupo> query = em.createNamedQuery("Grupo.antesDe", Grupo.class);
        query.setParameter("localidad", localidad);
        query.setParameter("year", year);
        return query.getResultList();
    }

    /*Se escribe un listado con los nombres de localidades que tienen grupos musicales en la
tabla grupos y cuantos grupos tiene cada una de ellas.*/
    public List<String> gruposLocalidad(){
        TypedQuery<String> query = em.createQuery("SELECT g.localidad, COUNT(g) FROM Grupo g GROUP BY g.localidad", String.class);
        return query.getResultList();
    }



}
