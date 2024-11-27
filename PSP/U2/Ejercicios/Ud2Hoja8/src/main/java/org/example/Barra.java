package org.example;

public class Barra extends Thread{

    private Fiesta fiesta;

    public Barra(Fiesta fiesta) {
        this.fiesta = fiesta;

    }

    public void servir() {
        try {
            sleep(100);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
