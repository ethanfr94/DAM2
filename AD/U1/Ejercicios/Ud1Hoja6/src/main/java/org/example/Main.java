package org.example;

import Conexion.Conn;
import Conexion.Serv;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*Realizar un programa inicia y mantiene la misma conexión a la base de datos durante toda su ejecución.
El programa presenta inicialmente los datos de todos los personajes y películas cargados.
A continuación, presenta un menú con las opciones:
1.- Añadir personaje
2.- Añadir película
3.- Añadir actuación
4.- Eliminar actuación
0.- Salir
Para cada caso de añadir, se piden los datos necesarios.
Al añadir personaje o película, no se permitirá añadir si respectivamente ya existe el nombre o el título.
Las validaciones para hacerlo, se deben hacer sobre la lista de películas y personajes
que se habrán obtenido para escribir su listado.
Para añadir la actuación, se validará primero sobre las listas de personajes y películas que el id del
personaje y de la película existen.
Al añadir ya a la tabla, se deberá detectar el error de que la actuación del personaje en la película ya esté registrada.
Tras realizar cualquiera de las acciones, se volverán a mostrar los datos de todos los personajes y de todas las películas. */

        Scanner t = new Scanner(System.in);
        Connection con = Conn.getConexion();

        do {
            System.out.println("\nPersonajes\n-------------------------------------------------");
            Serv.listarPersonajes(con).forEach(System.out::println);
            System.out.println("\nPeliculas\n-------------------------------------------------");
            Serv.mostrarPeliculas(con).forEach(System.out::println);
            System.out.println("""
                    \n
                    1.- Añadir personaje
                    2.- Añadir película
                    3.- Añadir actuación
                    4.- Eliminar actuación
                    0.- Salir\n""");
            int op = Integer.parseInt(t.nextLine());
            switch (op) {
                case 1 -> {
                    Serv.addPersonaje(con, t, Serv.listarPersonajes(con));
                }
                case 2 -> {
                    Serv.addPelicula(con, t, Serv.mostrarPeliculas(con));
                }
                case 3 -> {
                    Serv.addActuacion(con, t, Serv.listarPersonajes(con), Serv.mostrarPeliculas(con));
                }
                case 4 -> {
                    Serv.deleteActuacion(con, t);
                }
                case 0 -> {
                    System.out.println("Saliendo...");
                    Conn.cerrar();
                    System.exit(0);
                }
                default -> {
                    System.out.println("Opción no válida");
                }
            }
        } while (true);



    }



}