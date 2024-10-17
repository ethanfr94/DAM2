package org.example;

public class Prod extends Thread {
    private Cola cola;
    private int n;

    public Prod (Cola c, int n){
        cola = c;
        this.n =n;
    }

    public void run() {
        for (int i = 0; i>=0; i++) {
            cola.put(i); //pone el número
            System.out.println(i+"=>Productor : " + n + ", produce: " + i);
            try {
                sleep(200);
            } catch (InterruptedException e) { }
        }
    }
}
