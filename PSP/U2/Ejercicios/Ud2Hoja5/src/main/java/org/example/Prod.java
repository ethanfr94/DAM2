package org.example;

import java.util.concurrent.Semaphore;

public class Prod extends Thread {

        private Cola cola;

        public Prod (Cola c){
            cola = c;
        }

        public void run() {
            for (int i = 0; i < 20; i++) {
                if(i%2==0){
                    cola.put("PING");
                }else{
                    cola.put("\tPONG");
                }
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

        public Prod (Cola c, Semaphore prod, Semaphore cons, Semaphore mutex){
            cola = c;
            this.prod = prod;
            this.cons = cons;
            this.mutex = mutex;
        }

        public void run() {
            for (int i = 0; i < 20; i++) {
                try {
                    prod.acquire();
                    mutex.acquire();
                    if(i%2==0){
                        msg = "PING";
                    }else{
                        msg = "\tPONG";
                    }
                    cola.put(msg); //pone el numero
                    mutex.release();
                    cons.release();
                    sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
        */
}