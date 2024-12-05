package org.example;

import java.util.concurrent.Semaphore;

public class Parking {

    private Semaphore semaforoCapacidad;
    private Semaphore semaforoEntrada;
    private Semaphore semaforoSalida;
    private int capacidad;
    private int coches;

    public Parking(Semaphore semaforoEntrada, Semaphore semaforoSalida, Semaphore semaforoCapacidad, int aparcados)
        {
            this.capacidad = 50;
            this.coches = aparcados;
            this.semaforoEntrada = semaforoEntrada;
            this.semaforoSalida = semaforoSalida;
            this.semaforoCapacidad = semaforoCapacidad;
        }

        public void entrar ( int id){
            try {
                semaforoCapacidad.acquire(); // Pide permiso para entrar a la sección crítica

                // Si hay sitio en el parking, el coche entra

                semaforoEntrada.acquire(); // Pide permiso para entrar
                // Sección crítica (entrada) -> Solo un hilo puede entrar a la vez

                    // Si hay sitio en el parking, el coche entra
                    coches++;
                    System.out.println("Coche " + id + " entra. Hay " + coches + " coches\n");
                    if(coches == capacidad){
                        System.out.println("Parking lleno\n");
                    }

                semaforoEntrada.release(); // Libera el semáforo de entrada

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        public void salir (int id){
            try {
                semaforoSalida.acquire();// Pide permiso para salir
                // Sección crítica (salida) -> Solo un hilo puede salir a la vez
                    // El coche sale del parking
                    coches--;
                    System.out.println("Coche " + id + " sale. Hay " + coches + " coches\n");
                    /*if(coches == capacidad-1){
                        System.out.println("PLAZAS DISPONIBLES\n");
                    }*/
                semaforoSalida.release(); // Libera el semáforo de salida
                semaforoCapacidad.release(); // Libera el semáforo de capacidad


            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }



}
