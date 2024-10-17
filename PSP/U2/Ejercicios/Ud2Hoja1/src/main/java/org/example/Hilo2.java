package org.example;

public class Hilo2 extends Thread {
    public void run() {
        while(true) {
            System.out.println("Tac");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
