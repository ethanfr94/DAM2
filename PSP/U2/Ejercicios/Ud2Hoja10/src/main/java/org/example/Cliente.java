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
    private Semaphore sMecanico;
    private Semaphore sCliente;
    private Semaphore mutex;
    private int id;

    public Cliente(Taller t, Semaphore sCliente, Semaphore sMecanico, Semaphore mutex, int id) {
        taller = t;
        this.sCliente = sCliente;
        this.sMecanico = sMecanico;
        this.mutex = mutex;
        this.id = id;
    }

    public void run() {
        try {
            mutex.acquire();
            if (taller.getLibres() > 0) {

                taller.in(); // Decrementa el número de boxes libres
                taller.sumCliente(); // Aumenta el número de clientes
                System.out.println("Cliente" + id + " ocupa un box. Quedan " + taller.getLibres() + " boxes libres.");
                mutex.release(); // Libera el mutex para que otro cliente pueda entrar

                sMecanico.release();// Genera una orden para que el mecánico atienda al cliente

                sCliente.acquire(); // Espera a que el mecánico termine de atender al cliente

                System.out.println("Cliente" + id + " termina de ser atendido. Quedan " + taller.getLibres() + " boxes libres.");
                taller.out(); // Incrementa el número de boxes libres

            } else {
                System.out.println("Cliente" + id + " se marcha porque no hay boxes libres.");
                mutex.release(); // Libera el mutex para que otro cliente pueda entrar
            }

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
