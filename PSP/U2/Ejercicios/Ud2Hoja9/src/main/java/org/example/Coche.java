package org.example;

public class Coche extends Thread {
    private final Parking parking;
    private final int id;

    public Coche(Parking p, int id) {
        parking = p;
        this.id = id;
    }

    public void run() {
        try {
            parking.entrar(id);
            sleep((int) (Math.random() * 2000));
            parking.salir(id);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
