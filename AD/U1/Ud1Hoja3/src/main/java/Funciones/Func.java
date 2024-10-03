package Funciones;

import Modelo.Cancion;
import Modelo.Grupo;
import Modelo.Usuario;
import Servicio.Serv;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Func {

    public Usuario saveUser() {
        Scanner t = new Scanner(System.in);
        System.out.println("introduce usuario");
        String user = t.nextLine();
        System.out.println("introduce contraseña");
        String password = t.nextLine();
        System.out.println("introduce nombre");
        String nombre = t.nextLine();
        System.out.println("introduce apellidos");
        String apellidos = t.nextLine();
        System.out.println("introduce fecha de nacimiento");
        String fnac = t.nextLine();
        System.out.println("introduce numero de votos");
        int numVotos = Integer.parseInt(t.nextLine());

        Usuario u = new Usuario(user, password, nombre, apellidos, LocalDate.parse(fnac), numVotos);

        return u;
    }

    public static void menu() {
        int op;
        do {
            System.out.println("""
                    1.Listado de grupos
                    2.Listado de canciones
                    3.Numero de canciones por grupo
                    4.Canciones de un grupo
                    5.Las 5 canciones mas votadas
                    6.Grupos sin canciones
                    7.Los ultimos 5 votos
                    8.Eliminar canciones de un grupo
                    9.Modificar datos de grupo
                    0.Salir""");

            op = Integer.parseInt(new Scanner(System.in).nextLine());
            switch (op) {
                case 1:
                    verGrupos(Serv.listarGrupos());
                    break;
                case 2:
                    verCanciones(Serv.listarCanciones());
                    break;
                case 3:
                    verCancionesGrupos(Serv.numCancionesGrupo());
                    break;
                case 4:
                    cancionesGrupo();
                    break;
                case 5:
                    cincoMasVotadas();
                    break;
                case 6:
                    gruposSinCanciones();
                    break;
                case 7:
                    ultimosVotos(Serv.ultimosVotos());
                    break;
                case 8:
                    eliminarCancionesGrupo();
                    break;
                case 9:
                    modificarDatosGrupo();
                    break;
                case 0:
                    System.out.println("adios");
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        } while (op != 0);
    }

    private static void verGrupos(List<Grupo> gr) {
        for (Grupo g : gr) {
            System.out.println(g.getCodgrupo() + " " + g.getNombre() + " " + g.getLocalidad() + " " + g.getEstilo());
        }
        System.out.println();
    }

    private static void verCanciones(Map<String, ArrayList<Cancion>> ca) {
        for (Map.Entry<String, ArrayList<Cancion>> entry : ca.entrySet()) {
            System.out.println(entry.getKey());
            for (Cancion c : entry.getValue()) {
                System.out.println("\t" + c.getTitulo());
            }
        }
        System.out.println();
    }

    private static void verCancionesGrupos(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();
    }

    private static void cancionesGrupo() {
        Scanner t = new Scanner(System.in);
        System.out.println("introduce el grupo");
        String grupo = t.nextLine();
        List<Cancion> canciones = Serv.CancionesGrupo(grupo);
        for (Cancion c : canciones) {
            System.out.println(c.getNumCancion() + " " + c.getTitulo() + " " + c.getDuracion());
        }
        System.out.println();
    }

    public static void cincoMasVotadas() {
        List<Cancion> canciones = Serv.masVotadas();
        for (Cancion c : canciones) {
            System.out.println(c.getTitulo() + " - " + c.getGrupo().getNombre());
        }
        System.out.println();
    }

    public static void gruposSinCanciones() {
        List<Grupo> grupos = Serv.gruposSinCanciones();
        for (Grupo g : grupos) {
            System.out.println(g.getNombre());
        }
        System.out.println();
    }

    public static void ultimosVotos(Map<String, String> votos) {
        for (Map.Entry<String, String> entry : votos.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();
    }

    public static void eliminarCancionesGrupo() {

        Scanner t = new Scanner(System.in);
        System.out.println("introduce el grupo");
        String grupo = t.nextLine();
        System.out.println("se han eliminado " + Serv.eliminarPorGrupo(grupo) + " filas");
    }

    public static void modificarDatosGrupo() {
        Scanner t = new Scanner(System.in);
        System.out.println("introduce el grupo");
        String grupo = t.nextLine();
        Grupo g = Serv.grupoPorNombre(grupo);
        if (g != null) {
            System.out.println("grupo: " + g.getNombre() + " estilo: " + g.getEstilo() + " año de primera grabacion: " + g.getAnnoGrab() + " fecha primera actuacion: " + g.getFechaEstreno() + " localidad: " + g.getLocalidad() + " compañia: " + g.getCompania());
            int n = Serv.modificarPorGrupo(g);
            System.out.println("se han modificado " + n + " filas");
        }
    }
}
