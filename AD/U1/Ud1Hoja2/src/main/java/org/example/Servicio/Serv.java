package org.example.Servicio;

import org.example.Conexion.Conn;

public class Serv {

    public static void menu() {
        int op;
        do {
            System.out.println("1 Obtener películas\n" +
                            "2 Obtener personajes\n" +
                            "3 Obtener personaje\n" +
                            "4 Obtener personajes de películas\n" +
                            "5 Obtener películas sin productora\n" +
                            "6 Obtener número de personajes por película\n" +
                            "7 Obtener película más antigua" +
                            "8 Obtener películas por actor\n" +
                            "9 Obtener películas sin personajes cargados");
            op = Integer.parseInt(System.console().readLine());
            switch (op) {
                case 1 ->
                case 2 ->
                case 3 ->
                case 4 ->
                case 5 ->
                case 6 ->
                case 7 ->
                case 8 ->
                case 9 ->
                case 0 -> {
                    System.out.println("cerrando el programa");
                    Conn.cerrar();
                }
                default -> System.out.println("opcion no valida");
            }
        } while (op != 0);
    }

    private static void listPelis(){

    }
}
