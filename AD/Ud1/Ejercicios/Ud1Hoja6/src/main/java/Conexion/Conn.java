package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Conn {
    private static Connection conexion = null;

    public static Connection getConexion() {
        Properties properties = new Properties();
        Connection conexion = null;
        properties.setProperty("user", "postgres");
        properties.setProperty("password", "postgres");
        properties.setProperty("useSSL", "false");
        properties.setProperty("allowPublicKeyRetrieval", "true");
        properties.setProperty("serverTimezone", "UTC");
        properties.setProperty("allowMultiQueries", "true");
        try {
            conexion = DriverManager.getConnection("jdbc:postgresql://192.168.1.142:5432/heroes", properties);
        } catch (Exception e) {
            System.out.println("Connection failed");
        }

        if (conexion == null) {
            String url = "jdbc:postgresql://192.168.1.142:5432/heroes";
            String user = "postgres";
            String password = "postgres";
            try {
                conexion = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                System.out.println("Connection failed");
            }
        }
        return conexion;
    }

    public static void cerrar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                conexion = null;
            }
        } catch (Exception e) {
            System.out.println("Connection failed");
        }
    }
}
