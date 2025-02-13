package org.example;

import java.util.concurrent.Semaphore;

/*
    Un taller mecánico tiene una sala de espera con 3 boxes y además un box donde
    el mecánico repara los coches.
    Si no hay clientes el mecánico se duerme. Si un cliente entra con su coche y los
    boxes están ocupados el cliente abandona el local. Si el mecánico está ocupado
    pero hay boxes libres el cliente aparca su coche en uno de los boxes libres. Si el
    mecánico está durmiendo el cliente lo despierta.
    Codifica el programa para 25 clientes que llegan en intervalos máximos de 50
    ms.
    Se ha de mostrar en pantalla mensajes sobre lo que hacen los clientes y el
    mecánico. Por ejemplo:
    Cliente7 ocupa un box. Quedan 2 boxes libres.
    Mecánico atiende a un cliente. Quedan 3 boxes libres
    Cliente12 se marcha porque no hay boxes libres.
    */

public class Mecanico extends Thread {
    private Taller taller;
    private Semaphore semaforoMecanico;
    private Semaphore semaforoReparacion;
    private Semaphore semaforoBoxes;


    public Mecanico(Taller t, Semaphore semaforoMecanico, Semaphore semaforoReparacion, Semaphore semaforoBoxes) {
        taller = t;
        this.semaforoMecanico = semaforoMecanico;
        this.semaforoReparacion = semaforoReparacion;
        this.semaforoBoxes = semaforoBoxes;
    }

    public void run() {
        try {
            while (true) {
                semaforoReparacion.acquire();  // Espera a que un cliente lo despierte
                System.out.println("Mecánico atiende a un cliente. Quedan "+taller.getLibres()+" boxes libres.");

                // Simula el trabajo del mecánico por un tiempo aleatorio
                sleep(50);

                System.out.println("Mecánico termina de atender a un cliente.");
                semaforoMecanico.release();  // El mecánico vuelve a dormir
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void reparar(){
        try {
            semaforoReparacion.acquire();
            System.out.println("Mecánico atiende a un cliente.");
            sleep(50);
            semaforoReparacion.release();
            semaforoMecanico.release();
            System.out.println("Cliente atendido.");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}



