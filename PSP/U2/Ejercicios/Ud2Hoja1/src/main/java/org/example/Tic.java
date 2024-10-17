package org.example;

public class Tic implements Runnable {
    public void run() {
        while(true) {
            System.out.println("Tic");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
