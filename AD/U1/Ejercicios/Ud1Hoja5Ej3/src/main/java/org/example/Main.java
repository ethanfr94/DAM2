package org.example;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
// 3. Realiza un programa que obtiene el número de jornada mayor que hay en la tabla partidos y:
// -Genera los partidos de la siguiente jornada.
// -Muestra en pantalla los partidos que se juegan la siguiente jornada (los generados).
        System.out.println(ultimaJornada());
        //iguienteJornada(ultimaJornada());
        //partidosUltimaJornada(ultimaJornada());

    }

    public static int ultimaJornada() {
        Connection con = Conn.getConexion();
        int jornada = 0;
        if (con != null) {
            String sql = "SELECT MAX(numjornada) FROM partidos";
            try (PreparedStatement st = con.prepareStatement(sql)) {
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    jornada = rs.getInt(1);
                }
            } catch (Exception e) {
                System.out.println("Error al ejecutar la consulta");
                System.out.println(e.getMessage());
            } finally {
                Conn.cerrar();
            }
        }
        return jornada;
    }

    public static void siguienteJornada(int jornada) {
        Connection con = Conn.getConexion();
        if (con != null) {
            String checkSql = "SELECT COUNT(*) FROM partidos WHERE numjornada = ?";
            try (PreparedStatement checkStmt = con.prepareStatement(checkSql)) {
                checkStmt.setInt(1, jornada);
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next() && rs.getInt(1) == 0) {
                    String sql = "{call siguienteJornada(?)}";
                    try (CallableStatement st = con.prepareCall(sql)) {
                        st.setInt(1, jornada);
                        st.execute();
                    }
                } else {
                    System.out.println("Entrada duplicada en jornada: " + jornada);
                }
            } catch (Exception e) {
                System.out.println("Error al ejecutar la función");
            } finally {
                Conn.cerrar();
            }
        }
    }

    public static void partidosUltimaJornada(int jornada) {
        Connection con = Conn.getConexion();
        if (con != null) {
            if (jornada > 0) {
                String sql = "SELECT * FROM partidos WHERE numjornada = ?";
                try (PreparedStatement st = con.prepareStatement(sql)) {
                    st.setInt(1, jornada);
                    ResultSet rs = st.executeQuery();
                    while (rs.next()) {
                        System.out.println(rs.getString("eqloc") + " - " + rs.getString("eqvis"));
                    }
                } catch (Exception e) {
                    System.out.println("Error al ejecutar la consulta");
                    e.printStackTrace();
                } finally {
                    Conn.cerrar();
                }
            }
        }
    }
}