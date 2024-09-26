package org.example.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BD {

        private static Connection connection = null;

        public static Connection getConexion() {
            if (connection != null) {
                return connection;
            }
            //String userHome = System.getProperty("user.home");
            //String url = "jdbc:sqlite:"+userHome+"\\DB\\Heroes.db";
            //String url = "jdbc:sqlite:D:\\Usuarios\\dam2\\Desktop\\DB\\Heroes.db";
            //String url = "jdbc:sqlite:C:\\Users\\usuario\\Desktop/Heroes.db";
            String url = "jdbc:sqlite:C:Heroes.db";

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
