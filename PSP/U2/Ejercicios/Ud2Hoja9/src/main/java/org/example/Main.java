package org.example;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {

        Semaphore capacidad = new Semaphore(50);
        Semaphore semaforoEntrada = new Semaphore(1);
        Semaphore semaforoSalida = new Semaphore(1);
        Parking parking = new Parking(semaforoEntrada, semaforoSalida, capacidad, 0);

        for (int i = 1; i <= 250; i++) {
            try {
                sleep((int) (Math.random() * 50));
                new Coche(parking, i).start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}