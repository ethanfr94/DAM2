package org.example;

public class Cola {
    private int numero;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    private boolean disponible = false; //inicialmente cola vacia

    public  synchronized int get() {

            try {

                while (!disponible) { //hay numero en la cola?
                    wait(); //espera hasta que haya numero
                }
                --numero; //se consume el numero
                disponible = false; //se pone cola vacia
                notify(); //notifica al productor
                return numero; //se devuelve

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }

    public synchronized void put() {

            try {

                while(disponible) {
                    wait(); //espera hasta que se consuma el numero
                }
                numero++; //coloca valor en la cola
                disponible = true; //disponible para consumir, cola llena
                notify(); //notifica al consumidor

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }

}
