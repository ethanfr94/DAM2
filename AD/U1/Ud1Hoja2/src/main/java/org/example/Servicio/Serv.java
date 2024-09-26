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
                    "7 Obtener película más antigua\n" +
                    "8 Obtener películas por actor\n" +
                    "9 Obtener películas sin personajes cargados");
            op = Integer.parseInt(System.console().readLine());
            switch (op) {
                case 1 -> verPelis(listaPelis());
                case 2 -> verPersonajes(listaPersonajes());
                case 3 -> heroeVillano();
                case 4 -> verActuaciones(listaActuaciones());
                case 5 -> sinProductora(listaPelis());
                case 6 -> intervenciones();
                case 7 -> masAntigua(listaPelis());
                case 8 -> verPorActor(porActor());
                case 9 -> verSinPersonajes(sinPersonajes());
                case 0 -> {
                    System.out.println("cerrando el programa");
                    Conn.cerrar();
                }
                default -> System.out.println("opcion no valida");
            }
        } while (op != 0);
    }

    private static List<Mov> listaPelis() {
        List<Mov> pelis = new ArrayList<>();
        String sql = "select * from movies;";
        Statement st = null;
        ResultSet rs = null;
        if (Conn.getConexion() != null) {
            try {
                st = Conn.getConexion().createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    Mov m = rsToMov(rs);
                    pelis.add(m);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                cerrar(rs, st);
            }
        }
        return pelis;
    }

    private static List<Charac> listaPersonajes() {
        List<Charac> ch = new ArrayList<>();
        String sql = "select * from characters;";
        Statement st = null;
        ResultSet rs = null;
        if (Conn.getConexion() != null) {
            try {
                st = Conn.getConexion().createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    Charac pers = rsToCharac(rs);
                    ch.add(pers);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                cerrar(rs, st);
            }
        }
        return ch;
    }

    private static List<Acts> listaActuaciones() {
        List<Acts> act = new ArrayList<>();
        String sql = "select * from acts;";
        Statement st = null;
        ResultSet rs = null;
        if (Conn.getConexion() != null) {
            try {
                st = Conn.getConexion().createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    Acts a = rsToActs(rs);
                    act.add(a);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                cerrar(rs, st);
            }
        }
        return act;
    }

    public static Mov rsToMov(ResultSet rs) {
        Mov m = new Mov();
        try {
            m.setId(rs.getInt("id"));
            m.setTitle(rs.getString("title"));
            m.setDuration(rs.getInt("duration"));
            m.setYear(rs.getInt("year"));
            m.setProducer(rs.getString("producer") == null ? "sin productora" : rs.getString("producer"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return m;
    }

    public static Charac rsToCharac(ResultSet rs) {
        Charac c = new Charac();
        try {
            c.setId(rs.getInt("id"));
            c.setName(rs.getString("name"));
            c.setPowers(rs.getString("powers"));
            c.setCompany(rs.getString("company"));
            c.setOrigin(rs.getString("origin"));
            c.setIsHeroe(rs.getInt("isHeroe"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return c;
    }

    public static Acts rsToActs(ResultSet rs) {
        Acts a = new Acts();
        Mov m = new Mov();
        Charac c = new Charac();
        try {
            a.setId(rs.getInt("id"));
            int peli = rs.getInt("movie_id");
            m = moviePorId(peli);
            a.setMov(m);
            int pers = rs.getInt("character_id");
            c = characterPorId(pers);
            a.setCharac(c);
            a.setMinutes(rs.getInt("minutes_in_movie"));
            a.setMain(rs.getBoolean("main_character"));
            a.setActor(rs.getString("actor"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return a;
    }

    private static void verPelis(List <Mov> pelis) {
        for (Mov m : pelis) {
            System.out.printf("%-4d %-55s %-5d %-4d %s\n",
                    m.getId(), m.getTitle(), m.getDuration(), m.getYear(), m.getProducer());
        }
    }

    private static void verPersonajes(List <Charac> ch) {
        for (Charac c : ch) {
            System.out.printf("%-4d %-15s %-55s %-15s %-15s %s\n",
                    c.getId(), c.getName(), c.getPowers(), c.getCompany(), c.getOrigin().equals(null)?"sin cargar":c.getOrigin(), c.getIsHeroe()==1? "Heroe" : "Villano");
        }
    }

    private static void verActuaciones(List <Acts> act) {
        for (Acts a : act) {
            System.out.println(a.getMov().getTitle()+" - "+a.getMov().getYear()+" - "+a.getCharac().getName()+" - "+a.getActor());
        }
    }

    private static void heroeVillano() {
        Scanner t = new Scanner(System.in);
        System.out.println("Introduce el id del personaje");
        int n = Integer.parseInt(t.nextLine());
        String sql = "select * from characters where id = ?;";
        PreparedStatement st = null;
        ResultSet rs = null;
        if (Conn.getConexion() != null) {
            try {
                st = Conn.getConexion().prepareStatement(sql);
                st.setInt(1, n);
                rs = st.executeQuery();
                while (rs.next()) {
                   Charac c = rsToCharac(rs);
                    System.out.println(c.getName() + " - " + (c.getIsHeroe() == 1 ? "Heroe" : "Villano"));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                cerrar(rs, st);
            }
        }
    }

    private static void sinProductora(List <Mov> pelis) {
        for (Mov m : pelis) {
            if(m.getProducer()==null) {
                System.out.printf("%-4d %-50s %-5d %-4d\n",
                        m.getId(), m.getTitle(), m.getDuration(), m.getYear());
            }
        }
    }

    private static void intervenciones() {
        List<Mov> pelis = new ArrayList<>();
        String sql = "select movies.*, count(movie_id) as interventions from movies left join acts on movies.id=movie_id group by title;";
        Statement st = null;
        ResultSet rs = null;
        if (Conn.getConexion() != null) {
            try {
                st = Conn.getConexion().createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    Mov m = rsToMov(rs);
                    pelis.add(m);
                    System.out.println(m.getTitle() + " - " + rs.getInt("interventions"));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                cerrar(rs, st);
            }
        }
    }



    private static void masAntigua(List <Mov> pelis) {
        List<Mov> antiguas = new ArrayList<>();
        int old = Integer.MAX_VALUE;
        for (Mov p : pelis) {
            if (old > p.getYear()) {
                old = p.getYear();
                antiguas.clear();
                antiguas.add(p);
            }else if (old == p.getYear()) {
                antiguas.add(p);
            }
        }
        for (Mov m : antiguas) {
            System.out.printf("%-4d %-50s %-6d %-7d %s\n",
                    m.getId(), m.getTitle(), m.getDuration(), m.getYear(), m.getProducer());
        }
    }

    private static List<Mov> porActor() {
        List<Mov> pelis = new ArrayList<>();
        Scanner t = new Scanner(System.in);
        System.out.println("introduce nombre del actor");
        String actor = t.nextLine();
        String sql = "select movies.* from movies inner join acts on acts.movie_id=movies.id where actor = ?;";
        PreparedStatement st = null;
        ResultSet rs = null;
        if (Conn.getConexion() != null) {
            try {
                st = Conn.getConexion().prepareStatement(sql);
                st.setString(1, actor);
                rs = st.executeQuery();
                while (rs.next()) {
                    Mov m = rsToMov(rs);
                    pelis.add(m);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                cerrar(rs, st);
            }
        }
        return pelis;
    }

    public static void verPorActor(List<Mov> pelis) {
        for (Mov m : pelis) {
            System.out.println(m.getTitle());
        }
    }

    private static List<Mov> sinPersonajes() {
        List<Mov> pelis = new ArrayList<>();
        String sql = "select movies.*, acts.id from movies left join acts on movies.id=movie_id where movie_id is null;";
        Statement st = null;
        ResultSet rs = null;
        if (Conn.getConexion() != null) {
            try {
                st = Conn.getConexion().createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    Mov m = rsToMov(rs);
                    pelis.add(m);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                cerrar(rs, st);
            }
        }
        return pelis;
    }

    public static void verSinPersonajes(List<Mov> pelis) {
        for (Mov m : pelis) {
            System.out.println(m.getTitle());
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
        String sql = "select id, name, powers, company, origin, isHeroe from characters where id = ?;";
        Charac ch = new Charac();
        try {
            ps = Conn.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                ch = rsToCharac(rs);
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
        Mov m = new Mov();
        String sql = "select id, name, powers, company, origin, isHeroe from characters where id = ?;";
        try {
            ps = Conn.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                m = rsToMov(rs);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            cerrar(rs, ps);
        }

        return m;
    }

}
