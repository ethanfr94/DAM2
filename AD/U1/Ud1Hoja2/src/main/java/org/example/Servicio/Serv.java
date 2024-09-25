package org.example.Servicio;

import org.example.Conexion.Conn;

import java.sql.*;
import java.util.Scanner;

public class Serv {

    public static void menu() {
        int op;
        do {
            System.out.println("1 Obtener películas\n" +
                            "2 Obtener personajes\n" +
                            "3 Obtener personaje\n" +
                            "4 Obtener personajes de películas\n" +
                            "5 Obtener películas sin productora\n" +
                            "6 Obtener número de personajes por película\n" +
                            "7 Obtener película más antigua" +
                            "8 Obtener películas por actor\n" +
                            "9 Obtener películas sin personajes cargados");
            op = Integer.parseInt(System.console().readLine());
            switch (op) {
                case 1 -> listaPelis();
                case 2 -> listaPersonajes();
                case 3 -> heroeVillano();
                case 4 -> Actuaciones();
                case 5 -> sinProductora();
                case 6 -> intervenciones();
                case 7 -> masAntigua();
                case 8 ->
                case 9 ->
                case 0 -> {
                    System.out.println("cerrando el programa");
                    Conn.cerrar();
                }
                default -> System.out.println("opcion no valida");
            }
        } while (op != 0);
    }

    private static void listaPelis(){
        String sql = "select title, year, producer from movies;";
        Statement st = null;
        ResultSet rs = null;
        if(Conn.getConexion()!=null){
                try {
                    st = Conn.getConexion().createStatement();
                    rs = st.executeQuery(sql);
                    while (rs.next()) {
                        System.out.println(rs.getString("title")+" - "+rs.getInt("year")+" - "+rs.getString("producer"));
                        }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } finally {
                    cerrar(rs, st);
                }
        }
    }

    private static void listaPersonajes(){
        String sql = "select * from characters;";
        Statement st = null;
        ResultSet rs = null;
        if(Conn.getConexion()!=null){
            try {
                st = Conn.getConexion().createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String powers = rs.getString("powers");
                    String company = rs.getString("company");
                    String origin = rs.getString("origin")!=null?rs.getString("origin"):"Sin Cargar";
                    String isHero = rs.getInt("isHeroe")==1?"Heroe":"Villano";
                    System.out.printf("%-4d %-15s %-50s %-10s %-15s %-s", id, name, powers, company, origin, isHero);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                cerrar(rs, st);
            }
        }
    }

    private static void heroeVillano(){
        Scanner t = new Scanner(System.in);
        System.out.println("Introduce el id del personaje");
        int n = Integer.parseInt(t.nextLine());
        String sql = "select name, isHeroe from characters where id = "+n+";";
        Statement st = null;
        ResultSet rs = null;
        if(Conn.getConexion()!=null){
            try {
                st = Conn.getConexion().createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    String name = rs.getString("name");
                    String isHero = rs.getInt("isHeroe")==1?"Heroe":"Villano";
                    System.out.println(name+" - "+isHero);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                cerrar(rs, st);
            }
        }
    }

    private static void Actuaciones(){
        String sql = "select title, year, name, actor from acts inner join characters on acts.character_id=characters.id inner join movies on acts.movie_id=movies.id;";
        Statement st = null;
        ResultSet rs = null;
        if(Conn.getConexion()!=null){
            try {
                st = Conn.getConexion().createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    String title = rs.getString("title");
                    int year = rs.getInt("year");
                    String name = rs.getString("name");
                    String actor = rs.getString("actor");
                    System.out.println(title+" - "+year+" - "+name+" - "+actor);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                cerrar(rs, st);
            }
        }
    }

    private static void sinProductora(){
        String sql = "select * from movies where producer is null;";
        Statement st = null;
        ResultSet rs = null;
        if(Conn.getConexion()!=null){
            try {
                st = Conn.getConexion().createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    int duration = rs.getInt("duration");
                    int year = rs.getInt("year");
                    System.out.println(id+" - "+title+" - "+duration+" - "+year);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                cerrar(rs, st);
            }
        }
    }

    private static void intervenciones(){
        String sql = "select title, count(character_id) from movies inner join acts on movies.id=movie_id group by title;";
        Statement st = null;
        ResultSet rs = null;
        if(Conn.getConexion()!=null){
            try {
                st = Conn.getConexion().createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    String title = rs.getString("title");
                    int n = rs.getInt("count(character_id)");
                    System.out.println(title+" - personajes: "+n);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                cerrar(rs, st);
            }
        }
    }

    private static void masAntigua(){
        String sql = "select * from movies where year is not null order by year asc limit 1;";
        Statement st = null;
        ResultSet rs = null;
        if(Conn.getConexion()!=null){
            try {
                st = Conn.getConexion().createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    int duration = rs.getInt("duration");
                    int year = rs.getInt("year");
                    String producer = rs.getString("producer");
                    System.out.println(id+" - "+title+" - "+duration+" - "+year+" - "+producer);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                cerrar(rs, st);
            }
        }
    }


    private static void cerrar(ResultSet rs, Statement st) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
