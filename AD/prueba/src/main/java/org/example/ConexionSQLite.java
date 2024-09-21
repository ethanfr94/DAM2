package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQLite {
    private static Connection connection = null;

    public static Connection getConexion() {
        if (connection != null) {
            return connection;
        }
        String url = "jdbc:sqlite:heroes.db";
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void cerrar() {
        try {
            connection.close();
            connection = null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}