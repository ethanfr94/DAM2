package org.example;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Fiesta {
    // Número de clientes en la cola de la barra izquierda
    private int cola_izq = 0;
    // Número de clientes en la cola de la barra derecha
    private int cola_der = 0;

    // Número de copas servidas
    private int total_der = 0;
    private int total_izq = 0;

    // Número de copas servidas en total
    private int total_copas = 0;

    // Número de turnos de la barra izquierda y derecha
    private int total_turnos_izq = 0;
    private int total_turnos_der = 0;

    // Método para pedir turno en la barra derecha
    public synchronized void pedir_der(int numero)
    {
        // Se incrementa la cola de la barra derecha
        cola_der++;
        System.out.println("--------El cliente " + numero + " va a la barra derecha.");
        notifyAll();
    }
    // Método para beber en la barra derecha
    public synchronized void beber_der(int numero)
    {
        // Se obtiene el turno del cliente y se incrementa el total de turnos
        int turno = total_der;
        total_der++;
        // Mientras el turno del cliente sea mayor que el total de turnos de la barra derecha se espera
        while( turno > total_turnos_der)
        {
            try
            {
                //MostrarEstado("-----------El Cliente " + numero + " ESPERA PARA RECOGER LA COPA.------------");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        // Se incrementa el total de turnos de la barra derecha
        total_turnos_der++;
        notifyAll();
    }

    // Método para pedir turno en la barra izquierda
    public synchronized void pedir_izq(int numero)
    {
        // Se incrementa la cola de la barra izquierda
        cola_izq++;
        System.out.println("--------El Cliente" + numero + " va a la barra izquierda.");
        notifyAll();
    }

    // Método para beber en la barra izquierda
    public synchronized void beber_izq(int numero)
    {
        // Se obtiene el turno del cliente y se incrementa el total de turnos
        int turno = total_izq;
        total_izq++;
        // Mientras el turno del cliente sea mayor que el total de turnos de la barra izquierda se espera
        while(turno > total_turnos_izq)
        {
            try
            {
                //System.out.println("-----------El cliente " + numero + " ESPERA PARA RECOGER LA COPA.------------");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        // Se incrementa el total de turnos de la barra izquierda
        total_turnos_izq++;
        notifyAll();
    }

    // Método para obtener el número de clientes en la cola de la barra izquierda
    public synchronized int cola_barra_izq()
    {
        return cola_izq;
    }

    // Método para obtener el número de clientes en la cola de la barra derecha
    public synchronized int cola_barra_der()
    {
        return cola_der;
    }

    // Método para obtener el total de copas servidas
    public int obtener_total_copas()
    {
        return total_copas;
    }

    // Método para servir copas en la barra izquierda
    public synchronized void sirve_copas_izq()
    {
        // Se decrementa la cola de la barra izquierda y se incrementa el total de copas servidas
        cola_izq--;
        total_copas++;
    }
    // Método para servir copas en la barra derecha
    public synchronized void sirve_copas_der()
    {
        // Se decrementa la cola de la barra derecha y se incrementa el total de copas servidas
        cola_der--;
        total_copas++;
    }

}