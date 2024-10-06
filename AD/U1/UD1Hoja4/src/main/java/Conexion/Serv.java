package Conexion;

import Modelo.Cancion;
import Modelo.Grupo;

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
        return g;
    }

    public static List<Cancion> cancionPorGrupo(Grupo grupo) {
        Scanner t = new Scanner(System.in);
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
                canciones.add(c);
                System.out.println("¿Desea incrementar el total de votos de la cancion "+rs.getString("titulo")+"? actual("+rs.getInt("total_votos")+") s/n");
                if (t.next().equalsIgnoreCase("s")) {
                    rs.updateInt("total_votos", rs.getInt("total_votos") + 1);
                    c.setVotos(c.getVotos()+1);
                    rs.updateRow();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return canciones;
    }

    public static void ultioms10Votos(){
        Connection con = Conn.getConexion();
        Statement st = null;
        String sql = "SELECT titulo, total_votos FROM canciones ORDER BY total_votos DESC LIMIT 10";
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("titulo") + " - " + rs.getInt("total_votos"));
            }
        } catch (Exception e) {
            e.printStackTrace();
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
