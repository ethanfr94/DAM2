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
                cons.acquire(); // coge el semaforo de cons para consumir y espera a que el productor lo libere
                mutex.acquire(); // coge el semaforo de mutex para acceder a la cola y espera a que el productor lo libere
                // cuando el productor libera el semaforo de mutex, el consumidor puede acceder a la cola
                n = cola.get(); //obtiene el numero
                System.out.println("Consumidor : " + n + ", consume: "+ n);
                mutex.release(); // libera el semaforo de mutex para que el productor pueda acceder a la cola
                prod.release(); // libera el semaforo de prod para que el productor pueda producir
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

