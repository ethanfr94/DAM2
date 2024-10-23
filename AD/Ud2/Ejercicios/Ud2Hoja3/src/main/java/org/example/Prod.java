package org.example;

public class Prod extends Thread {
    private Cola cola;
    private int n;

    public Prod (Cola c, int n){
        cola = c;
        this.n =n;
    }

    public void run() {
        for (int i = 0; i<=100; i++) {
            cola.put(); //pone el número
            System.out.println(i+"=>Productor  Existencias: "+cola.getNumero());
            try {
                sleep(200);
            } catch (InterruptedException e) { }
        }
    }
}
