package org.example;

import org.example.conexion.BD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        init();
    }

    public static void init(){
        eliminarTablas();
        crearTablas();
        introDatos();

    }

    public static void eliminarTablas(){
        if (BD.getConexion() != null) {
            String sql = "drop table if exists characters;";
            try{
                Statement st=BD.getConexion().createStatement();
                int n = st.executeUpdate(sql);
                sql = "drop table if exists movies;";
                int m = st.executeUpdate(sql);
                sql = "drop table if exists acts;";
                int b = st.executeUpdate(sql);
            }catch (SQLException e) {System.out.println("hola");
                System.out.println(e.getMessage());
            }finally{
                BD.cerrar();
            }

        } else {
            System.out.println("conexion fallida");
        }
        if (BD.getConexion() != null) {
            BD.cerrar();
        }
    }

    public static void crearTablas(){
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
            try{
                Statement st=BD.getConexion().createStatement();
                int n = st.executeUpdate(sql);
                int m = st.executeUpdate(sql1);
                int b = st.executeUpdate(sql2);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally{
                BD.cerrar();
            }

        } else {
            System.out.println("conexion fallida");
        }
        if (BD.getConexion() != null) {
            BD.cerrar();
        }
    }

    public static void introDatos(){

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

            String sql2 = "insert into acts (id, character_id, movie_id, minutes_in_movie, main_character, actor) values" +
                    "(1, 1, 90, 1, 'Tom Holland','Spider-Man en The Avengers')," +
                    "(2, 2, 100, 1, 'Gal Gadot','Wonder Woman en Wonder Woman')," +
                    "(8, 3, 85, 1, 'Ryan Reynolds','Deadpool en Deadpool')," +
                    "(9, 4, 110, 1, 'Jason Momoa' ,'Aquaman en Aquaman')," +
                    "(5, 1, 45, 0, 'Scarlett Johansson','Black Widow en The Avengers');";
            try{

                Statement st=BD.getConexion().createStatement();
                int n = st.executeUpdate(sql);
                int m = st.executeUpdate(sql1);
                int b = st.executeUpdate(sql2);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally{
                BD.cerrar();
            }
        } else {
            System.out.println("conexion fallida");
        }
        if (BD.getConexion() != null) {
            BD.cerrar();
        }
    }




}

