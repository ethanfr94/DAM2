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

        siguienteJornada(ultimaJornada());
        partidosUltimaJornada(ultimaJornada());

    }

    public static int ultimaJornada() {
        Connection con = Conn.getConexion();
        int jornada = 0;
        if (con != null) {
            String sql = "SELECT MAX(numjornada) FROM partidos";// selecciona el valor máximo de la columna numjornada
            try (PreparedStatement st = con.prepareStatement(sql)) {//prepara la consulta
                ResultSet rs = st.executeQuery();//ejecuta la consulta
                if (rs.next()) {// si hay un resultado en la consulta se guarda en la variable jornada
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
            String checkSql = "SELECT COUNT(*) FROM partidos WHERE numjornada = ?";// cuenta el número de partidos en la jornada
            try (PreparedStatement checkStmt = con.prepareStatement(checkSql)) {// prepara la consulta
                checkStmt.setInt(1, jornada);// asigna el valor de la jornada a la consulta
                ResultSet rs = checkStmt.executeQuery();// ejecuta la consulta
                if (rs.next() && rs.getInt(1) == 0) {// si no hay partidos en la jornada se ejecuta la siguiente consulta
                    String sql = "{call siguienteJornada(?)}";// llama a la función siguienteJornada con el valor de la jornada
                    try (CallableStatement st = con.prepareCall(sql)) {  // prepara la consulta
                        st.setInt(1, jornada);// asigna el valor de la jornada a la consulta
                        st.execute();// ejecuta la consulta
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
                String sql = "SELECT * FROM partidos WHERE numjornada = ?";// selecciona los partidos de la jornada
                try (PreparedStatement st = con.prepareStatement(sql)) {// prepara la consulta
                    st.setInt(1, jornada);// asigna el valor de la jornada a la consulta
                    ResultSet rs = st.executeQuery();// ejecuta la consulta
                    while (rs.next()) {// recorre los resultados de la consulta
                        System.out.println(rs.getString("eqloc") + " - " + rs.getString("eqvis"));// imprime los resultados
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