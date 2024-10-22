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
        String ruta = "heroes_postgres.sql";// Ruta del script
        Connection con = Conn.get_conexion();// Conexión a la base de datos
        try (Statement statement = con.createStatement()) {// Ejecución del script
            con.setAutoCommit(false);// Deshabilitar el autocommit
            String script = "";
            for (String line : Files.readAllLines(Paths.get(ruta))) {// Leer el script
                script += line;// Concatenar las líneas del script
            }
            System.out.println(script);// Mostrar el script
            statement.execute(script);// Ejecutar el script
            con.commit();// Confirmar la transacción
        } catch (Exception e) {
            e.printStackTrace();
            try {
                con.rollback();// Deshacer la transacción en caso de error
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            Conn.cerrar();
        }
    }
}