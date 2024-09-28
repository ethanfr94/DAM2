package org.example.Servicio;

import org.example.Conexion.Conn;
import org.example.Funciones.Func;
import org.example.Modelos.Acts;
import org.example.Modelos.Charac;
import org.example.Modelos.Mov;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Serv {

//////////////////////////////////////////////////////////// listar tablas/////////////////////////////////////////////////////////////////////////////////////////

    public static List<Mov> listaPelis() {
        List<Mov> pelis = new ArrayList<>();
        String sql = "select id, title, duration, year, producer from movies;";
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

    public static List<Charac> listaPersonajes() {
        List<Charac> ch = new ArrayList<>();
        String sql = "select id, name, powers, company, origin, isHeroe from characters;";
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

    public static List<Acts> listaActuaciones() {
        List<Acts> act = new ArrayList<>();
        String sql = "select id, character_id, movie_id, minutes_in_movie, main_character, actor from acts;";
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

/////////////////////////////////////////////convertir tablas a objetos////////////////////////////////////////////////////////////////////////////////////////

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
        try {
            a.setId(rs.getInt("id"));
            int peli = rs.getInt("movie_id");
            Mov m = moviePorId(peli);
            a.setMov(m);
            int pers = rs.getInt("character_id");
            Charac c = characterPorId(pers);
            a.setCharac(c);
            a.setMinutes(rs.getInt("minutes_in_movie"));
            a.setMain(rs.getBoolean("main_character"));
            a.setActor(rs.getString("actor"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return a;
    }


/////////////////////////////////////////////opciones de búsqueda////////////////////////////////////////////////////////////////////////////////////////

    public static void heroeVillano() {
        Scanner t = new Scanner(System.in);
        System.out.println("Introduce el id del personaje");
        int n = Integer.parseInt(t.nextLine());
        String sql = "select id, name, powers, company, origin, isHeroe from characters where id = ?;";
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
                System.out.println(e.getMessage());
            } finally {
                cerrar(rs, st);
            }
        }
    }

    public static void intervenciones() {
        List<Mov> pelis = new ArrayList<>();
        String sql = "select movies.id, movies.title, movies.duration, movies.year, movies.producer, count(movie_id) as interventions from movies left join acts on movies.id=movie_id group by title;";
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
                System.out.println(e.getMessage());
            } finally {
                cerrar(rs, st);
            }
        }
    }
    public static List<Mov> masAntigua() {
        List<Mov> pelis = new ArrayList<>();
        String sql = "select id, title, duration, year, producer from movies where year = (select min(year) from movies);";
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

    public static List<Mov> porActor() {
        List<Mov> pelis = new ArrayList<>();
        Scanner t = new Scanner(System.in);
        System.out.println("introduce nombre del actor");
        String aux = t.nextLine();
        String actor = "";
        StringTokenizer st = new StringTokenizer(aux, " ");
        while (st.hasMoreTokens()) {
            String temp = st.nextToken();
            String nombre = temp.substring(0,1).toUpperCase().concat(temp.substring(1).toLowerCase());
            temp = st.nextToken();
            String apellido = temp.substring(0,1).toUpperCase().concat(temp.substring(1).toLowerCase());
            actor = nombre + " " + apellido;
        }
        String sql = "select movies.id, movies.title, movies.duration, movies.year, movies.producer from movies inner join acts on acts.movie_id=movies.id where actor = ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (Conn.getConexion() != null) {
            try {
                ps = Conn.getConexion().prepareStatement(sql);
                ps.setString(1, actor);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Mov m = rsToMov(rs);
                    pelis.add(m);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                cerrar(rs, ps);
            }
        }
        return pelis;
    }

    public static List<Mov> sinPersonajes() {
        List<Mov> pelis = new ArrayList<>();
        String sql = "select movies.id, movies.title, movies.duration, movies.year, movies.producer, acts.id from movies left join acts on movies.id=movie_id where movie_id is null;";
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
        String sql = "select id, title, duration, year, producer from movies where id = ?;";
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

    //////////////////////////////////////////////////////////////////////////////////////////////


    private static void cerrar(ResultSet rs, PreparedStatement st) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
        }
    }

    public static void cerrarStatement(Statement st){
        if(st!=null){
            try{
                st.close();
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    public static void eliminarTablas() {
        if (Conn.getConexion() != null) {
            String sql = "drop table if exists characters;";
            Statement st = null;
            try {
                st = Conn.getConexion().createStatement();
                st.executeUpdate(sql);
                sql = "drop table if exists movies;";
                st.executeUpdate(sql);
                sql = "drop table if exists acts;";
                st.executeUpdate(sql);
            } catch (SQLException e) {
                System.out.println("hola");
                System.out.println(e.getMessage());
            } finally {
                cerrarStatement(st);
            }

        } else {
            System.out.println("conexion fallida");
        }
        if (Conn.getConexion() != null) {
            Conn.cerrar();
        }
    }

    public static void crearTablas() {
        if (Conn.getConexion() != null) {
            Statement st = null;
            try {
                st = Conn.getConexion().createStatement();
                String sql = """
                    create table characters (\
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    powers TEXT,
                    company TEXT,
                    origin TEXT,
                    isHeroe INTEGER CHECK (isHeroe IN (0, 1)));""";
                st.executeUpdate(sql);
                sql = """
                    create table movies (\
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    title TEXT NOT NULL,
                    duration INTEGER,
                    year INTEGER,
                    producer TEXT);""";
                st.executeUpdate(sql);
                sql = """
                    CREATE TABLE acts (\
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    character_id INTEGER NOT NULL,
                    movie_id INTEGER NOT NULL, \
                    minutes_in_movie INTEGER,
                    main_character BOOLEAN NOT NULL,
                    actor TEXT,
                    FOREIGN KEY (character_id) REFERENCES characters(id),
                    FOREIGN KEY (movie_id) REFERENCES movies(id));""";
                st.executeUpdate(sql);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                cerrarStatement(st);
            }

        } else {
            System.out.println("conexion fallida");
        }
        if (Conn.getConexion() != null) {
            Conn.cerrar();
        }
    }

    public static void introDatos() {

        if (Conn.getConexion() != null) {
            Statement st = null;
            try {
                st = Conn.getConexion().createStatement();
                String sql = "insert into characters (name, powers, company, origin, isHeroe) values " +
                        "('Spider-Man', 'Agilidad, trepar paredes, sentido arácnido','Marvel', 'Nueva York', 1), " +
                        "('Batman', 'Alta inteligencia, habilidades marciales', 'DC','Gotham City', 1)," +
                        "('Wonder Woman', 'Fuerza, agilidad, inmortalidad', 'DC','Themyscira', 1), " +
                        "('Iron Man', 'Armadura avanzada, vuelo, armas láser','Marvel', 'Malibu', 1), " +
                        "('Black Widow', 'Agilidad, combate cuerpo a cuerpo','Marvel', 'Rusia', 1), " +
                        "('Superman', 'Fuerza, vuelo, visión de rayos láser', 'DC','Krypton', 1), " +
                        "('Captain Marvel', 'Fuerza, vuelo, energía cósmica','Marvel', 'Planeta Hala', 1), " +
                        "('Deadpool', 'Regeneración, inmortalidad', 'Marvel','Canadá', 0), " +
                        "('Aquaman', 'Control del agua, comunicación con criaturasmarinas', 'DC', 'Atlantis', 1), " +
                        "('Harley Quinn', 'Experta en combate cuerpo a cuerpo, inteligencia', 'DC', 'Gotham City', 0);";
                st.executeUpdate(sql);
                sql = "insert into movies (title, duration, year, producer) values " +
                        "('The Avengers', 143, 2012, 'Marvel Studios'), " +
                        "('Wonder Woman', 141, 2017, 'Warner Bros')," +
                        " ('Deadpool', 108, 2016, '20th Century Fox')," +
                        "('Aquaman', 143, 2018, 'Warner Bros');";
                st.executeUpdate(sql);
                sql = "insert into acts (id, character_id, movie_id, minutes_in_movie, actor, main_character) values" +
                        "(1, 1, 1, 26, 'Tom Holland','Spider-Man en The Avengers')," +
                        "(2, 2, 2, 120, 'Gal Gadot','Wonder Woman en Wonder Woman')," +
                        "(8, 3, 3, 100, 'Ryan Reynolds','Deadpool en Deadpool')," +
                        "(9, 4, 4, 134, 'Jason Momoa' ,'Aquaman en Aquaman')," +
                        "(5, 5, 1, 109, 'Scarlett Johansson','Black Widow en The Avengers');";
                st.executeUpdate(sql);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                cerrarStatement(st);
            }
        } else {
            System.out.println("conexion fallida");
        }
        if (Conn.getConexion() != null) {
            Conn.cerrar();
        }
    }

    public static void init() {
        eliminarTablas();
        crearTablas();
        introDatos();
    }

}
