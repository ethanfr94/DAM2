package org.example;

import java.util.concurrent.Semaphore;

public class Parking {

    private Semaphore semaforoEntrada;
    private Semaphore semaforoSalida;
    private int capacidad;
    private int coches;

    public Parking(Semaphore semaforoEntrada, Semaphore semaforoSalida) {
        this.capacidad = 50;
        this.coches = 0;
        this.semaforoEntrada = semaforoEntrada;
        this.semaforoSalida = semaforoSalida;
    }

    public void entrar(int id){
        try{
            // Si hay sitio en el parking, el coche entra
            if(coches < capacidad){
                semaforoEntrada.acquire(); // Pide permiso para entrar
                // Sección crítica (entrada) -> Solo un hilo puede entrar a la vez
                synchronized (this) {
                    // Si hay sitio en el parking, el coche entra
                    coches++;
                    System.out.println("Coche " + id + " entra. Hay " + coches + " coches\n");
                }
                semaforoEntrada.release(); // Libera el semáforo de entrada
            }else {
                System.out.println("PARKING COMPLETO\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void salir(int id) {
        try{
            if(coches > 0){
                semaforoSalida.acquire();// Pide permiso para salir
                // Sección crítica (salida) -> Solo un hilo puede salir a la vez
                synchronized (this) {
                    // El coche sale del parking
                    coches--;
                    System.out.println("Coche " + id + " sale. Hay " + coches + " coches\n");
                }
                semaforoSalida.release(); // Libera el semáforo de salida
            }

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }




}
