package org.example;

import java.util.ArrayList;
import java.util.List;

public class Barra extends Thread{

    // Fiesta a la que asiste el cliente
    private Fiesta fiesta;
    // Número de la barra
    private int barra;
    // Variable para detener el hilo
    private boolean fin;

    public Barra(Fiesta fiesta, int barra){
        this.fiesta = fiesta;
        this.barra = barra;
        this.fin = false;
    }

    public void run()
    {
        try
        {
            // Mientras no se acabe la fiesta se sirven copas
            while(!fin)
            {
                // Si la barra es 1 se sirve en la derecha
                if(barra == 1)
                {
                    synchronized(fiesta) {

                        //si no hay cola o ya está sirviendo se espera
                        while (fiesta.cola_barra_der() == 0) {
                            try {
                                fiesta.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        // Se sirve la copa y se notifica a los demás hilos que estén esperando
                        Thread.sleep(100);
                        fiesta.sirve_copas_der();
                        System.out.println("--------El camarero DER sirve la copa " + fiesta.obtener_total_copas() + ".");
                        fiesta.notifyAll();
                    }
                }
                //mismo funcionamiento para la barra izquierda
                else {
                    // Si la barra es 0 se sirve en la izquierda
                    synchronized (fiesta) {
                        //si no hay cola o ya está sirviendo se espera
                        while (fiesta.cola_barra_izq() == 0) {
                            try {
                                fiesta.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        // Se sirve la copa y se notifica a los demás hilos que estén esperando

                        Thread.sleep(100);
                        fiesta.sirve_copas_izq();
                        System.out.println("------- El camarero IZQ sirve la copa " + fiesta.obtener_total_copas() + ".");
                        fiesta.notifyAll();
                    }
                }
            }
        }
        catch(Exception error) {}
    }

    public void detener()
    {
        this.fin=true;
    }

}
