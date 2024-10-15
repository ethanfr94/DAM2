package Conexion;

import java.sql.*;
import java.util.Properties;

public class Conn {
    private static Connection connection = null;

    public static Connection getConexion(String usuario, String password) {
        if (connection == null) {
            Properties prop = new Properties();
            prop.put("user", usuario);
            prop.put("password", password);
            prop.put("useSSL", false);
            prop.put("useUnicode", true);
            prop.put("serverTimezone", "UTC");
            prop.put("alloyMultiQueries", true);
            String url = "jdbc:mysql://localhost:3307/videos";

            try {
                connection = DriverManager.getConnection(url, prop);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    public static void cerrar() {
        try {
            if (connection != null) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
