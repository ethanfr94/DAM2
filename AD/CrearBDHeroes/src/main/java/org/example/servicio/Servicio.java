package org.example.servicio;

import org.example.conexion.BD;

import java.sql.PreparedStatement;

public class Servicio {
    public static int saveMovie() {
        int n = -1;
        PreparedStatement st = null;
        if (BD.getConexion() != null) {
            String sql = " insert into movies (title, duration, year, producer) values (?,?,?,?)";
            try {
                // st=BD.getConexion().prepareStatement(sql);
                //st.setString()
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return n;
    }
}
