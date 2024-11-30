package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.example.GestorBaseDatos.GBD;
import org.example.Modelo.Cancion;
import org.example.Modelo.Grupo;
import org.example.Modelo.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

            Scanner t = new Scanner(System.in);
            GBD gbd = new GBD();

            int op;

            do{

                System.out.println("""
                    
                    1.- Listado de usuarios nacidos a partir de año …
                    2.- Grupos que tienen mas de N canciones
                    3.- Canciones de grupos
                    4.- Grupos de localidad con primer disco en año antes de año
                    5.- Grupos por localidad
                    0.- Salir
                    """);

                op = Integer.parseInt(t.nextLine());

                switch(op){
                    case 1->{
                        System.out.println("Introduce el año");
                        int year = Integer.parseInt(t.nextLine());
                        List<Usuario> usuarios = gbd.nacidosDespues(year);
                        for(Usuario u: usuarios){
                            System.out.println(u.getNombre());
                        }
                    }
                    case 2->{
                        System.out.println("Introduce el numero de canciones");
                        int n = Integer.parseInt(t.nextLine());
                        List<Grupo> grupos = gbd.gruposConMasCanciones(n);
                        for(Grupo g: grupos){
                            System.out.println(g.getNombre());
                        }

                    }
                    case 3->{
                        String grupo;
                        List<String> grupos = new ArrayList<>();
                        do{
                            System.out.println("Introduce el nombre de un grupo (fin para terminar)");
                            if(t.nextLine().equalsIgnoreCase("fin")) {
                                break;
                            }
                            grupo = t.nextLine();
                            grupos.add(grupo);
                        }while(!grupo.equalsIgnoreCase("fin"));
                        List<Cancion> canciones = gbd.getCancionesGrupos(grupos);
                        for(Cancion c: canciones){
                            System.out.println(c.getTitulo() + " -- " + c.getGrupo().getNombre());
                        }

                    }
                    case 4->{
                        System.out.println("Introduce la localidad");
                        String localidad = t.nextLine();
                        System.out.println("Introduce el año");
                        int year = Integer.parseInt(t.nextLine());
                        List<Grupo> grupos = gbd.gruposLocalidadYear(localidad, year);
                        for(Grupo g: grupos){
                            System.out.println(g.getNombre());
                        }
                    }
                    case 5->{
                        List<String> localidades = gbd.gruposLocalidad();
                        for(String l: localidades){
                            System.out.println(l);
                        }
                    }
                    case 0->{
                        System.out.println("Saliendo...");
                        System.exit(0);
                    }
                    default->{
                        System.out.println("Opcion no valida");
                    }
                }

            }while(true);



    }
}