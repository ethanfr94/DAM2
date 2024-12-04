package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.Modelo.Solicitude;
import org.example.Servicio.Srv;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner t = new Scanner(System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UDP");
        EntityManager em = emf.createEntityManager();

        int op;

        do{
            System.out.println("""
                    
                    Selecciona una opcion:
                    
                    1. Agregar track
                    2. Actualizar datos por finalizacion de descargas
                    3. Añadir solucitud
                    4. Obtener track solicitados por usuario
                    5. Obtener datos de mas descargas
                    6. Eliminar registros de tracks no disponibles
                    0. Salir
                    """);

            op = Integer.parseInt(t.nextLine());
            switch(op){
                case 1->{
                    if(Srv.agragarTrack(em)) System.out.println("Track agregado correctamente");
                    else System.out.println("Error al agregar track");
                }
                case 2->{
                    if(Srv.ActualizarDatosPorFinalizacionDescargas(em)) System.out.println("Descargas actualizadas correctamente");
                    else System.out.println("Error al actualizar descargas");
                }
                case 3->{
                    if(Srv.addSolicitud(em)) System.out.println("Solicitud añadida correctamente");
                    else System.out.println("Error al añadir solicitud");
                }
                case 4->{
                    System.out.println("introduce usuario");
                    String usu = t.nextLine();
                    System.out.println("introduce contraseña");
                    String pass = t.nextLine();
                    List<Solicitude> solicitudes = Srv.porUsuarioId(em, usu, pass);
                    if(solicitudes == null) System.out.println("Usuario no encontrado");
                    else{
                        if (solicitudes.isEmpty()) System.out.println("El usuario no tiene solicitudes");
                        else{
                            System.out.println("Usuario: "+usu);
                            for (Solicitude sol: solicitudes){
                                System.out.println(sol.getAudio().getTitulo());
                            }
                        }
                    }
                }
                case 5->{
                    System.out.println("introduce numero de descargas");
                    int num = Integer.parseInt(t.nextLine());
                    List<String> datos = Srv.masDescargas(em, num);
                    for (String dato: datos){
                        System.out.println(dato);
                    }
                }
                case 6->{
                    if(Srv.eliminaNoDisponibles(em)) System.out.println("El usuario no tiene eliminado");
                    else System.out.println("Error al eliminar el usuario");
                }
                case 0->{
                    System.out.println("Saliendo...");
                }
                default -> {
                    System.out.println("Opcion no valida");
                }

            }


        }while(op != 0);

    }
}