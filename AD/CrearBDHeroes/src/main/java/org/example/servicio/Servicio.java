package org.example.servicio;

import org.example.conexion.BD;
import org.example.modelos.acts;
import org.example.modelos.characters;
import org.example.modelos.movies;

import java.sql.PreparedStatement;

public class Servicio {

    public static void menu(){
        System.out.println("1.Añadir pelicula\n" +
                "2.Añadir actuacion\n" +
                "3.Añadir personaje\n" +
                "4.Modificar origen del personaje\n" +
                "5.Modificar año de la pelicula\n" +
                "6.Eliminar actuacion\n" +
                "7.Eliminar peliculaºn" +
                "8.Modificar productora\n" +
                "0.Salir");
        int op = Integer.parseInt(System.console().readLine());
        switch (op){
            case 1: addPelicula();
            case 2: addActuacion();
            case 3: addPersonaje();
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 0:
            default:
        }
    }

    public static int addPelicula(){
        movies m = new movies();
        System.out.println("Introduce titulo de la pelicula");
        String titulo = System.console().readLine();
        System.out.println("Introduce duracion de la pelicula");
        int duracion = Integer.parseInt(System.console().readLine());
        m.setTitle(titulo);
        m.setDuration(duracion);

        int n = -1;
        PreparedStatement st = null;
        if (BD.getConexion() != null) {
            String sql = " insert into movies (title, duration) values (?,?)";
            try {
                st=BD.getConexion().prepareStatement(sql);
                st.setString(1,m.getTitle());
                st.setInt(2,m.getDuration());
                n = st.executeUpdate();
                System.out.println(n+" lineas afectadas.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally{
                BD.cerrar();
            }
        }
        return n;
    }

    public static int addActuacion(){
        acts a = new acts();
        System.out.println("Introduce id de la pelicula");
        int idpeli = Integer.parseInt(System.console().readLine());
        System.out.println("Introduce id del personaje");
        int idpers = Integer.parseInt(System.console().readLine());
        System.out.println("Introduce actor");
        String actor = System.console().readLine();
        System.out.println("1.personaje principal\n0.personaje secundario");
        int pr = Integer.parseInt(System.console().readLine());
        a.setMovie_id(idpers);
        a.setCharacter_id(idpeli);
        a.setActor(actor);
        a.setMain(pr==1);

        int n = -1;
        PreparedStatement st = null;
        if (BD.getConexion() != null) {
            String sql = " insert into acts (movie_id, character_id, actor, main_character) values (?,?,?,?)";
            try {
                st=BD.getConexion().prepareStatement(sql);
                st.setInt(1,a.getMovie_id());
                st.setInt(2,a.getCharacter_id());
                st.setString(3,a.getActor());
                st.setInt(4,a.isMain() ? 1 : 0);
                n = st.executeUpdate();
                System.out.println(n+" lineas afectadas.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally{
                BD.cerrar();
            }
        }
        return n;
    }

    public static int addPersonaje(){
        characters p = new characters();
        System.out.println("Introduce nombre");
        String nombre = System.console().readLine();
        System.out.println("Introduce poderes");
        String poderes = System.console().readLine();
        System.out.println("Introduce productora");
        String productora = System.console().readLine();
        System.out.println("Introduce origen");
        String origen = System.console().readLine();
        System.out.println("1.Heroe\n0.No heroe");
        int h = Integer.parseInt(System.console().readLine());
        p.setName(nombre);
        p.setPowers(poderes);
        p.setCompany(productora);
        p.setOrigin(origen);
        p.setIsHeroe(h);

        int n = -1;
        PreparedStatement st = null;
        if (BD.getConexion() != null) {
            String sql = "insert into characters (name, powers, company, origin, isHeroe) values (?,?,?,?,?)";
            try {
                st=BD.getConexion().prepareStatement(sql);
                st.setString(1,p.getName());
                st.setString(2,p.getPowers());
                st.setString(3,p.getCompany());
                st.setString(4,p.getOrigin());
                st.setInt(5,p.getIsHeroe());
                n = st.executeUpdate();
                System.out.println(n+" lineas afectadas.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally{
                BD.cerrar();
            }
        }
        return n;
    }



}
