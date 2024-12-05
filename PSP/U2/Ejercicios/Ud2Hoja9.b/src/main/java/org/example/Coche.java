package org.example;

public class Coche extends Thread {
    private Parking parking;
    private int id;

    public Coche(Parking p, int id) {
        parking = p;
        this.id = id;
    }

    public void run() {
        try {
            parking.entrar(id);
            sleep((int) (Math.random() * 200));
            parking.salir(id);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
