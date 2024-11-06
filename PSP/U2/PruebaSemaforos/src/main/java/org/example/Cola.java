package org.example;

public class Cola {
    private int num;
    private boolean hay = false; //inicialmente cola vacia


    public int get() {
        num = -1;
        while (hay) { //hay numero en la cola?
            hay = false; //se pone cola vacia
            return num; //se devuelve
        }
        return num; //se devuelve -1 si no hay numero
    }


    public void put (int valor) {
        while (!hay) { //no hay numero en la cola?
            num = valor; //coloca valor en la cola
            hay = true; //disponible para consumir, cola llena
        }
    }

}
