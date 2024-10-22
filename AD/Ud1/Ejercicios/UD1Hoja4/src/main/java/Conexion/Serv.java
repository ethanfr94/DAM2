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
            st.close();
            rs.close();
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
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);// Para poder actualizar el ResultSet con los nuevos datos
            rs = st.executeQuery(sql);// Busca las canciones del grupo
            while (rs.next()) {
                Cancion c = new Cancion();
                c.setNumCancion(rs.getInt("numcancion"));
                c.setGrupo(grupo);
                c.setDuracion(rs.getTime("duracion"));
                c.setTitulo(rs.getString("titulo"));
                c.setVotos(rs.getInt("total_votos"));
                if (Func.opcionVotos(c).toUpperCase().charAt(0) == 'S') {// Si el usuario quiere votar la cancion se suma un voto
                    rs.updateInt("total_votos", rs.getInt("total_votos") + 1);
                    c.setVotos(c.getVotos()+1);// Actualiza el objeto cancion con el nuevo valor de votos
                    rs.updateRow();// Actualiza la fila con los nuevos datos
                }
                canciones.add(c);// Añade la cancion a la lista
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            cerrar(rs, st);
        }
        Conn.cerrar();
        return canciones;
    }

    public static void ultioms10Votos() {
        Scanner t = new Scanner(System.in);
        Connection con = Conn.getConexion();
        Statement st = null;
        ResultSet rs = null;
        String nuevo = "";
        String viejo = "";
        int cancion = 0;
        try {
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);// Para poder actualizar el ResultSet con los nuevos datos
            rs = st.executeQuery("SELECT usuario, fecha, cancion FROM votos ORDER BY fecha DESC LIMIT 10");
            while (rs.next()) {
                viejo = rs.getString("usuario");
                cancion = rs.getInt("cancion");
                System.out.println("Usuario: " + viejo+" - Cancion: "+cancion);
                switch(Func.opcionUsuario()){// Opcion para modificar el usuario
                    case 1:
                        System.out.println("Introduce el nuevo usuario");
                        try {
                            nuevo = t.nextLine();
                            rs.updateString("usuario",nuevo);// Actualiza el campo usuario con el nuevo valor
                            rs.updateRow();// Actualiza la fila con los nuevos datos
                            restaVotosUsuario(viejo);// Resta un voto al usuario viejo
                            sumaVotosUsuario(nuevo);// Suma un voto al usuario nuevo
                            break;
                        }catch (SQLException e){
                            System.out.println("Error: "+e.getErrorCode()+e.getMessage());
                        }
                    case 2:
                        rs.deleteRow();// Borra la fila actual
                        restaVotosUsuario(viejo);// Resta un voto al usuario
                        restaVotosCancion(cancion);// Resta un voto a la cancion
                        break;
                    default:
                        System.out.println("no se ha realizado ninguna accion");
                        break;
                };
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        cerrar(rs, st);
        Conn.cerrar();
    }



    public static boolean restaVotosUsuario(String user) {
        Connection con = Conn.getConexion();
        Statement st = null;
        ResultSet rs = null;
        boolean ok = false;
        try {
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);// Para poder actualizar el ResultSet con los nuevos datos
            rs = st.executeQuery("SELECT user, numvotos FROM usuarios where user = '" + user + "'");// Busca el usuario
            if (rs.next()) {
                int numvotos = rs.getInt("numvotos")-1;// Resta un voto al usuario
                rs.updateInt("numvotos", numvotos);// Actualiza el campo numvotos con el nuevo valor
                rs.updateRow();// Actualiza la fila con los nuevos datos
                ok = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            cerrar(rs, st);
        }
        return ok;
    }

    public static boolean sumaVotosUsuario(String user) {
        Connection con = Conn.getConexion();
        Statement st = null;
        ResultSet rs = null;
        boolean ok = false;
        try {
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);// Para poder actualizar el ResultSet con los nuevos datos
            rs = st.executeQuery("SELECT user, numvotos FROM usuarios where user = '" + user + "'");// Busca el usuario
            if (rs.next()) {
                int numvotos = rs.getInt("numvotos")+1;// Suma un voto al usuario
                rs.updateInt("numvotos", numvotos);// Actualiza el campo numvotos con el nuevo valor
                rs.updateRow();// Actualiza la fila con los nuevos datos
                ok = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            cerrar(rs, st);
        }
        return ok;
    }

    public static boolean restaVotosCancion(int cancion) {
        Connection con = Conn.getConexion();
        Statement st = null;
        ResultSet rs = null;
        boolean ok = false;
        try {
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);// Para poder actualizar el ResultSet con los nuevos datos
            rs = st.executeQuery("SELECT numcancion, total_votos FROM canciones where numcancion = '" + cancion + "'");// Busca la cancion
            if (rs.next()) {
                int totalvotos = rs.getInt("total_votos")-1;// Resta un voto a la cancion
                rs.updateInt("total_votos", totalvotos);// Actualiza el campo total_votos con el nuevo valor
                rs.updateRow();// Actualiza la fila con los nuevos datos
                ok = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            cerrar(rs, st);
        }
        return ok;
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
