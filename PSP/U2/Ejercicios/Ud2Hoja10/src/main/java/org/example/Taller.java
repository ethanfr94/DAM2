package org.example;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

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

public class Taller {

    private int clientes;
    private int libres;

    public Taller(int plazas) {
        this.clientes = 0;
        this.libres = plazas;
    }

    public void in() {
        libres--;
    }
    public void out() { libres++; }
    public int getLibres() { return libres; }

    public void sumCliente() { clientes++; }
    public int getClientes() { return clientes; }


}
