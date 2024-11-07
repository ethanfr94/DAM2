package org.example;

import java.util.concurrent.Semaphore;

public class Cons extends Thread {

    private Cola cola;

    public Cons (Cola c){
        cola = c;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(cola.get());
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // asi seria con semaforos
    /*
    Semaphore prod;
    Semaphore cons;
    Semaphore mutex;

    public Cons (Cola c, Semaphore prod, Semaphore cons, Semaphore mutex){
        cola = c;
        this.prod = prod;
        this.cons = cons;
        this.mutex = mutex;
    }
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                cons.acquire();
                mutex.acquire();
                msg = cola.get(); //obtiene el numero
                System.out.println(msg);
                mutex.release();
                prod.release();
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
    */
}

