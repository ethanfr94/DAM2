package org.example.Servicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.Modelo.DescargaTotale;
import org.example.Modelo.Solicitude;
import org.example.Modelo.Track;
import org.example.Modelo.Usuario;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Srv {

    private static List<Track> tracks;
    private static List<Solicitude> solicitudes;

    private static List<Track> cargaTracks(EntityManager em) {
        return em.createNamedQuery("Track.findAll").getResultList();
    }

    private static List<Track> cargaSolicitudes(EntityManager em) {
        return em.createNamedQuery("Solicitud.findAll").getResultList();
    }

    public static boolean agragarTrack(EntityManager em){
        tracks = cargaTracks(em);
        Scanner t = new Scanner(System.in);
        boolean ok = false;
        try {

            Track track = new Track();
            System.out.println("Introduce titulo");
            track.setTitulo(t.nextLine());
            System.out.println("Introduce interprete");
            track.setInterprete(t.nextLine());
            System.out.println("Introduce duracion");
            track.setDurSeg(Integer.parseInt(t.nextLine()));
            System.out.println("Introduce año");
            track.setAnno(Short.parseShort(t.nextLine()));
            track.setNumDescargas((short) 0);
            track.setDisponible((byte) 1);

            for (Track tr: tracks){
                if (!tr.getTitulo().equalsIgnoreCase(track.getTitulo())){
                    em.getTransaction().begin();
                    em.persist(track);
                    em.getTransaction().commit();
                }
                else{
                    System.out.println("Titulo ya existente");
                }
            }
        }catch (Exception e) {
        }
        return ok;
    }

    public static boolean ActualizarDatosPorFinalizacionDescargas(EntityManager em){
        boolean ok = false;
        solicitudes = em.createNamedQuery("Solicitud.findAll").getResultList();
        for (Solicitude sol: solicitudes){
            try{
                if(sol.getFinalizada()==1) {

                    DescargaTotale dt = em.find(DescargaTotale.class, sol.getId());
                    if (dt != null) {
                        em.getTransaction().begin();
                        dt.setTotal(dt.getTotal() + 1);
                        em.getTransaction().commit();
                    } else {
                        em.getTransaction().begin();
                        dt.setNumAudio(sol.getAudio());
                        dt.setNumUsuario(sol.getUsuario());
                        dt.setTotal(1);
                        em.persist(dt);
                        em.getTransaction().commit();
                    }
                }
                ok = true;
            }catch (Exception e) {
                System.out.println("Error al agregar descarga");
                System.out.println(e.getMessage());

                em.getTransaction().rollback();
            }
        }
        return ok;
    }

    public static boolean addSolicitud(EntityManager em){
        boolean ok = false;
        Scanner t = new Scanner(System.in);
        try{
            em.getTransaction().begin();
            System.out.println("Introduce id de usuario");
            int idUsu = Integer.parseInt(t.nextLine());
            if(em.find(Usuario.class, idUsu) != null){
                System.out.println("Usuario no encontrado");
                em.getTransaction().rollback();
                return false;
            }
            System.out.println("Introduce id de Track");
            int idtrack = Integer.parseInt(t.nextLine());
            if(em.find(Track.class, idtrack) != null){
                System.out.println("Track no encontrado");
                em.getTransaction().rollback();
                return false;
            }
            Solicitude sol = new Solicitude();
            sol.setUsuario(em.find(Usuario.class, idUsu));
            sol.setAudio(em.find(Track.class, idtrack));
            sol.setFecha(LocalDate.now());
            sol.setHora(LocalTime.now());

            em.persist(sol);
            em.getTransaction().commit();

            ok = true;

        }catch (Exception e) {
            System.out.println("Error al agregar solicitud");
            System.out.println(e.getMessage());

            em.getTransaction().rollback();
        }
        return ok;
    }

    public static List<Solicitude> porUsuarioId(EntityManager em, String usu, String pass){
        TypedQuery<Usuario> query = em.createQuery("select u from Usuario u where u.usuario = :usu and u.contra = :pass", Usuario.class);
        query.setParameter("usu", usu);
        query.setParameter("pass", pass);
        Usuario user = query.getSingleResult();
        TypedQuery<Solicitude> sql = em.createQuery("SELECT s FROM Solicitude s where s.usuario.usuario = :idUsuario and s.finalizada = 0", Solicitude.class);
        sql.setParameter("idUsuario", user.getId());
        return sql.getResultList();
    }

    public static List<String> masDescargas(EntityManager em, int num){
        TypedQuery<DescargaTotale> sql = em.createQuery("select d from DescargaTotale d where d.total > :num", DescargaTotale.class);
        sql.setParameter("num", num);
        List<DescargaTotale> descargas = sql.getResultList();
        List<String> datos = new ArrayList<>();
        for (DescargaTotale dt : descargas){
            String s = dt.getNumUsuario().getNombre()+" "+dt.getNumUsuario().getApellidos()+" -- "+dt.getNumAudio().getTitulo();
            datos.add(s);
        }
        return datos;
    }

    public static boolean eliminaNoDisponibles(EntityManager em){
        boolean ok= false;
        List<DescargaTotale> descargas = em.createNamedQuery("DescargasTotale.elimina", DescargaTotale.class).getResultList();
        for (DescargaTotale dt : descargas){
            try {
                em.getTransaction().begin();
                em.remove(dt);
                em.getTransaction().commit();
                ok = true;
            }
            catch (Exception e) {}
        }
        return ok;
    }
}
