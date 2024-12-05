package org.example;

public class CocheAparcado extends Thread{

        private Parking parking;
        private int id;

        public CocheAparcado(Parking p, int id) {
            parking = p;
            this.id = id;
        }

        public void run() {
            try {
                sleep((int) (Math.random() * 200));
                parking.salir(id);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

}
