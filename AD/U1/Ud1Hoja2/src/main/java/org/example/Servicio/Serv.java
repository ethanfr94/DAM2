package org.example.Servicio;

import org.example.Conexion.Conn;
import org.example.Modelos.Acts;
import org.example.Modelos.Charac;
import org.example.Modelos.Mov;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
                case 8 -> porActor();
                case 9 ->
                case 0 -> {
                    System.out.println("cerrando el programa");
                    Conn.cerrar();
                }
                default -> System.out.println("opcion no valida");
            }
        } while (op != 0);
    }

    private static void listaPelis() {
        List<Mov> pelis = new ArrayList<>();
        String sql = "select * from movies;";
        Statement st = null;
        ResultSet rs = null;
        if (Conn.getConexion() != null) {
            try {
                st = Conn.getConexion().createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    Mov m = new Mov();
                    m.setId(rs.getInt("id"));
                    m.setTitle(rs.getString("title"));
                    m.setDuration(rs.getInt("duration"));
                    m.setYear(rs.getInt("year"));
                    m.setProducer(rs.getString("producer"));
                    pelis.add(m);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                cerrar(rs, st);
            }
        }
    }

    private static void listaPersonajes() {
        List<Charac> ch = new ArrayList<>();
        String sql = "select * from characters;";
        Statement st = null;
        ResultSet rs = null;
        if (Conn.getConexion() != null) {
            try {
                st = Conn.getConexion().createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    Charac pers = new Charac();
                    pers.setId(rs.getInt("id"));
                    pers.setName(rs.getString("name"));
                    pers.setPowers(rs.getString("powers"));
                    pers.setCompany(rs.getString("company"));
                    pers.setOrigin(rs.getString("origin"));
                    pers.setIsHeroe(rs.getInt("isHeroe"));
                    ch.add(pers);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                cerrar(rs, st);
            }
        }
    }

    private static void listaActuaciones() {
        List<Acts> act = new ArrayList<>();
        String sql = "select * from acts;";
        Statement st = null;
        ResultSet rs = null;
        if (Conn.getConexion() != null) {
            try {
                st = Conn.getConexion().createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    Acts a = new Acts();
                    Mov m = new Mov();
                    Charac c = new Charac();
                    a.setId(rs.getInt("id"));
                    int peli = rs.getInt("movie_id");
                    m = moviePorId(peli);
                    a.setMov(m);
                    int pers = rs.getInt("character_id");
                    c = characterPorId(pers);
                    a.setCharac(c);
                    a.setMinutes(rs.getInt("minutes"));
                    a.setMain(rs.getBoolean("main"));
                    a.setActor(rs.getString("actor"));
                    act.add(a);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                cerrar(rs, st);
            }
        }
    }

    private static void verPelis(List <Mov> pelis) {
        for (Mov m : pelis) {
            System.out.printf("%-4d %-50s %-5d %-4d %-s",
                    m.getId(), m.getTitle(), m.getDuration(), m.getYear(), m.getProducer());
        }
    }

    private static void verPersonajes(List <Charac> ch) {
        for (Charac c : ch) {
            System.out.printf("%-4d %-15s %-50s %-15s %-15s %-s",
                    c.getId(), c.getName(), c.getPowers(), c.getCompany(), c.getOrigin(), c.getIsHeroe()==1? "Heroe" : "Villano");
        }
    }

    private static void verActuaciones(List <Acts> act) {
        for (Acts a : act) {
            System.out.print(a.getId()+" - "+a.getMov().getTitle()+" - "+a.getCharac().getName()+" - "+a.getMinutes()+" - "+a.isMain()+" - "+a.getActor());
        }
    }

    private static void heroeVillano() {
        Scanner t = new Scanner(System.in);
        System.out.println("Introduce el id del personaje");
        int n = Integer.parseInt(t.nextLine());
        String sql = "select name, isHeroe from characters where id = " + n + ";";
        Statement st = null;
        ResultSet rs = null;
        if (Conn.getConexion() != null) {
            try {
                st = Conn.getConexion().createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    String name = rs.getString("name");
                    String isHero = rs.getInt("isHeroe") == 1 ? "Heroe" : "Villano";
                    System.out.println(name + " - " + isHero);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                cerrar(rs, st);
            }
        }
    }

    private static void Actuaciones() {
        String sql = "select title, year, name, actor from acts inner join characters on acts.character_id=characters.id inner join movies on acts.movie_id=movies.id;";
        Statement st = null;
        ResultSet rs = null;
        if (Conn.getConexion() != null) {
            try {
                st = Conn.getConexion().createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    String title = rs.getString("title");
                    int year = rs.getInt("year");
                    String name = rs.getString("name");
                    String actor = rs.getString("actor");
                    System.out.println(title + " - " + year + " - " + name + " - " + actor);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                cerrar(rs, st);
            }
        }
    }

    private static void sinProductora() {
        String sql = "select * from movies where producer is null;";
        Statement st = null;
        ResultSet rs = null;
        if (Conn.getConexion() != null) {
            try {
                st = Conn.getConexion().createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    int duration = rs.getInt("duration");
                    int year = rs.getInt("year");
                    System.out.println(id + " - " + title + " - " + duration + " - " + year);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                cerrar(rs, st);
            }
        }
    }

    private static void intervenciones() {
        String sql = "select title, count(character_id) from movies inner join acts on movies.id=movie_id group by title;";
        Statement st = null;
        ResultSet rs = null;
        if (Conn.getConexion() != null) {
            try {
                st = Conn.getConexion().createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    String title = rs.getString("title");
                    int n = rs.getInt("count(character_id)");
                    System.out.println(title + " - personajes: " + n);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                cerrar(rs, st);
            }
        }
    }

    private static void masAntigua() {
        String sql = "select * from movies where year is not null order by year asc limit 1;";
        Statement st = null;
        ResultSet rs = null;
        if (Conn.getConexion() != null) {
            try {
                st = Conn.getConexion().createStatement();
                rs = st.executeQuery(sql);

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    int duration = rs.getInt("duration");
                    int year = rs.getInt("year");
                    String producer = rs.getString("producer");
                    System.out.println(id + " - " + title + " - " + duration + " - " + year + " - " + producer);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                cerrar(rs, st);
            }
        }
    }

    private static void porActor() {
        Scanner t = new Scanner(System.in);
        System.out.println("introduce nombre del actor");
        String actor = t.nextLine();
        String sql = "select title from movies inner join acts on acts.movie_id=movies.id where actor = ?;";
        PreparedStatement st = null;
        ResultSet rs = null;
        if (Conn.getConexion() != null) {
            try {
                st = Conn.getConexion().prepareStatement(sql);
                st.setString(1, actor);
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    System.out.println(rs.getString("title"));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                cerrar(rs, st);
            }
        }
    }


    private static void cerrar(ResultSet rs, PreparedStatement st) {
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

    public static Charac characterPorId(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Charac ch = null;
        String sql = "select id, name, powers, company, origin, isHeroe from characters where id = ?;";

        try {
            ps = Conn.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                ch.setId(rs.getInt("id"));
                ch.setName(rs.getString("name"));
                ch.setPowers(rs.getString("powers"));
                ch.setCompany(rs.getString("company"));
                ch.setOrigin(rs.getString("origin"));
                ch.setIsHeroe(rs.getInt("isHeroe"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            cerrar(rs, ps);
        }

        return ch;
    }

    public static Mov moviePorId(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Mov m = null;
        String sql = "select id, name, powers, company, origin, isHeroe from characters where id = ?;";

        try {
            ps = Conn.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                m.setId(rs.getInt("id"));
                m.setTitle(rs.getString("title"));
                m.setDuration(rs.getInt("duration"));
                m.setYear(rs.getInt("year"));
                m.setProducer(rs.getString("producer"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            cerrar(rs, ps);
        }

        return m;
    }

}
