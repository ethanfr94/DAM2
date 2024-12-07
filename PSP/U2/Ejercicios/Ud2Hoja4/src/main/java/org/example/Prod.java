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
                    prod.acquire(); // coge el semaforo de prod para producir y espera a que el consumidor lo libere
                    mutex.acquire(); // coge el semaforo de mutex para acceder a la cola y espera a que el consumidor lo libere
                    // cuando el consumidor libera el semaforo de mutex, el productor puede acceder a la cola
                    cola.put(n); //pone el numero
                    System.out.println("Productor : " + n + ", produce: " + n + "-----------------------------------");
                    mutex.release(); // libera el semaforo de mutex para que el consumidor pueda acceder a la cola
                    cons.release(); // libera el semaforo de cons para que el consumidor pueda consumir
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
}