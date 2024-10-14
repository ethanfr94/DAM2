package org.example;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
   // EJERCICIO 2 Previamente, debes establecer con DBeaver una conexión con PosgreSQL Server y
    // crear una base de datos héroes. Realiza un programa que conecta a la base de datos héroes de PostgreSQL,
    // lee el fichero script heroes_postgres.sql y: • Añade tablas y datos de éstas a la base de datos héroes
    // a partir de las instrucciones del script.

    public static void main(String[] args) {
            ejecutarScript();
    }


    private static void ejecutarScript(){
        String ruta = "heroes_postgres.sql";
        Connection con = Conn.get_conexion();
        try (Statement statement = con.createStatement()) {
            con.setAutoCommit(false);
            String script = "";
            for (String line : Files.readAllLines(Paths.get(ruta))) {
                script += line;
            }
            System.out.println(script);
            statement.execute(script);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            Conn.cerrar();
        }
    }
}