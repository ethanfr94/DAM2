package Funciones;

import Modelo.Cancion;
import Modelo.Grupo;
import Modelo.Usuario;
import Servicio.Serv;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Func {

    public Usuario saveUser(){
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

    public static void menu(){
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
                    9.Modificar datos de grupo""");

            op = Integer.parseInt(new Scanner(System.in).nextLine());
            switch (op){
                case 1:
                    verGrupos(Serv.listarGrupos());
                    break;
                case 2:
                    verCanciones(Serv.listarCanciones());
                    break;
                case 3:
                    verCancionesGrupo(Serv.numCancionesGrupo());
                    break;
                case 4:
                    //cancionesGrupo();
                    break;
                case 5:
                    //cincoMasVotadas();
                    break;
                case 6:
                    //gruposSinCanciones();
                    break;
                case 7:
                    //ultimosVotos();
                    break;
                case 8:
                    //eliminarCancionesGrupo();
                    break;
                case 9:
                    //modificarGrupo();
                    break;
            }
        }while (op != 0);
    }

    private static void verGrupos(List<Grupo> gr){
        for (Grupo g : gr) {
            System.out.println(g.getCodgrupo() + " " + g.getNombre() + " " + g.getLocalidad() + " " + g.getEstilo());
        }
    }

    private static void verCanciones(List<Cancion> ca){
        for (Cancion c : ca) {
            System.out.println(c.getGrupo().getNombre());
                for (Cancion cancion : ca) {
                    if(cancion.getGrupo()==c.getGrupo())System.out.println(cancion.getTitulo());
                }
        }
    }

    private static void verCancionesGrupo(Map<String, Integer> map){
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }


}
