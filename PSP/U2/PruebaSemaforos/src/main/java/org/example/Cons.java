package org.example;

import java.util.concurrent.Semaphore;

public class Cons extends Thread {
    private Cola cola;
    private int n;
    Semaphore prod;
    Semaphore cons;
    Semaphore mutex;

    public Cons (Cola c, int n, Semaphore prod, Semaphore cons, Semaphore mutex){
        cola = c;
        this.n =n;
        this.prod = prod;
        this.cons = cons;
        this.mutex = mutex;
    }
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                cons.acquire();
                mutex.acquire();
                n = cola.get(); //obtiene el numero
                System.out.println("Consumidor : " + n + ", consume: "+ n);
                mutex.release();
                prod.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

