package org.example;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Main {

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

    public static void main(String[] args) {
        Semaphore sMecanico = new Semaphore(0);
        Semaphore sCliente = new Semaphore(0);
        Semaphore mutex = new Semaphore(1);

        Taller taller = new Taller(4);
        new Mecanico(taller, sMecanico, sCliente, mutex).start();

        for(int i = 0; i < 25; i++) {
            try {

                sleep((int) (Math.random() * 50));
                new Cliente(taller, sCliente, sMecanico, mutex, i).start();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }






    }
}