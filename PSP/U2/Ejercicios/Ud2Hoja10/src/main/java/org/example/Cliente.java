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

public class Cliente extends Thread {
    private Taller taller;
    private Semaphore semaforoMecanico;
    private Semaphore semaforoReparacion;
    private Semaphore semaforoBoxes;
    private int id;

    public Cliente(Taller t, Semaphore semaforoMecanico, Semaphore semaforoReparacion, Semaphore semaforoBoxes, int id) {
        taller = t;
        this.id = id;
        this.semaforoMecanico = semaforoMecanico;
        this.semaforoReparacion = semaforoReparacion;
        this.semaforoBoxes = semaforoBoxes;
    }

    public void run() {
        try {
            Thread.sleep((long) (Math.random() * 50));  // Los clientes llegan aleatoriamente

            System.out.println("Cliente " + id + " llega al taller.");

            if (semaforoBoxes.tryAcquire()) {  // Intenta ocupar un box
                taller.in();
                System.out.println("Cliente " + id + " ocupa un box. Quedan " + taller.getLibres() + " boxes libres.");

                // Si el mecánico está dormido, el cliente lo despierta
                if (semaforoMecanico.tryAcquire()) {
                    System.out.println("Cliente " + id + " despierta al mecánico.");
                    semaforoReparacion.release();  // Despierta al mecánico

                    sleep(50);
                    semaforoBoxes.release();  // Libera el box
                    taller.out();
                    System.out.println("Cliente " + id + " ha terminado y libera su box. Quedan " + taller.getLibres() + " boxes libres.");
                } else {
                    System.out.println("Cliente " + id + " espera a que el mecánico termine.");
                }




            } else {
                System.out.println("Cliente " + id + " se marcha porque no hay boxes libres.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void ocuparBox() {
        if (taller.getLibres() == 0) {
            System.out.println("Cliente" + id + " se marcha porque no hay boxes libres.");
            return;
        } else {
            try {
                semaforoBoxes.acquire();
                taller.in();
                System.out.println("Cliente" + id + " ocupa un box. quedan " + taller.getLibres() + " huecos libres.");
                if(taller.getLibres() < 3) {
                    semaforoMecanico.release();
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void ocuparMecanico() {
        try {
            if(taller.getLibres() == 3) {
                semaforoMecanico.release();
            }
            semaforoMecanico.acquire();
            semaforoBoxes.release();
            taller.out();
            System.out.println("Cliente" + id + " ocupa al mecánico. Quedan " + taller.getLibres() + " huecos libres.");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }




}
