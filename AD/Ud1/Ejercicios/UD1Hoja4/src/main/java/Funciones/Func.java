package Funciones;

import Conexion.Serv;
import Modelo.Cancion;
import Modelo.Grupo;
import Modelo.Votos;

import java.util.List;
import java.util.Scanner;

public class Func {

    public static void verCancionesGrupo() {
        Scanner t = new Scanner(System.in);
        System.out.println("introduce el codigo del grupo");
        Grupo g = Serv.grupoPorId(t.nextInt());
        List<Cancion> canciones = Serv.cancionPorGrupo(g);
        System.out.println("\t"+g.getNombre().toUpperCase());
        canciones.forEach(c -> System.out.printf("- %-20s - %-10s - %d\n",c.getTitulo(), c.getDuracion().toString(), c.getVotos()));
    }



    public static String opcionVotos(Cancion cancion) {
        Scanner t = new Scanner(System.in);
        System.out.println("¿Desea incrementar el total de votos de la cancion "+cancion.getTitulo()+"? actual("+cancion.getVotos()+") s/n");
        return t.nextLine();
    }

    public static int opcionUsuario() {
        Scanner t = new Scanner(System.in);
        int op = -1;
        System.out.println("1. Modificar Usuario\n2. Eliminar voto\n");
        op = Integer.parseInt(t.nextLine());
        return op;
    }
}
