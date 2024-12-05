package org.example;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {

        Semaphore semaforoCapacidad = new Semaphore(0);
        Semaphore semaforoEntrada = new Semaphore(1);
        Semaphore semaforoSalida = new Semaphore(1);
        Parking parking = new Parking(semaforoEntrada, semaforoSalida, semaforoCapacidad, 50);



        for (int i = 1; i <= 250; i++) {
            try {
                if(i <= 50) {
                    int n = i + 250;
                    new CocheAparcado(parking, n).start();
                }
                sleep((int) (Math.random() * 50));
                new Coche(parking, i).start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }
}