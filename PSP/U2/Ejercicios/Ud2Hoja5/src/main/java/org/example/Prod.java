package org.example;

import java.util.concurrent.Semaphore;

public class Prod extends Thread {

        private Cola cola;
        private String msg;
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
}