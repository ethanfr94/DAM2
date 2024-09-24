package org.example.servicio;

import org.example.conexion.BD;
import org.example.modelos.Act;
import org.example.modelos.Character;
import org.example.modelos.Movie;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Servicio {

    public static void menu() {
        int op;
        do {
            System.out.println("1.Añadir pelicula\n" +
                    "2.Añadir actuacion\n" +
                    "3.Añadir personaje\n" +
                    "4.Modificar origen del personaje\n" +
                    "5.Modificar año de la pelicula\n" +
                    "6.Eliminar actuacion\n" +
                    "7.Eliminar pelicula\n" +
                    "8.Modificar productora\n" +
                    "0.Salir");
            op = Integer.parseInt(System.console().readLine());
            switch (op) {
                case 1 -> addPelicula();
                case 2 -> addActuacion();
                case 3 -> addPersonaje();
                case 4 -> modOrigen();
                case 5 -> modAnio();
                case 6 -> eliminarActuacion();
                case 7 -> eliminarPelicula();
                case 8 -> renombrarProductora();
                case 0 -> System.out.println("cerrando el programa");
                default -> System.out.println("opcion no valida");
            }
        } while (op != 0);
    }

    public static int addPelicula() {
        Scanner t = new Scanner(System.in);
        Movie m = new Movie();
        System.out.println("Introduce titulo de la pelicula");
        String titulo = t.nextLine();
        System.out.println("Introduce duracion de la pelicula");
        int duracion = Integer.parseInt(t.nextLine());
        m.setTitle(titulo);
        m.setDuration(duracion);

        int n = -1;
        PreparedStatement st = null;
        if (BD.getConexion() != null) {
            String sql = " insert into movies (title, duration) values (?,?)";
            try {
                st = BD.getConexion().prepareStatement(sql);
                st.setString(1, m.getTitle());
                st.setInt(2, m.getDuration());
                n = st.executeUpdate();
                System.out.println(n + " lineas afectadas.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                BD.cerrar();
            }
        }
        return n;
    }

    public static int addActuacion() {
        Scanner t = new Scanner(System.in);
        Act a = new Act();
        System.out.println("Introduce id de la pelicula");
        int idpeli = Integer.parseInt(t.nextLine());
        System.out.println("Introduce id del personaje");
        int idpers = Integer.parseInt(t.nextLine());
        System.out.println("Introduce actor");
        String actor = t.nextLine();
        System.out.println("1.personaje principal\n0.personaje secundario");
        int pr = Integer.parseInt(t.nextLine());
        a.setMovie_id(idpers);
        a.setCharacter_id(idpeli);
        a.setActor(actor);
        a.setMain(pr == 1);

        int n = -1;
        PreparedStatement st = null;
        if (BD.getConexion() != null) {
            String sql = " insert into acts (movie_id, character_id, actor, main_character) values (?,?,?,?)";
            try {
                st = BD.getConexion().prepareStatement(sql);
                st.setInt(1, a.getMovie_id());
                st.setInt(2, a.getCharacter_id());
                st.setString(3, a.getActor());
                st.setInt(4, a.isMain() ? 1 : 0);
                n = st.executeUpdate();
                System.out.println(n + " lineas afectadas.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                BD.cerrar();
            }
        }
        return n;
    }

    public static int addPersonaje() {
        Scanner t = new Scanner(System.in);
        Character p = new Character();
        System.out.println("Introduce nombre");
        String nombre = t.nextLine();
        System.out.println("Introduce poderes");
        String poderes = t.nextLine();
        System.out.println("Introduce productora");
        String productora = t.nextLine();
        System.out.println("Introduce origen");
        String origen = t.nextLine();
        System.out.println("1.Heroe\n0.No heroe");
        int h = Integer.parseInt(t.nextLine());
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
                st = BD.getConexion().prepareStatement(sql);
                st.setString(1, p.getName());
                st.setString(2, p.getPowers());
                st.setString(3, p.getCompany());
                st.setString(4, p.getOrigin());
                st.setInt(5, p.getIsHeroe());
                n = st.executeUpdate();
                System.out.println(n + " lineas afectadas.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                BD.cerrar();
            }
        }
        return n;
    }

    public static int modOrigen() {
        Scanner t = new Scanner(System.in);

        System.out.println("Introduce nombre del personaje");
        String nombre = t.nextLine();
        System.out.println("Introduce nuevo origen");
        String origen = t.nextLine();

        int n = -1;
        PreparedStatement st = null;
        if (BD.getConexion() != null) {
            String sql = "update table characters set origin = ? where name = ?";
            try {
                st = BD.getConexion().prepareStatement(sql);
                st.setString(1, nombre);
                st.setString(2,origen);
                n = st.executeUpdate();
                System.out.println(n + " lineas afectadas.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                BD.cerrar();
            }
        }
        return n;
    }

    public static int modAnio() {
        Scanner t = new Scanner(System.in);
        System.out.println("Introduce id de la pelicula");
        int idpeli = Integer.parseInt(t.nextLine());
        System.out.println("Introduce nuevo año");
        int anio = Integer.parseInt(t.nextLine());

        int n = -1;
        PreparedStatement st = null;
        if (BD.getConexion() != null) {
            String sql = "update table movies set year = ? where id = ?";
            try {
                st = BD.getConexion().prepareStatement(sql);
                st.setInt(1, anio);
                st.setInt(2, idpeli);
                n = st.executeUpdate();
                System.out.println(n + " lineas afectadas.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                BD.cerrar();
            }
        }
        return n;
    }

    public static int eliminarActuacion() {
        Scanner t = new Scanner(System.in);
        System.out.println("Introduce id del personaje");
        int id = Integer.parseInt(t.nextLine());
        System.out.println("introduce id de la pelicula");
        int idpeli = Integer.parseInt(t.nextLine());

        int n = -1;
        PreparedStatement st = null;
        if (BD.getConexion() != null) {
            String sql = "delete from acts where movie_id = ? and character_id = ?";
            try {
                st = BD.getConexion().prepareStatement(sql);
                st.setInt(1, idpeli);
                st.setInt(2, id);
                n = st.executeUpdate();
                System.out.println(n + " lineas afectadas.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                BD.cerrar();
            }
        }
        return n;
    }

    public static int eliminarPelicula() {
        Scanner t = new Scanner(System.in);
        System.out.println("Introduce titulo de la pelicula");
        String titulo = t.nextLine();

        int n = -1;
        PreparedStatement st = null;
        if (BD.getConexion() != null) {
            String sql = "delete from movies where title = ?";
            try {
                st = BD.getConexion().prepareStatement(sql);
                st.setString(1, titulo);
                n = st.executeUpdate();
                System.out.println(n + " lineas afectadas.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                BD.cerrar();
            }
        }
        return n;
    }

    public static int renombrarProductora() {
        Scanner t = new Scanner(System.in);
        System.out.println("Introduce nombre de la productora");
        String nombre = t.nextLine();
        System.out.println("Introduce nuevo nombre");
        String nuevo = t.nextLine();

        int n = -1;
        PreparedStatement st = null;
        if (BD.getConexion() != null) {
            String sql = "update table movies set producer = ? where producer = ?";
            try {
                st = BD.getConexion().prepareStatement(sql);
                st.setString(1, nuevo);
                st.setString(2, nombre);
                n = st.executeUpdate();
                System.out.println(n + " lineas afectadas.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                BD.cerrar();
            }
        }
        return n;
    }

    public static void eliminarTablas() {
        if (BD.getConexion() != null) {
            String sql = "drop table if exists characters;";
            try {
                Statement st = BD.getConexion().createStatement();
                int n = st.executeUpdate(sql);
                sql = "drop table if exists movies;";
                int m = st.executeUpdate(sql);
                sql = "drop table if exists acts;";
                int b = st.executeUpdate(sql);
            } catch (SQLException e) {
                System.out.println("hola");
                System.out.println(e.getMessage());
            } finally {
                BD.cerrar();
            }

        } else {
            System.out.println("conexion fallida");
        }
        if (BD.getConexion() != null) {
            BD.cerrar();
        }
    }

    public static void crearTablas() {
        if (BD.getConexion() != null) {
            String sql = "create table characters (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "name TEXT NOT NULL,\n" +
                    "powers TEXT,\n" +
                    "company TEXT,\n" +
                    "origin TEXT,\n" +
                    "isHeroe INTEGER CHECK (isHeroe IN (0, 1)));";

            String sql1 = "create table movies (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "title TEXT NOT NULL,\n" +
                    "duration INTEGER,\n" +
                    "year INTEGER,\n" +
                    "producer TEXT);";

            String sql2 = "CREATE TABLE acts (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "character_id INTEGER NOT NULL,\n" +
                    "movie_id INTEGER NOT NULL, " +
                    "minutes_in_movie INTEGER,\n" +
                    "main_character BOOLEAN NOT NULL,\n" +
                    "actor TEXT,\n" +
                    "FOREIGN KEY (character_id) REFERENCES characters(id),\n" +
                    "FOREIGN KEY (movie_id) REFERENCES movies(id));";
            try {
                Statement st = BD.getConexion().createStatement();
                int n = st.executeUpdate(sql);
                int m = st.executeUpdate(sql1);
                int b = st.executeUpdate(sql2);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                BD.cerrar();
            }

        } else {
            System.out.println("conexion fallida");
        }
        if (BD.getConexion() != null) {
            BD.cerrar();
        }
    }

    public static void introDatos() {

        if (BD.getConexion() != null) {
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

            String sql1 = "insert into movies (title, duration, year, producer) values " +
                    "('The Avengers', 143, 2012, 'Marvel Studios'), " +
                    "('Wonder Woman', 141, 2017, 'Warner Bros')," +
                    " ('Deadpool', 108, 2016, '20th Century Fox')," +
                    "('Aquaman', 143, 2018, 'Warner Bros');";

            String sql2 = "insert into acts (id, character_id, movie_id, minutes_in_movie, actor, main_character) values" +
                    "(1, 1, 90, 1, 'Tom Holland','Spider-Man en The Avengers')," +
                    "(2, 2, 100, 1, 'Gal Gadot','Wonder Woman en Wonder Woman')," +
                    "(8, 3, 85, 1, 'Ryan Reynolds','Deadpool en Deadpool')," +
                    "(9, 4, 110, 1, 'Jason Momoa' ,'Aquaman en Aquaman')," +
                    "(5, 1, 45, 0, 'Scarlett Johansson','Black Widow en The Avengers');";
            try {

                Statement st = BD.getConexion().createStatement();
                int n = st.executeUpdate(sql);
                int m = st.executeUpdate(sql1);
                int b = st.executeUpdate(sql2);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                BD.cerrar();
            }
        } else {
            System.out.println("conexion fallida");
        }
        if (BD.getConexion() != null) {
            BD.cerrar();
        }
    }

    public static void init() {
        eliminarTablas();
        crearTablas();
        introDatos();

    }


}
