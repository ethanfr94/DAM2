package Servicio;

import Modelo.Emitido;
import Modelo.Usuario;
import Modelo.Video;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Serv {

    public static List<Video> videos(Connection con){
        List<Video> videos = new ArrayList<>();
        Statement st = null;
        ResultSet rs = null;
        if(con!=null){
            String sql = "select num_video, titulo, interprete, duracion, anno, num_emisiones, disponible from videos";
            try{
                st = con.createStatement();
                rs = st.executeQuery(sql);
                while(rs.next()){
                    Video v = new Video();
                    v.setNum_video(rs.getInt("num_video"));
                    v.setTitulo(rs.getString("titulo"));
                    v.setInterprete(rs.getString("interprete"));
                    v.setDuracion(rs.getTime("duracion"));
                    v.setNum_emisiones(rs.getInt("num_emisiones"));
                    v.setYear(rs.getInt("anno"));
                    v.setDisponible(rs.getBoolean("disponible"));
                    videos.add(v);
                    st.close();
                    rs.close();
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return videos;
    }
    public static List<Emitido> emitidos(Connection con){
        List<Emitido> emitidos = new ArrayList<>();
        Statement st = null;
        ResultSet rs = null;
        if(con!=null){
            String sql = "select num_emision, video, fecha, hora, num_peticiones from videos";
            try{
                st = con.createStatement();
                rs = st.executeQuery(sql);
                while(rs.next()){
                    Emitido e = new Emitido();
                    e.setNum_emision(rs.getInt("num_emision"));
                    e.setVideo(videoPorId(con, rs.getInt("num_emision")));
                    e.setFecha(rs.getDate("fecha"));
                    e.setHora(rs.getTime("hora"));
                    e.setNum_solicitudes(rs.getInt("num_peticiones"));
                    st.close();
                    rs.close();
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return emitidos;
    }

    public static Video videoPorId(Connection con, int numVideo) {
        Video v = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (con != null) {
            String sql = "select num_video, titulo, interprete, duracion, anno, num_emisiones, disponible from videos where num_video = ?";
            try {
                ps = con.prepareStatement(sql);
                ps.setInt(1, numVideo);
                rs = ps.executeQuery();
                if (rs.next()) {
                    v = new Video();
                    v.setNum_video(rs.getInt("num_video"));
                    v.setTitulo(rs.getString("titulo"));
                    v.setInterprete(rs.getString("interprete"));
                    v.setDuracion(rs.getTime("duracion"));
                    v.setNum_emisiones(rs.getInt("num_emisiones"));
                    v.setYear(rs.getInt("anno"));
                    v.setDisponible(rs.getBoolean("disponible"));
                    ps.close();
                    rs.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return v;
    }

    public static Usuario porId(Connection con, int numUsu) {
        Usuario u = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (con != null) {
            String sql = "select num_usu, usuario, contra, nombre, apellidos, fechanac, num_peticiones from usuarios where num_usu = ?";
            try {
                ps = con.prepareStatement(sql);
                ps.setInt(1, numUsu);
                rs = ps.executeQuery();
                if (rs.next()) {
                    u = new Usuario();
                    u.setNum_usu(rs.getInt("num_usu"));
                    u.setUsuario(rs.getString("usuario"));
                    u.setPass(rs.getString("contra"));
                    u.setNombre(rs.getString("nombre"));
                    u.setApellido(rs.getString("apellidos"));
                    u.setFechanac(rs.getDate("fechanac"));
                    u.setNum_peticiones(rs.getInt("num_peticiones"));
                    ps.close();
                    rs.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return u;
    }

    public static boolean modPeticiones(Connection con, int numUsu) {
        boolean ok = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (con != null) {
            String sql = "update usaurios set num_peticiones = num_peticiones + ? where num_usu = ?";
            try {
                ps = con.prepareStatement(sql);
                ps.setInt(1, peticionesUsuario(con, numUsu));
                ps.setInt(2, numUsu);
                rs = ps.executeQuery();
                if (rs.next()) {

                    ps.close();
                    rs.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return ok;
    }

    public static int peticionesUsuario(Connection con, int numUsu) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        int peticiones = -1;
        if (con != null) {
            String sql = "select count(*) as peticiones from solicitudes where num_usu = ?";
            try {
                ps = con.prepareStatement(sql);
                ps.setInt(1, numUsu);
                rs = ps.executeQuery();
                if (rs.next()) {
                    peticiones = rs.getInt("peticiones");
                    ps.close();
                    rs.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return peticiones;
    }

    public static Video porTitulo(Connection con, String titulo) {
        Video v = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (con != null) {
            String sql = "select num_video, titulo, interprete, duracion, anno, num_emisiones, disponible from videos where titulo = ?";
            try {
                ps = con.prepareStatement(sql);
                ps.setString(1, titulo);
                rs = ps.executeQuery();
                if (rs.next()) {
                    v = new Video();
                    v.setNum_video(rs.getInt("num_video"));
                    v.setTitulo(rs.getString("titulo"));
                    v.setInterprete(rs.getString("interprete"));
                    v.setDuracion(rs.getTime("duracion"));
                    v.setNum_emisiones(rs.getInt("num_emisiones"));
                    v.setYear(rs.getInt("anno"));
                    v.setDisponible(rs.getBoolean("disponible"));
                    ps.close();
                    rs.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return v;
    }

    public static List<Usuario> usuariosPorTitulo(Connection con, String titulo) {
        List<Usuario> usuarios = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (con != null) {
            String sql = "select solicitudes.num_usu as usuario from solicitudes inner join usuarios on usuarios.num_usu=solicitudes.num_usu inner join videos on solicitudes.video=videos.num_video where titulo = ?";
            try {
                ps = con.prepareStatement(sql);
                ps.setString(1, titulo);
                rs = ps.executeQuery();
                if (rs.next()) {
                    Usuario u = porId(con, rs.getInt("usuario"));
                    usuarios.add(u);
                    ps.close();
                    rs.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return usuarios;
    }

    public static void videosPorUsuario(Connection con, int numUsu) {

        List<String> videos = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (con != null) {
            String sql = "select num, titulo, fecha, hora from solicitudes inner join usuarios on usuarios.num_usu=solicitudes.num_usu inner join videos on solicitudes.video=videos.num_video where solicitudes.num_usu = ?";
            try {
                ps = con.prepareStatement(sql);
                ps.setInt(1, numUsu);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String titulo = rs.getString("titulo");
                    String fecha = rs.getDate("fecha").toString();
                    String hora = rs.getTime("hora").toString();
                    String datos = String.format("%-10s - %-10s - %-10s\n", titulo, fecha, hora);
                    videos.add(datos);
                    System.out.println(datos);
                    if(eliminarSolicitud(con, rs.getInt("num"))) System.out.println("soliciud eliminada");
                    ps.close();
                    rs.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static boolean eliminarSolicitud(Connection con, int numSolic) {
        boolean ok = false;
        Scanner t = new Scanner(System.in);
        Statement st = null;
        ResultSet rs = null;
        if (con != null) {
            String sql = "select num from solicitudes where num = " + numSolic + ";";
            try {
                st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs = st.executeQuery(sql);
                if (rs.next()) {
                    System.out.println("eliminar solicitud? (s para confirmar)");
                    String p = t.nextLine();
                    if (p.equalsIgnoreCase("s")) {
                        rs.deleteRow();
                        ok = true;
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return ok;
    }

    public static void emitir(Connection con){

        Statement st = null;
        ResultSet rs = null;
        if (con != null) {
            String sql = "select num_video, titulo, interprete, duracion, anno, num_emisiones, disponible from videos inner join solicitudes on video=num_video group by count(video) desc limit 1;";
            try {
                con.setAutoCommit(false);
                System.out.println("no dio tiempo");
                con.commit();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                try {
                    con.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }


}
