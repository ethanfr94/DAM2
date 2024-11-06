package org.example;

import java.util.concurrent.Semaphore;

public class Prod extends Thread {

        private Cola cola;
        private int n;
        Semaphore prod;
        Semaphore cons;
        Semaphore mutex;

        public Prod (Cola c, int n, Semaphore prod, Semaphore cons, Semaphore mutex){
            cola = c;
            this.n =n;
            this.prod = prod;
            this.cons = cons;
            this.mutex = mutex;
        }

        public void run() {
            for (int i = 0; i < 20; i++) {
                try {
                    prod.acquire();
                    mutex.acquire();
                    cola.put(n); //pone el numero
                    System.out.println("Productor : " + n + ", produce: " + n + "-----------------------------------");
                    mutex.release();
                    cons.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
}