package Funciones;

import Conexion.Serv;
import Modelo.Cancion;
import Modelo.Grupo;

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
}
