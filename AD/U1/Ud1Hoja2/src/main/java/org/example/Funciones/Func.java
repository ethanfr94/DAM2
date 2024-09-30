package org.example.Funciones;

import org.example.Conexion.Conn;
import org.example.Modelos.Acts;
import org.example.Modelos.Charac;
import org.example.Modelos.Mov;
import org.example.Servicio.Serv;

import java.util.List;

public class Func {

    public static void menu() {
        int op;
        do {
            System.out.println("""
                    1 Obtener películas
                    2 Obtener personajes
                    3 Obtener personaje
                    4 Obtener personajes de películas
                    5 Obtener películas sin productora
                    6 Obtener número de personajes por película
                    7 Obtener película más antigua
                    8 Obtener películas por actor
                    9 Obtener películas sin personajes cargados
                    0 Salir del programa""");
            op = Integer.parseInt(System.console().readLine());
            switch (op) {
                case 1 -> verPelis(Serv.listaPelis());
                case 2 -> verPersonajes(Serv.listaPersonajes());
                case 3 -> Serv.heroeVillano();
                case 4 -> verActuaciones(Serv.listaActuaciones());// no carga titulo de pelicula ni el año
                case 5 -> sinProductora(Serv.listaPelis());
                case 6 -> Serv.intervenciones();
                case 7 -> verPelis(Serv.masAntigua());
                case 8 -> verPorActor(Serv.porActor());
                case 9 -> verSinPersonajes(Serv.sinPersonajes());
                case 0 -> {
                    System.out.println("cerrando el programa");
                    Conn.cerrar();
                }
                default -> System.out.println("opcion no valida");
            }
        } while (op != 0);
    }

    /////////////////////////////////////////////mostrar tablas////////////////////////////////////////////////////////////////////////////////////////

    public static void verPelis(List<Mov> pelis) {
        for (Mov m : pelis) {
            System.out.printf("%-4d %-15s %-5d %-4d %s\n",
                    m.getId(), m.getTitle(), m.getDuration(), m.getYear(), m.getProducer());
        }
    }

    public static void verPersonajes(List <Charac> ch) {
        for (Charac c : ch) {
            System.out.printf("%-4d %-15s %-55s %-15s %-15s %s\n",
                    c.getId(), c.getName(), c.getPowers(), c.getCompany(), c.getOrigin() == null?"sin cargar":c.getOrigin(), c.getIsHeroe()==1? "Heroe" : "Villano");
        }
    }

    public static void verActuaciones(List <Acts> act) {
        for (Acts a : act) {
            System.out.println(a.getMov().getTitle()+" - "+a.getMov().getYear()+" - "+a.getCharac().getName()+" - "+a.getActor());
        }
    }


    public static void sinProductora(List <Mov> pelis) {
        for (Mov m : pelis) {
            if(m.getProducer().equalsIgnoreCase("sin productora")){
                System.out.printf("%-4d %-50s %-5d %-4d\n",
                        m.getId(), m.getTitle(), m.getDuration(), m.getYear());
            }
        }
    }

    public static void verPorActor(List<Mov> pelis) {
        for (Mov m : pelis) {
            System.out.println(m.getTitle());
        }
    }

    public static void verSinPersonajes(List<Mov> pelis) {
        for (Mov m : pelis) {
            System.out.println(m.getTitle());
        }
    }



}
