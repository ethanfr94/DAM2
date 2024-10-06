package Servicio;

import Conexion.Conn;
import Modelo.Cancion;
import Modelo.Usuario;

import java.sql.*;

public class Serv {
    public static boolean validarUser(Usuario u){
        boolean ok = false;
        Connection c = Conn.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT nombre FROM usuarios WHERE user = ? AND contraseña = md5(?)";
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, u.getUser());
            ps.setString(2, u.getPassword());
            ps.executeQuery();
            rs = ps.getResultSet();
            if (rs.next()){
               ok = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrar(rs, ps);
        }
        return ok;
    }

    public static boolean votar(Usuario u, int numCancion){
        boolean ok = false;
        Connection c = Conn.getConexion();
        PreparedStatement ps = null;
        String sql = "insert into votos (usuario, fecha, cancion) values (?, now(), ?)";
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, u.getUser());
            ps.setInt(2, numCancion);
            int x = ps.executeUpdate();
            if (x == 1) ok = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrar(ps);
        }
        return ok;
    }

    public static boolean actualizarVotos(Usuario u, int numCancion){
        boolean ok = false;
        Connection c = Conn.getConexion();
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        String sql = "update usuarios set numVotos = numVotos + 1 where user = ?";
        String sql2 = "update canciones set total_votos = total_votos + 1 where numCancion = ?";
        try {
            ps = c.prepareStatement(sql);
            ps2 = c.prepareStatement(sql2);
            ps.setString(1, u.getUser());
            ps2.setInt(1, numCancion);
            int x = ps.executeUpdate();
            int y = ps2.executeUpdate();
            if (x == 1 && y == 1) ok = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrar(ps);
        }
        return ok;
    }

    public static Cancion porNum(int numCancion) {
        Cancion c = null;
        Connection con = Conn.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select numCancion, titulo, nombre from canciones inner join grupos on grupo=codgrupo where numCancion = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, numCancion);
            ps.executeQuery();
            rs = ps.getResultSet();
            if (rs.next()) {
                c = new Cancion();
                c.setNumCancion(rs.getInt("numCancion"));
                c.setTitulo(rs.getString("titulo"));
                c.setGrupo(rs.getString("nombre"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public static int posicion(int numCancion){
        int pos = 0;
        Connection c = Conn.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select count(numCancion) from canciones where total_votos > (select total_votos from canciones where numcancion = ?);";
        try {
            ps = c.prepareStatement(sql);
            ps.setInt(1, numCancion);
            ps.executeQuery();
            rs = ps.getResultSet();
            if(rs.next()) pos = rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrar(rs, ps);
        }
        return pos;
    }

    private static boolean cerrar(ResultSet rs, Statement st) {
        boolean cerrado = false;
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            cerrado = true;
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getErrorCode()+ex.getMessage());
        }
        return cerrado;
    }
    private static boolean cerrar(ResultSet rs, PreparedStatement ps) {
        boolean cerrado = false;
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            cerrado = true;
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getErrorCode()+ex.getMessage());
        }
        return cerrado;
    }
    private static boolean cerrar(PreparedStatement ps) {
        boolean cerrado = false;
        try {
            if (ps != null) {
                ps.close();
            }
            cerrado = true;
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getErrorCode()+ex.getMessage());
        }
        return cerrado;
    }
}
