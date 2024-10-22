package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection con;
    public static Connection getConexion() {
        Connection con = null;

        String password = "root";
        String usuario = "root";
        String url = "jdbc:mysql://localhost:3306/concurso";
        try {
            con = DriverManager.getConnection(url+"?useSSL=false&allowMultiQueries=true",usuario,password);
            if (con != null) {
                //System.out.println("Conectado a la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("ERROR "+e.getErrorCode()+":"+e.getMessage());
        }
        return con;
    }
}
