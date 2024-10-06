package Conexion;

import Funciones.Func;
import Modelo.Cancion;
import Modelo.Grupo;
import Modelo.Usuario;
import Modelo.Votos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Serv {
    public static Grupo grupoPorId(int id) {
        Connection con = Conn.getConexion();
        Grupo g = new Grupo();
        Statement st = null;
        String sql = "SELECT codgrupo, nombre, localidad, estilo, esgrupo, annoGrab, fechaEstreno, compania FROM grupos WHERE codgrupo = " + id;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                g.setCodgrupo(rs.getInt("codgrupo"));
                g.setNombre(rs.getString("nombre"));
                g.setLocalidad(rs.getString("localidad"));
                g.setEstilo(rs.getString("estilo"));
                g.setEsGrupo(rs.getBoolean("esgrupo"));
                g.setAnnoGrab(rs.getInt("annoGrab"));
                g.setFechaEstreno(rs.getDate("fechaEstreno"));
                g.setCompania(rs.getString("compania"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrar(rs, st);
        }
        Conn.cerrar();
        return g;
    }

    public static List<Cancion> cancionPorGrupo(Grupo grupo) {
        Connection con = Conn.getConexion();
        List<Cancion> canciones = new ArrayList<>();
        Statement st = null;
        String sql = "SELECT numcancion, grupo, duracion, titulo, total_votos FROM canciones WHERE grupo = " + grupo.getCodgrupo();
        ResultSet rs = null;
        try {
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Cancion c = new Cancion();
                c.setNumCancion(rs.getInt("numcancion"));
                c.setGrupo(grupo);
                c.setDuracion(rs.getTime("duracion"));
                c.setTitulo(rs.getString("titulo"));
                c.setVotos(rs.getInt("total_votos"));
                if (Func.opcionVotos(c).toUpperCase().charAt(0) == 'S') {
                    rs.updateInt("total_votos", rs.getInt("total_votos") + 1);
                    c.setVotos(c.getVotos()+1);
                    rs.updateRow();
                }
                canciones.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Conn.cerrar();
        return canciones;
    }

    public static void ultioms10Votos() {
        Scanner t = new Scanner(System.in);
        Connection con = Conn.getConexion();
        try {
            con.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Statement st = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        ResultSet rs4 = null;
        String nuevo = "";
        String viejo = "";
        int cancion = 0;
        try {
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery("SELECT usuario,fecha,cancion FROM votos ORDER BY fecha DESC LIMIT 10");
            while (rs.next()) {
                viejo = rs.getString("usuario");
                cancion = rs.getInt("cancion");
                System.out.println("Usuario: " + rs.getString("usuario")+" - Cancion: "+rs.getInt("cancion"));
                switch(Func.opcionUsuario()){
                    case 1:
                        System.out.println("Introduce el nuevo usuario");
                        try {
                            nuevo = t.nextLine();
                            rs.updateString("usuario",nuevo);
                            rs.updateRow();
                            rs = st.executeQuery("SELECT user, numvotos FROM usuarios where user = '"+viejo+"'");
                            rs.updateInt("numvotos",rs.getInt("numvotos")-1);
                            rs.updateRow();
                            rs = st.executeQuery("SELECT user, numvotos FROM usuarios where user = '"+nuevo+"'");
                            rs.updateInt("numvotos",rs.getInt("numvotos")+1);
                            rs.updateRow();

                        }catch (SQLException e){
                            System.out.println("Error: "+e.getErrorCode()+e.getMessage());
                        }
                        break;
                    case 2:
                        rs.deleteRow();
                        rs = st.executeQuery("SELECT user, numvotos FROM usuarios where user = '"+viejo+"'");
                        rs.updateInt("numvotos",rs.getInt("numvotos")-1);
                        rs.updateRow();
                        rs = st.executeQuery("SELECT numcancion, total_votos FROM canciones where numcancion = '"+cancion+"'");
                        rs.updateInt("total_votos",rs.getInt("total_votos")-1);
                        rs.updateRow();
                        break;
                };
            }
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Conn.cerrar();
    }



    public static Cancion cancionPorId(int id) {
        Connection con = Conn.getConexion();
        Cancion c = new Cancion();
        Statement st = null;
        String sql = "SELECT numcancion, grupo, duracion, titulo, total_votos FROM canciones WHERE numcancion = " + id;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                c.setNumCancion(rs.getInt("numcancion"));
                c.setGrupo(grupoPorId(rs.getInt("grupo")));
                c.setDuracion(rs.getTime("duracion"));
                c.setTitulo(rs.getString("titulo"));
                c.setVotos(rs.getInt("total_votos"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public static Usuario usuarioPorUser(String us) {
        Connection con = Conn.getConexion();
        Usuario u = new Usuario();
        Statement st = null;
        String sql = "SELECT user, contraseña, nombre, apellidos, fechanac,numvotos FROM usuarios WHERE user = '" + us + "'";
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                u.setUser(rs.getString("user"));
                u.setPassword(rs.getString("contraseña"));
                u.setNombre(rs.getString("nombre"));
                u.setApellidos(rs.getString("apellidos"));
                u.setFnac(rs.getDate("fechanac").toLocalDate());
                u.setNumVotos(rs.getInt("numvotos"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

    private static boolean cerrar (ResultSet rs, Statement st){
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
            System.out.println("Error: " + ex.getErrorCode() + ex.getMessage());
        }
        return cerrado;
    }

}
