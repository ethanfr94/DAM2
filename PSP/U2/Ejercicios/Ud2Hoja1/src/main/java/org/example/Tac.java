package org.example;

public class Tac implements Runnable {
    public void run() {
        while(true) {
            System.out.println("Tac");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
