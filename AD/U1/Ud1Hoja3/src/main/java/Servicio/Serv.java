package Servicio;

import Conexion.Conn;
import Modelo.Cancion;
import Modelo.Grupo;
import Modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Serv {

    public static boolean adduser(Usuario user){
        Connection c = Conn.getConexion();
        boolean add = false;
        int n = -1;
        if (c != null) {
            String sql = " insert into usuarios (user, contraseña, nombre, apellidos, fechanac, numvotos) values (?,?,?,?,?,?)";
            try (PreparedStatement st = Conn.getConexion().prepareStatement(sql);) {
                st.setString(1, user.getUser());
                st.setString(2, user.getPassword());
                st.setString(3, user.getNombre());
                st.setString(4, user.getApellidos());
                st.setString(5, user.getFnac().toString());
                st.setInt(6, user.getNumVotos());
                n = st.executeUpdate();
                if (n > 0) {
                    add = true;
                }
            } catch (SQLException ex) {
                System.out.println(ex.getErrorCode());
            }
        }
        Conn.cerrar(c);
        return add;
    }

    public static List<Grupo> listarGrupos(){
        Connection c = Conn.getConexion();
        List<Grupo> grupos = new ArrayList<>();
        if (c != null) {
            String sql = "select codgrupo, nombre, localidad, estilo from grupos order by codgrupo";
            try (Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql);) {
                while (rs.next()) {
                    Grupo g = new Grupo();
                    g.setCodgrupo(rs.getInt("codgrupo"));
                    g.setNombre(rs.getString("nombre"));
                    g.setLocalidad(rs.getString("localidad"));
                    g.setEstilo(rs.getString("estilo"));
                    grupos.add(g);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getErrorCode());
            }
        }
        Conn.cerrar(c);
        return grupos;
    }

    public static List<Cancion> listarCanciones(){
        Connection c = Conn.getConexion();
        List<Cancion> canciones = new ArrayList<>();
        ResultSet rs = null;
        Statement st = null;
        if (c != null) {
            String sql = "select numcancion, titulo, duracion, total_votos, grupo from canciones order by grupo";
            try {
                st = c.createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    Cancion can = new Cancion();
                    can.setNumCancion(rs.getInt("numcancion"));
                    can.setTitulo(rs.getString("titulo"));
                    can.setDuracion(Time.valueOf(rs.getString("duracion")));
                    can.setVotos(rs.getInt("total_votos"));
                    can.setGrupo(grupoPorId(rs.getInt("grupo")));
                    canciones.add(can);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                System.out.println(ex.getErrorCode());
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (st != null) {
                        st.close();
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println(ex.getErrorCode());
                }
            }
        }
        Conn.cerrar(c);
        return canciones;
    }

    public static Map<String, Integer> numCancionesGrupo(){
        Connection c = Conn.getConexion();
        Map<String, Integer> grupos = new TreeMap<>();
        Statement st = null;
        ResultSet rs = null;
        if (c != null) {
            String sql = "select nombre, count(canciones.grupo) as canciones from grupos inner join canciones on codgrupo=canciones.grupo group by codgrupo;";
            try {
                st = c.createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    grupos.put(rs.getString("nombre"), rs.getInt("canciones"));
                }
            } catch (SQLException ex) {
                System.out.println(ex.getErrorCode());
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (st != null) {
                        st.close();
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getErrorCode());
                }
            }
        }
        Conn.cerrar(c);
        return grupos;
    }

    public static Grupo grupoPorId(int codGrupo){
        Connection c = Conn.getConexion();
        Grupo g = null;
        if (c != null) {
            String sql = "select codgrupo, nombre, localidad, estilo, esgrupo, annoGrab, fechaEstreno, compania from grupos where codgrupo = ?";
            try (PreparedStatement st = c.prepareStatement(sql);) {
                st.setInt(1, codGrupo);
                try (ResultSet rs = st.executeQuery();) {
                    if (rs.next()) {
                        g = new Grupo();
                        g.setCodgrupo(rs.getInt("codgrupo"));
                        g.setNombre(rs.getString("nombre"));
                        g.setLocalidad(rs.getString("localidad"));
                        g.setEstilo(rs.getString("estilo"));
                        g.setEsGrupo(rs.getBoolean("esgrupo"));
                        g.setAnnoGrab(rs.getInt("annoGrab"));
                        g.setFechaEstreno(rs.getDate("fechaEstreno"));
                        g.setCompania(rs.getString("compania"));
                    }
                }
            } catch (SQLException ex) {
                System.out.println(ex.getErrorCode());
            }
        }
        return g;
    }
}
