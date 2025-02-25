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
    private Semaphore sMecanico;
    private Semaphore sCliente;
    private Semaphore mutex;


    public Mecanico(Taller t, Semaphore sMecanico, Semaphore sCliente, Semaphore mutex) {
        taller = t;
        this.sCliente = sCliente;
        this.sMecanico = sMecanico;
        this.mutex = mutex;
    }

    public void run() {
        try {
            do {
                System.out.println("   ");
                sCliente.acquire(); // Espera a que un cliente le requiera
                //mutex.acquire();
                System.out.println("Mecánico atiende a un cliente.");

                sleep(100);

                taller.out(); // Incrementa el número de boxes libres

                System.out.println("Cliente termina de ser atendido. Quedan " + taller.getLibres() + " boxes libres.");

                sMecanico.release();// termina de atender al cliente
                //mutex.release();
            }while(taller.getClientes() < 25);

            System.out.println("Fin de la jornada laboral");

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}



