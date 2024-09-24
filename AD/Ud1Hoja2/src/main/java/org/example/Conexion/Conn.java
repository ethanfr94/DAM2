package org.example.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
    private static Connection connection = null;

    public static Connection getConexion() {
        if (connection != null) {
            return connection;
        }

        String url = "jdbc:sqlite:Heroes.db";

        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public static void cerrar() {
        try {
            connection.close();
            connection = null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
