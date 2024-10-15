package Conexion;

import Modelo.Charac;
import Modelo.Mov;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Serv {
    public static List<Charac> listarPersonajes(Connection con) {
        List<Charac> lista = new ArrayList<>();
        String sql = "SELECT id, name, powers, company, origin, isheroe FROM characters";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Charac c = new Charac();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setPowers(rs.getString("powers"));
                c.setCompany(rs.getString("company"));
                c.setOrigin(rs.getString("origin"));
                c.setIsHeroe(rs.getBoolean("isheroe"));
                lista.add(c);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error al mostrar personajes");
        }
        return lista;
    }

    public static List<Mov> mostrarPeliculas(Connection con) {
        List<Mov> lista = new ArrayList<>();
        String sql = "SELECT id, title, duration, year, producer FROM movies";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Mov m = new Mov();
                m.setId(rs.getInt("id"));
                m.setTitle(rs.getString("title"));
                m.setDuration(rs.getInt("duration"));
                m.setYear(rs.getInt("year"));
                m.setProducer(rs.getString("producer"));
                lista.add(m);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error al mostrar peliculas");
        }
        return lista;
    }

    public static boolean addPersonaje(Connection con, Scanner tec, List<Charac> lista) {
        boolean ok = false;
        String sql = "SELECT id, name, powers, company, origin, isheroe FROM characters";
        try {
            Statement ps = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery(sql);
            rs.moveToInsertRow();
            System.out.println("Nombre:");
            String nombre = tec.nextLine();
            for (Charac c : lista) {
                if (c.getName().equalsIgnoreCase(nombre)) {
                    System.out.println("Ya existe un personaje con ese nombre");
                    return ok;
                }
            }
            rs.updateString("name", nombre);
            System.out.println("Poderes:");
            rs.updateString("powers", tec.nextLine());
            System.out.println("Compañía:");
            rs.updateString("company", tec.nextLine());
            System.out.println("Origen:");
            rs.updateString("origin", tec.nextLine());
            System.out.println("¿Es héroe? (s/n):");
            rs.updateInt("isheroe", tec.nextLine().equalsIgnoreCase("s")?1:0);
            rs.insertRow();
            System.out.println("Personaje añadido");
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error al añadir personaje");
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error al añadir personaje");

        }
        return ok;
    }

    public static boolean addPelicula(Connection con, Scanner tec, List<Mov> lista) {
        boolean ok = false;
        String sql = "select id, title, duration, year, producer from movies";
        try {
            Statement ps = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery(sql);
            rs.moveToInsertRow();
            System.out.println("Título:");
            String titulo = tec.nextLine();
            for (Mov m : lista) {
                if (m.getTitle().equalsIgnoreCase(titulo)) {
                    System.out.println("Ya existe una película con ese título");
                    return ok;
                }
            }
            rs.updateString("title", titulo);
            System.out.println("Duración:");
            rs.updateInt("duration", Integer.parseInt(tec.nextLine()));
            System.out.println("Año:");
            rs.updateInt("year", Integer.parseInt(tec.nextLine()));
            System.out.println("Productora:");
            rs.updateString("producer", tec.nextLine());
            rs.insertRow();
            ok = true;
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error al añadir película");
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error al añadir película");
        }
        return ok;
    }

    public static boolean addActuacion(Connection con, Scanner tec, List<Charac> listaPersonajes, List<Mov> listaPeliculas) {
        boolean ok = false;
        String sql = "select id, character_id, movie_id, minutes_in_movie, main_character, actor from acts";
        try {
            Statement ps = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery(sql);
            rs.moveToInsertRow();
            System.out.println("Id personaje:");
            int idPersonaje = Integer.parseInt(tec.nextLine());
            boolean personajeEncontrado = false;
            for (Charac c : listaPersonajes) {
                if (c.getId() == idPersonaje) {
                    personajeEncontrado = true;
                    break;
                }
            }
            System.out.println("Id película:");
            int idPelicula = Integer.parseInt(tec.nextLine());
            boolean peliculaEncontrada = false;
            for (Mov m : listaPeliculas) {
                if (m.getId() == idPelicula) {
                    peliculaEncontrada = true;
                    break;
                }
            }
            if(!personajeEncontrado || !peliculaEncontrada) {
                System.out.println("Personaje o película no encontrados");
                return ok;
            }
            rs.updateInt("character_id", idPersonaje);
            rs.updateInt("movie_id", idPelicula);
            System.out.println("Minutos en pantalla:");
            rs.updateInt("minutes_in_movie", Integer.parseInt(tec.nextLine()));
            System.out.println("Personaje principal (s/n):");
            rs.updateBoolean("main_character", tec.nextLine().equalsIgnoreCase("s")?true:false);
            System.out.println("Actor:");
            rs.updateString("actor", tec.nextLine());
            rs.insertRow();
            ok = true;
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error al añadir actuación");
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error al añadir actuación");

        }
        return ok;
    }
    public static boolean deleteActuacion(Connection con, Scanner tec) {
        boolean ok = false;
        String sql = "select id, character_id, movie_id, minutes_in_movie, main_character, actor from acts";
        try {
            Statement ps = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                System.out.printf("%-3d - %-3d - %-5d - %-15s - %s\n", rs.getInt("character_id"), rs.getInt("movie_id"), rs.getInt("minutes_in_movie"), rs.getBoolean("main_character")?"Principal":"Secundario", rs.getString("actor"));
                System.out.println("¿Eliminar? (s/n):");
                if (tec.nextLine().equalsIgnoreCase("s")) {
                    rs.deleteRow();
                    ok = true;
                }
            }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error al eliminar actuación");
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error al eliminar actuación");

        }
        return ok;
    }
}
