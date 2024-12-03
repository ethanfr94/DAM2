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
    // Entity Manager para la conexión con la base de datos
    private EntityManager em;

    // Constructor que inicializa el Entity Manager para la conexión con la base de datos
    public GBD() {
        // Se crea el Entity Manager Factory con el nombre de la unidad de persistencia que se ha definido en el archivo persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UDP");
        // Se crea el Entity Manager para la conexión con la base de datos a través del Entity Manager Factory
        em = emf.createEntityManager();
    }

    /*Se pide por teclado un año y se obtiene un listado con el nombre y apellidos de los usuarios nacidos a partir de ese año. */
    public List<Usuario> nacidosDespues(int year){
        // Se crea una consulta con un parámetro que se recoge por teclado
        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.fechanac > :year", Usuario.class);
        // Se asigna el valor al parámetro de la consulta
        query.setParameter("year", year);
        // Se ejecuta la consulta y se devuelve el resultado
        return query.getResultList();
    }
    /*Se pide un número por teclado y se obtienen los nombres de grupos que tienen más canciones que ese número
    recogido por teclado. Usa una NamedQuery para ello */
    public List<Grupo> gruposConMasCanciones(int n){
        // Se crea una consulta con un parámetro que se recoge por teclado
        TypedQuery<Grupo> query = em.createNamedQuery("Grupo.masCanciones", Grupo.class);
        // Se asigna el valor al parámetro de la consulta
        query.setParameter("n", n);
        // Se ejecuta la consulta y se devuelve el resultado
        return query.getResultList();
    }
    /*Se piden por teclado los nombres de varios grupos y se realiza un listado con todas las canciones de esos grupos
    y el nombre del grupo al que pertenece cada canción. */
    public List<Cancion> getCancionesGrupos(List<String> grupos){
        // Se crea una consulta con un parámetro que se recoge por teclado
        TypedQuery<Cancion> query = em.createQuery("SELECT c FROM Cancion c WHERE c.grupo.nombre IN :grupos", Cancion.class);
        // Se asigna el valor al parámetro de la consulta
        query.setParameter("grupos", grupos);
        // Se ejecuta la consulta y se devuelve el resultado
        return query.getResultList();
    }

    /*Se pide el nombre de una localidad y un año por teclado y se muestra un listado de todos los grupos de la localidad
    que han grabado su primer disco antes del año recogido. Usa una NamedQuery para ello */
    public List<Grupo> gruposLocalidadYear(String localidad, int year){
        // Se crea una consulta con dos parámetros que se recogen por teclado
        TypedQuery<Grupo> query = em.createNamedQuery("Grupo.antesDe", Grupo.class);
        // Se asigna el valor a los parámetros de la consulta
        query.setParameter("localidad", localidad);
        query.setParameter("year", year);
        // Se ejecuta la consulta y se devuelve el resultado
        return query.getResultList();
    }

    /*Se escribe un listado con los nombres de localidades que tienen grupos musicales en la
tabla grupos y cuantos grupos tiene cada una de ellas.*/
    public List<String> gruposLocalidad(){
        // Se crea una consulta que devuelve el nombre de la localidad y el número de grupos que hay en cada una
        TypedQuery<String> query = em.createQuery("SELECT g.localidad, COUNT(g) FROM Grupo g GROUP BY g.localidad", String.class);
        // Se ejecuta la consulta y se devuelve el resultado
        return query.getResultList();
    }



}
