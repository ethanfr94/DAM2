package Servicio;

import Conexion.Conn;
import Modelo.Cancion;
import Modelo.Grupo;
import Modelo.Usuario;
import Modelo.Votos;

import java.sql.*;
import java.sql.Date;
import java.util.*;

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
        //Conn.cerrar(c);
        return add;
    }

    public static List<Grupo> listarGrupos(){
        Connection c = Conn.getConexion();
        ArrayList<Grupo> grupos = new ArrayList<>();
        Statement st = null;
        ResultSet rs = null;
        if (c != null) {
            String sql = "select codgrupo, nombre, localidad, estilo from grupos order by codgrupo";
            try{
            st = c.createStatement();
            rs = st.executeQuery(sql);
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
            }finally {
                cerrar(rs, st);
            }
        }
        //Conn.cerrar(c);
        return grupos;
    }

    public static Map<String,ArrayList<Cancion>> listarCanciones(){
        Connection c = Conn.getConexion();
        Map<String,ArrayList<Cancion>> canciones = new TreeMap<>();
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
                    if (canciones.containsKey(can.getGrupo().getNombre())) {
                        canciones.get(can.getGrupo().getNombre()).add(can);
                    } else {
                        ArrayList<Cancion> lista = new ArrayList<>();
                        lista.add(can);
                        canciones.put(can.getGrupo().getNombre(), lista);
                    }
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                System.out.println(ex.getErrorCode());
            } finally {
                cerrar(rs, st);
            }
        }
        //Conn.cerrar(c);
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
                cerrar(rs, st);
            }
        }
        //Conn.cerrar(c);
        return grupos;
    }

    public static ArrayList<Cancion> CancionesGrupo(String grupo){
        Connection c = Conn.getConexion();
        ArrayList<Cancion> canciones = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement st = null;
        if (c != null) {
            String sql = "select numcancion, titulo, duracion, total_votos, grupo, grupos.nombre from canciones inner join grupos on grupo=codgrupo where nombre = ?";
            try {
                st = Conn.getConexion().prepareStatement(sql);
                st.setString(1, grupo);
                rs = st.executeQuery();
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
                throw new RuntimeException(ex);
            } finally {
                cerrar(rs, st);
            }
        }
        //Conn.cerrar(c);
        return canciones;
    }

    public static Grupo grupoPorId(int codGrupo){
        Connection c = Conn.getConexion();
        Grupo g = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        if (c != null) {
            String sql = "select codgrupo, nombre, localidad, estilo, esgrupo, annoGrab, fechaEstreno, compania from grupos where codgrupo = ?";
            try {
                st = Conn.getConexion().prepareStatement(sql);
                st.setInt(1, codGrupo);
                rs = st.executeQuery();
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
            } catch (SQLException ex) {
                System.out.println(ex.getErrorCode());
            } finally {
                cerrar(rs, st);
            }
        }
        return g;
    }

    public static ArrayList<Cancion> masVotadas(){
        Connection c = Conn.getConexion();
        ArrayList<Cancion> canciones = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement st = null;
        if (c != null) {

            String sql = "select numcancion, titulo, duracion, total_votos, grupo from canciones order by total_votos desc limit 5";
            try {
                st = Conn.getConexion().prepareStatement(sql);
                rs = st.executeQuery();
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
                throw new RuntimeException(ex);
            } finally {
                cerrar(rs, st);
            }
        }
        //Conn.cerrar(c);
        return canciones;
    }

    public static ArrayList<Grupo> gruposSinCanciones(){
        Connection c = Conn.getConexion();
        ArrayList<Grupo> grupos = new ArrayList<>();
        ResultSet rs = null;
        Statement st = null;
        if (c != null) {
            String sql = "select codgrupo, nombre, localidad, estilo from grupos where codgrupo not in (select grupo from canciones)";
            try {
                st = Conn.getConexion().createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    Grupo g = new Grupo();
                    g.setCodgrupo(rs.getInt("codgrupo"));
                    g.setNombre(rs.getString("nombre"));
                    g.setLocalidad(rs.getString("localidad"));
                    g.setEstilo(rs.getString("estilo"));
                    grupos.add(g);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                System.out.println(ex.getErrorCode());
                throw new RuntimeException(ex);
            } finally {
                cerrar(rs, st);
            }
        }

        return grupos;
    }

    public static Map<String,String> ultimosVotos(){
        Connection c = Conn.getConexion();
        Map<String,String> votos = new LinkedHashMap<>();
        ResultSet rs = null;
        Statement st = null;
        if (c != null) {
            String sql = "select cancion, usuario, fecha, numcancion, titulo, codgrupo, grupo, grupos.nombre from votos inner join canciones on cancion=numcancion inner join grupos on codgrupo=grupo order by fecha desc limit 5";
            try {
                st = Conn.getConexion().createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    votos.put(rs.getString("usuario"), rs.getString("titulo"));
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                System.out.println(ex.getErrorCode());
                throw new RuntimeException(ex);
            } finally {
                cerrar(rs, st);
            }
        }
        //Conn.cerrar(c);
        return votos;
    }

    public static int eliminarPorGrupo(String grupo){
        Connection conn = Conn.getConexion();
        int nv = -1;
        int nc = -1;
        Grupo g = grupoPorNombre(grupo);
        if (conn != null) {
            if(g!=null){
                String sql = "delete from votos where cancion in (select numcancion from canciones where grupo = ?)";
                try (PreparedStatement st = Conn.getConexion().prepareStatement(sql);) {
                    st.setInt(1, g.getCodgrupo());
                    nv = st.executeUpdate();
                } catch (SQLException ex) {
                    System.out.println(ex.getErrorCode());
                }
                if(nv>0) {
                    sql = "delete from canciones where grupo = ?";
                    try (PreparedStatement st = Conn.getConexion().prepareStatement(sql);) {
                        st.setInt(1, g.getCodgrupo());
                        nc = st.executeUpdate();

                    } catch (SQLException ex) {
                        System.out.println(ex.getErrorCode());
                    }
                }
            }

        }
        //Conn.cerrar(conn);
        return nc;
    }

    public static int modificarPorGrupo(Grupo grupo){
        Connection conn = Conn.getConexion();
        Grupo g = grupoPorNombre(grupo.getNombre());
        int n= -1;
        String campo = "";
        String nombre = "";
        String localidad = "";
        String estilo = "";
        boolean esgrupo = false;
        int annoGrab = 0;
        Date fechaEstreno = null;
        String compania = "";
        if (conn != null) {
            if(g!=null){
                System.out.println("""
                Introduce el campo a modificar
                1.nombre
                2.localidad
                3.estilo
                4.esgrupo
                5.annoGrab
                6.fechaEstreno
                7.compania""");
                int op = Integer.parseInt(new Scanner(System.in).nextLine());
                switch (op){
                    case 1:
                        System.out.println("Introduce el nuevo nombre");
                        nombre = new Scanner(System.in).nextLine();
                        campo = "nombre";
                        break;
                    case 2:
                        System.out.println("Introduce la nueva localidad");
                        localidad = new Scanner(System.in).nextLine();
                        campo = "localidad";
                        break;
                    case 3:
                        System.out.println("Introduce el nuevo estilo");
                        estilo = new Scanner(System.in).nextLine();
                        campo = "estilo";
                        break;
                    case 4:
                        System.out.println("Introduce si es grupo o no");
                        esgrupo = Boolean.parseBoolean(new Scanner(System.in).nextLine());
                        campo = "esgrupo";
                        break;
                    case 5:
                        System.out.println("Introduce el nuevo año de grabacion");
                        annoGrab = Integer.parseInt(new Scanner(System.in).nextLine());
                        campo = "annoGrab";
                        break;
                    case 6:
                        System.out.println("Introduce la nueva fecha de estreno (yyyy-MM-dd)");
                        fechaEstreno = Date.valueOf(new Scanner(System.in).nextLine());
                        campo = "fechaEstreno";
                        break;
                    case 7:
                        System.out.println("Introduce la nueva compañia");
                        compania = new Scanner(System.in).nextLine();
                        campo = "compania";
                        break;
                    default:
                        System.out.println("opcion no valida");
                        break;
                }
                String sql = "update grupos set "+campo+" = ? where codgrupo = ?";
                try (PreparedStatement st = Conn.getConexion().prepareStatement(sql);) {
                    switch (op){
                        case 1:
                            st.setString(1, nombre);
                            break;
                        case 2:
                            st.setString(1, localidad);
                            break;
                        case 3:
                            st.setString(1, estilo);
                            break;
                        case 4:
                            st.setBoolean(1, esgrupo);
                            break;
                        case 5:
                            st.setInt(1, annoGrab);
                            break;
                        case 6:
                            st.setDate(1, fechaEstreno);
                            break;
                        case 7:
                            st.setString(1, compania);
                            break;
                    }
                    st.setInt(2, g.getCodgrupo());
                    n = st.executeUpdate();
                } catch (SQLException ex) {
                    System.out.println(ex.getErrorCode());
                    System.out.println(ex.getMessage());
                }
            }
        }
        //Conn.cerrar(conn);
        return n;
    }

    public static Grupo grupoPorNombre(String grupo){
        Connection c = Conn.getConexion();
        Grupo g = null;
        if (c != null) {
            String sql = "select codgrupo, nombre, localidad, estilo, esgrupo, annoGrab, fechaEstreno, compania from grupos where nombre = ?";
            try (PreparedStatement st = c.prepareStatement(sql);) {
                st.setString(1, grupo);
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
            System.out.println(ex.getErrorCode());
        }
        return cerrado;
    }

}
