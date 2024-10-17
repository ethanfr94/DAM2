package org.example;

public class Hilo1 extends Thread {
    public void run() {
        while(true) {
            System.out.println("Tic");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
