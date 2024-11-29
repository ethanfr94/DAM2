package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

            Scanner t = new Scanner(System.in);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("UDP");
            EntityManager em = emf.createEntityManager();

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

                    }
                    case 2->{

                    }
                    case 3->{

                    }
                    case 4->{

                    }
                    case 5->{

                    }
                    case 6->{


                    }
                    case 7->{

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