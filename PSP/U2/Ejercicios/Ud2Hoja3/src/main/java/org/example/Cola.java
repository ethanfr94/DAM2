package org.example;

public class Cola {
    private int num;
    private boolean hay = false; //inicialmente cola vacia


    public synchronized int get() {

            while (!hay) { //hay numero en la cola?
                try{
                    wait(); //espera
                }catch (Exception e){}
            }
            hay = false; //se pone cola vacia
            notify(); //notifica a productor
            return num; //se devuelve

        //return (-1); //no hay numero disponible, cola vacia
    }


    public synchronized void put (int valor) {

            while (hay) { //hay numero en la cola?
                try{
                    wait(); //espera
                }catch (Exception e){}
            }
            num = valor; //coloca valor en la cola
            hay = true; //disponible para consumir, cola llena
            notify(); //notifica a consumidor

    }

}
